package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HousingController {
	private ArrayList<Housing> data;
	private ObservableList<Housing> dataList;
	@FXML
	private TableView<Housing> TablePet;
	@FXML
	private TextField searchtext;
	@FXML
	private TableColumn<Housing, String> Description;

	@FXML
	private TableColumn<Housing, Integer> RoomNum;

	@FXML
	private TableColumn<Housing, String> ToDate;

	@FXML
	private TableColumn<Housing, String> Typepet;

	@FXML
	private TableColumn<Housing, String> fromDate;

	@FXML
	private TableColumn<Housing, String> Namepet;

	@FXML
	private TableColumn<Housing, Integer> Ownerssn;

	@FXML
	private TableColumn<Housing, Integer> petid;

	public void initialize() {
		data = new ArrayList<>();
		dataList = FXCollections.observableArrayList(data);

		TablePet.setEditable(true);

		Description.setCellValueFactory(new PropertyValueFactory<Housing, String>("Description"));
		Description.setCellFactory(TextFieldTableCell.<Housing>forTableColumn());
		Description.setOnEditCommit((CellEditEvent<Housing, String> t) -> {
			((Housing) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(t.getNewValue());

			updateDescription(t.getRowValue().getHousing_id(), t.getNewValue());
		});
		ToDate.setCellValueFactory(new PropertyValueFactory<Housing, String>("ToDate"));
		ToDate.setCellFactory(TextFieldTableCell.<Housing>forTableColumn());
		ToDate.setOnEditCommit((CellEditEvent<Housing, String> t) -> {
			((Housing) t.getTableView().getItems().get(t.getTablePosition().getRow())).setToDate(t.getNewValue());

			updateToDate(t.getRowValue().getHousing_id(), t.getNewValue());
		});
		Namepet.setCellValueFactory(new PropertyValueFactory<Housing, String>("Namepet"));
		Namepet.setCellFactory(TextFieldTableCell.<Housing>forTableColumn());
		Namepet.setOnEditCommit((CellEditEvent<Housing, String> t) -> {
			((Housing) t.getTableView().getItems().get(t.getTablePosition().getRow())).setNamepet(t.getNewValue());

			updateName(t.getRowValue().getHousing_id(), t.getNewValue());
		});
		Typepet.setCellValueFactory(new PropertyValueFactory<Housing, String>("Typepet"));
		Typepet.setCellFactory(TextFieldTableCell.<Housing>forTableColumn());
		Typepet.setOnEditCommit((CellEditEvent<Housing, String> t) -> {
			((Housing) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTypepet(t.getNewValue());

			updateType(t.getRowValue().getHousing_id(), t.getNewValue());
		});

		fromDate.setCellValueFactory(new PropertyValueFactory<Housing, String>("fromDate"));
		fromDate.setCellFactory(TextFieldTableCell.<Housing>forTableColumn());
		fromDate.setOnEditCommit((CellEditEvent<Housing, String> t) -> {
			((Housing) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFromDate(t.getNewValue());

			updateFromDate(t.getRowValue().getHousing_id(), t.getNewValue());
		});
		RoomNum.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("RoomNum"));
		RoomNum.setCellFactory(TextFieldTableCell.<Housing, Integer>forTableColumn(new IntegerStringConverter()));

		petid.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("petid"));
		petid.setCellFactory(TextFieldTableCell.<Housing, Integer>forTableColumn(new IntegerStringConverter()));
		Ownerssn.setCellValueFactory(new PropertyValueFactory<Housing, Integer>("Ownerssn"));
		Ownerssn.setCellFactory(TextFieldTableCell.<Housing, Integer>forTableColumn(new IntegerStringConverter()));
		try {
			getData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TablePet.setItems(dataList);

	}

	private void updateOwnerId(int housing_id, Integer newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set Ownerssn  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updatePetid(int housing_id, Integer newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set petid  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateRoomNum(int housing_id, Integer newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set RoomNum  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateFromDate(int housing_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set fromDate  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateType(int housing_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set Typepet  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateName(int housing_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set Namepet  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateToDate(int housing_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set ToDate  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateDescription(int housing_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  Housing set Description  = '" + newValue + "' where housing_id = '" + housing_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void getData() throws ClassNotFoundException, SQLException {

		String SQL;

		Connector.a.connectDB();
		System.out.println("Connection established");
		SQL = "select housing_id, Ownerssn,survice_id,Description,Namepet,petid,Typepet, ToDate,fromDate,RoomNum from Housing order by housing_id";
		java.sql.Statement stmt = Connector.a.connectDB().createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next())
			dataList.add(new Housing(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
					Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5),
					Integer.parseInt(rs.getString(6)), rs.getString(7), rs.getString(8), rs.getString(9),
					Integer.parseInt(rs.getString(10))));

		rs.close();
		stmt.close();
		Connector.a.connectDB().close();
		System.out.println("Connection closed" + data.size());

	}

	@FXML
	public void AddPet(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddPetInHousing.fxml"));
		Scene s = new Scene(root);
		Stage addPet = new Stage();
		addPet.setScene(s);
		addPet.show();
		
		/*if (Housing.s!=null) {
			dataList.add(Housing.s);
		}
		Housing.s=null;
		initialize();*/
	}

	@FXML
	public void searchButton(ActionEvent event) {

	}

	@FXML
	public void DeleteButton(ActionEvent event) {
		ObservableList<Housing> selectedRows = TablePet.getSelectionModel().getSelectedItems();
		ArrayList<Housing> rows = new ArrayList<>(selectedRows);
		rows.forEach(row -> {
			TablePet.getItems().remove(row);
			try {
				System.out.println("delete from  Housing where housing_id=" + row.getHousing_id() + ";");
				Connector.a.connectDB();
				Connector.a.ExecuteStatement("delete from  Housing where housing_id='" + row.getHousing_id() + "';");
				Connector.a.connectDB().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			TablePet.refresh();
			initialize();

		});

	}
}
