package application;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;

public class AddEmployeeController {
	ObservableList<String> employeeList=FXCollections.observableArrayList("Admin");
	@FXML
	private TextField ssntext;
	@FXML
	private TextField nametext;
	@FXML
	private TextField numtext;
	@FXML
	private TextField emailtext;
	@FXML
	private TextField salarytext;
	@FXML
	private TextField VetId;
	@FXML
	private PasswordField passText;
	@FXML
	private ChoiceBox<String> selectemp;
	@FXML
	private Label label;
	@FXML
    private Button add;
	@FXML
	private RadioButton Vet;
	@FXML
	private RadioButton Employee;
	@FXML
	private ToggleGroup Emp;
	
	@FXML
	private void initialize() {
		selectemp.setItems(employeeList);
		selectemp.setValue("");
		
	}
	@FXML
	public void radioButtonSelect() {
		if ( Emp.getSelectedToggle().equals(Vet)) {
			label.setVisible(true);
			VetId.setVisible(true);
			employeeList.add(Vet.getText());
			
		}else if (Emp.getSelectedToggle().equals(Employee)) {
			label.setVisible(false);
			VetId.setVisible(false);
			employeeList.add(Employee.getText());
			
			
		}
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void CreateEmp(ActionEvent event) {
		try {
		Employees rc;
		rc = new Employees(Integer.parseInt(ssntext.getText()),nametext.getText(), emailtext.getText(),selectemp.getValue(),numtext.getText(),Integer.parseInt(salarytext.getText()),passText.getText());
	    Employees.emp=rc;
		insertData(rc);
		Vets rc1=new Vets(Integer.parseInt(ssntext.getText()),Integer.parseInt(VetId.getText()));
		Vets.v=rc1;
		insertData(rc1);
		ssntext.clear();
		nametext.clear();
		emailtext.clear();
		numtext.clear();
		salarytext.clear();
		passText.clear();
		VetId.clear();
	
	} catch (Exception e) {
	    e.getStackTrace();
		}
		

		}
		
	private void insertData(Employees rc) {

		try {
		

			Connector.a.connectDB();
			String sql ="Insert into Employees (e_ssn,e_name, e_email,e_Role,e_phonenum, e_salary,e_password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) Connector.a.connectDB().prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1, rc.getE_ssn());
			ps.setString(2, rc.getE_name());
			ps.setString(3,rc.getE_email());
			ps.setString(4, rc.getE_Role());
			ps.setString(5, rc.getE_phoneNum());
			ps.setInt(6, rc.getE_salary());
			ps.setString(7, rc.getE_password());
			ps.execute();
			Stage stage;
			stage = (Stage) add.getScene().getWindow();
			stage.close();
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	private void insertData(Vets rc) {
		try {
			Connector.a.connectDB();
			String sql ="Insert into Vets (veteran_id,e_ssn) values(?,?)";
			PreparedStatement ps = (PreparedStatement) Connector.a.connectDB().prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1, rc.getVeteran_id());
			ps.setInt(2, rc.getE_ssn());
			ps.execute();
			Stage stage;
			stage = (Stage) add.getScene().getWindow();
			stage.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}
