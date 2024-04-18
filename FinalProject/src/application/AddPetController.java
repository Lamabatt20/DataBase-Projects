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

import javafx.scene.control.TextArea;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class AddPetController {
	ObservableList<String> petList=FXCollections.observableArrayList("Dog","Cat");
	@FXML
	private Label Namelabel;
	@FXML
	private Label ssnlabel;
	@FXML
	private Label numlabel;
	@FXML
	private Label elabel;
	@FXML
	private ChoiceBox<String> selectType;
	@FXML
	private TextField idtext;
	@FXML
	private TextField Nametext;
	@FXML
	private TextArea Detext;
	@FXML
	private RadioButton ownerR;
	@FXML
	private RadioButton StrayR;
	@FXML
	private TextField Nametext1;
	@FXML
	private TextField ssntext;
	@FXML
	private TextField numtext;
	@FXML
	private TextField etext;
	@FXML
	private ToggleGroup o;
	 @FXML
	 private Button addp;
	
	@FXML
	private void initialize() {
		selectType.setItems(petList);
		selectType.setValue("");
		
	}

	// Event Listener on RadioButton[#ownerR].onAction
	@FXML
	public void selectOwnerOrNot(ActionEvent event) {
		if (o.getSelectedToggle().equals(ownerR)) {

			ssntext.setVisible(true);
			ssnlabel.setVisible(true);

		} else if (o.getSelectedToggle().equals(StrayR)) {
			ssntext.setVisible(false);

			ssnlabel.setVisible(false);
		}
	}
	// Event Listener on Button.onAction	
	@FXML
	public void addpet(ActionEvent event) {
		try {
			VeterinaryCare rc;
			rc = new VeterinaryCare(Integer.parseInt(ssntext.getText()),CareController.c.C.getSelectedToggle().toString(),Detext.getText(), Nametext.getText(),Integer.parseInt(idtext.getText()),selectType.getValue());
			VeterinaryCare.vc=rc;
			insertData(rc);
			ssntext.clear();
			Nametext.clear();
			Detext.clear();
			idtext.clear();
			
		} catch (Exception e) {
		    e.getStackTrace();
			}
			
		
	}
	private void insertData(VeterinaryCare rc) {

		try {

			Connector.a.connectDB();
			String sql ="Insert into VeterinaryCare (survice_id,Ownerssn,careType ,Description,Namepet,petid,Typepet) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) Connector.a.connectDB().prepareStatement(sql);
			System.out.println(sql);
			if (o.getSelectedToggle().equals(ownerR)) {
			ps.setInt(1, rc.getOwnerssn());
			ps.setInt(2, rc.getSurvice_id());
			ps.setString(3,rc.getDescription());
			ps.setString(4, rc.getNamePet());
			ps.setInt(5, rc.getPetId());
			ps.setString(6, rc.getTypePet());
			ps.setString(7, rc.getCareType());
			ps.execute();
			Stage stage;
			stage = (Stage) addp.getScene().getWindow();
			stage.close();
			}else if(o.getSelectedToggle().equals(StrayR)) {
				ps.setInt(2, rc.getSurvice_id());
				ps.setString(3,rc.getDescription());
				ps.setString(4, rc.getNamePet());
				ps.setInt(5, rc.getPetId());
				ps.setString(6, rc.getTypePet());
				ps.setString(7, rc.getCareType());
				ps.execute();
				Stage stage;
				stage = (Stage) addp.getScene().getWindow();
				stage.close();
			}
			
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
}
