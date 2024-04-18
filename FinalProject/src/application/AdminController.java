package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class AdminController   {
	private ArrayList<Employees> data;
	private ObservableList<Employees> dataList;
	
	private ArrayList<Vets> data1;
	private ObservableList<Vets> dataList1;
	@FXML
	public TableView<Employees> TableEmployee;
	public TextField SearchText;
	@FXML
    private TableColumn<Employees, String> e_Role;

    @FXML
    private TableColumn<Employees, String> e_email;

    @FXML
    private TableColumn<Employees, String> e_name;

    @FXML
    private TableColumn<Employees, String> e_phoneNum;

    @FXML
    private TableColumn<Employees, Integer> e_salary;

    @FXML
    private TableColumn<Employees, Integer> e_ssn;
    @FXML
    private Button add;
    
    public void initialize() {
		data = new ArrayList<>();
  		dataList = FXCollections.observableArrayList(data);
  		
  		data1 = new ArrayList<>();
  		dataList1 = FXCollections.observableArrayList(data1);
  		TableEmployee.setEditable(true);
  		
  		e_Role.setCellValueFactory(new PropertyValueFactory<Employees, String>("e_Role"));
  		e_Role.setCellFactory(TextFieldTableCell.<Employees>forTableColumn());
  		e_Role.setOnEditCommit((CellEditEvent<Employees, String> t) -> {
			((Employees) t.getTableView().getItems().get(t.getTablePosition().getRow())).setE_Role(t.getNewValue());
			

			updateRole(t.getRowValue().getE_ssn(), t.getNewValue());
  		});
  		e_email.setCellValueFactory(new PropertyValueFactory<Employees, String>("e_email"));
  		e_email.setCellFactory(TextFieldTableCell.<Employees>forTableColumn());
  		e_email.setOnEditCommit((CellEditEvent<Employees, String> t) -> {
			((Employees) t.getTableView().getItems().get(t.getTablePosition().getRow())).setE_email(t.getNewValue());
			

			updateEmail(t.getRowValue().getE_ssn(), t.getNewValue());
  		});
  		e_name.setCellValueFactory(new PropertyValueFactory<Employees,String>("e_name"));
  		e_name.setCellFactory(TextFieldTableCell.<Employees>forTableColumn());
  		e_name.setOnEditCommit((CellEditEvent<Employees, String> t) -> {
			((Employees) t.getTableView().getItems().get(t.getTablePosition().getRow())).setE_name(t.getNewValue());
			

			updateName(t.getRowValue().getE_ssn(), t.getNewValue());
  		});
  		
  		e_phoneNum.setCellValueFactory(new PropertyValueFactory<Employees, String>("e_phoneNum"));
  		e_phoneNum.setCellFactory(TextFieldTableCell.<Employees>forTableColumn());
  		e_phoneNum.setOnEditCommit((CellEditEvent<Employees, String> t) -> {
			((Employees) t.getTableView().getItems().get(t.getTablePosition().getRow())).setE_phoneNum(t.getNewValue());
			

			updatephoneNum(t.getRowValue().getE_ssn(), t.getNewValue());
  		});
  		e_salary.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("e_salary"));
  		e_salary.setCellFactory(TextFieldTableCell.<Employees, Integer>forTableColumn(new IntegerStringConverter()));
  		e_salary.setOnEditCommit((CellEditEvent<Employees, Integer> t) -> {
			((Employees) t.getTableView().getItems().get(t.getTablePosition().getRow())).setE_salary(t.getNewValue());
			

			updateSalary(t.getRowValue().getE_ssn(), t.getNewValue());
  		});
  		e_ssn.setCellValueFactory(new PropertyValueFactory<Employees, Integer>("e_ssn"));
  		e_ssn.setCellFactory(TextFieldTableCell.<Employees, Integer>forTableColumn(new IntegerStringConverter()));
  		try {
			getData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		TableEmployee.setItems(dataList);
  		
		
	}


	
	@FXML
	public void HomeButton(ActionEvent event) {
	         
	}
	
	@FXML
	public void AddEmployee(ActionEvent event) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
			Scene s=new Scene(root);
			Stage addEmployee=new Stage();
			addEmployee.setScene(s);
			addEmployee.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Vets.v!=null) {
			dataList1.add(Vets.v );
		}
		if (Employees.emp != null) {
			dataList.add(Employees.emp );
			
		}
		
		Employees.emp =null;
		Vets.v=null;
		initialize();
		
	}
	@FXML
	public void searchButton(ActionEvent event) {
		
	}
	@FXML
	public void DeleteButton(ActionEvent event) {
		ObservableList<Employees> selectedRows = TableEmployee.getSelectionModel().getSelectedItems();
		ArrayList<Employees> rows = new ArrayList<>(selectedRows);
		rows.forEach(row -> {
			TableEmployee.getItems().remove(row);
			try {
				System.out.println("delete from  Employees where e_ssn=" + row.getE_ssn() + ";");
				Connector.a.connectDB();
				Connector.a.ExecuteStatement("delete from  Employees where e_ssn ='" + row.getE_ssn() + "';");
				Connector.a.connectDB().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			TableEmployee.refresh();
			initialize();
			
		});
		
		
	}
	private void updatephoneNum(int e_ssn, String newValue ) {
		try {
		
			Connector.a.connectDB();
			Connector.a.ExecuteStatement("update  Employees set e_phoneNum  = '" + newValue + "' where e_ssn = '"
					+ e_ssn + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void updateSalary(int e_ssn, int newValue ) {
		try {
		
			Connector.a.connectDB();
			Connector.a.ExecuteStatement("update  Employees set e_salary  = '" + newValue + "' where e_ssn = '"
					+ e_ssn + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void updateName(int e_ssn, String newValue ) {
		try {
		
			Connector.a.connectDB();
			Connector.a.ExecuteStatement("update  Employees set e_name  = '" + newValue + "' where e_ssn = '"
					+ e_ssn + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void updateEmail(int e_ssn, String newValue ) {
		try {
		
			Connector.a.connectDB();
			Connector.a.ExecuteStatement("update  Employees set e_email  = '" + newValue + "' where e_ssn = '"
					+ e_ssn + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void updateRole(int e_ssn, String newValue ) {
		try {
		
			Connector.a.connectDB();
			Connector.a.ExecuteStatement("update  Employees set e_Role  = '" + newValue + "' where e_ssn = '"
					+ e_ssn + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void getData() throws SQLException, ClassNotFoundException {

		String SQL;

		Connector.a.connectDB();
		System.out.println("Connection established");

		SQL = "select e_ssn,e_name, e_email,e_Role,e_phonenum, e_salary,e_password from Employees order by e_ssn";
		java.sql.Statement stmt = Connector.a.connectDB().createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next())
			dataList.add(new Employees(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
					Integer.parseInt(rs.getString(6)),rs.getString(7)));
		
		String SQL1;
		SQL1="select e_ssn,veteran_id from Vets order by veteran_id";
		java.sql.Statement stmt1 = Connector.a.connectDB().createStatement();
		ResultSet rs1 = stmt.executeQuery(SQL1);
		while (rs1.next())
			dataList1.add(new Vets(Integer.parseInt(rs1.getString(1)), 
					Integer.parseInt(rs1.getString(2))));
		
		
		
		rs.close();
		stmt.close();
		
		rs1.close();
		stmt1.close();
		Connector.a.connectDB().close();
		System.out.println("Connection closed" + data.size());

	}



	
	
}
