package application;

import javafx.fxml.FXML;

import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class AddPetInHousingController {
	ObservableList<String> petList=FXCollections.observableArrayList("Dog","Cat");
	ObservableList<Room> roomList;
	boolean Add;
    ArrayList<Room> data;
	@FXML
	private RadioButton ownerR;
	@FXML
	private RadioButton StrayR;
	@FXML
	private ToggleGroup o1;
	@FXML
	private TextField Nametext;
	@FXML
	private TextField IDtext;
	@FXML
	private TextField TypeText;
	@FXML
	private TextArea Dtext;
	@FXML
	private Label ssnlabel;
	@FXML
	private TextField ssntext;
	@FXML
	private ChoiceBox<Room> selectNUmR;
	@FXML
	private ChoiceBox<String> selectType;
	@FXML
	private Label Namelabel1;
	@FXML
	private DatePicker dateText;
	@FXML
	private Label Namelabel11;
	@FXML
	private DatePicker DateText1;
	 @FXML
	 private Button Addp;
	
	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {
		selectType.setItems(petList);
		selectType.setValue("");
		
		data = new ArrayList<>();
		roomList = FXCollections.observableArrayList(data);
		selectNUmR.setItems(roomList);
		getData();
		
		
		
	}

	// Event Listener on RadioButton[#ownerR].onAction
	@FXML
	public void selectOwnerOrNot(ActionEvent event) {
		if (o1.getSelectedToggle().equals(ownerR) ) {
			
			ssntext.setVisible(true);
			ssnlabel.setVisible(true);
			
		}else if (o1.getSelectedToggle().equals(StrayR)) {
			
			ssntext.setVisible(false);
			ssnlabel.setVisible(false);
			
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void AddPet(ActionEvent event) {
		try {
			Housing rc;
			rc = new Housing(Integer.parseInt(ssntext.getText()),Dtext.getText(), Nametext.getText(),Integer.parseInt(IDtext.getText()),selectType.getValue(),DateText1.getValue().toString(),dateText.getValue().toString(),selectNUmR.getValue().getRoom_Num());
		    Housing.s=rc;
			insertData(rc);
			ssntext.clear();
			Nametext.clear();
		} catch (Exception e) {
		    e.getStackTrace();
			}
			
		
	}
	private void getData() throws ClassNotFoundException, SQLException {
		String SQL;

		Connector.a.connectDB();
		System.out.println("Connection established");
		SQL = "select Room_num,Room_availability  from Room  order by Room_num";
		java.sql.Statement stmt = Connector.a.connectDB().createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			if (rs.getBoolean(2)==true) {
		        Add = roomList.add(new Room(Integer.parseInt(rs.getString(1))));
			}
			
		}
		rs.close();
		stmt.close();
		Connector.a.connectDB().close();
		System.out.println("Connection closed" + data.size());

	}
	private void insertData(Housing rc) {

		try {

			Connector.a.connectDB();
			String sql ="Insert into Housing (Ownerssn, Description,Namepet,petid,Typepet,ToDate,fromDate,RoomNum) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) Connector.a.connectDB().prepareStatement(sql);
			System.out.println(sql);
			if (o1.getSelectedToggle().equals(ownerR)) {
			ps.setInt(1, rc.getOwnerssn());
			ps.setInt(2, rc.getSurvice_id());
			ps.setString(3,rc.getDescription());
			ps.setString(4, rc.getNamepet());
			ps.setInt(5, rc.getPetid());
			ps.setString(6, rc.getTypepet());
			ps.setString(7, rc.getToDate());
			ps.setString(8, rc.getFromDate());
			ps.setInt(9, rc.getRoomNum());
			ps.execute();
			Stage stage;
			stage = (Stage) Addp.getScene().getWindow();
			stage.close();
			}else if(o1.getSelectedToggle().equals(StrayR)) {
				ps.setInt(2, rc.getSurvice_id());
				ps.setString(3,rc.getDescription());
				ps.setString(4, rc.getNamepet());
				ps.setInt(5, rc.getPetid());
				ps.setString(6, rc.getTypepet());
				ps.setString(7, rc.getToDate());
				ps.setString(8, rc.getFromDate());
				ps.setInt(9, rc.getRoomNum());
				ps.execute();
				Stage stage;
				stage = (Stage) Addp.getScene().getWindow();
				stage.close();
			}
			
		} catch (SQLException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
}
