package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class CareController {
	static CareController  c;
	private ArrayList<VeterinaryCare> data;
	private ObservableList<VeterinaryCare> dataList;
	@FXML ToggleGroup C;
	@FXML
	public RadioButton showerR;
	@FXML
	public RadioButton cuttingR;
	@FXML
	public RadioButton shavingR;
	@FXML
	public TableView<VeterinaryCare> TablePet;
	@FXML
	public TextField SearchText;

	@FXML
	private TableColumn<VeterinaryCare, String> CareType;

	@FXML
	private TableColumn<VeterinaryCare, String> Description;

	@FXML
	private TableColumn<VeterinaryCare, String> NamePet;

	@FXML
	private TableColumn<VeterinaryCare, Integer> Ownerssn;

	@FXML
	private TableColumn<VeterinaryCare, Integer> PetId;

	@FXML
	private TableColumn<VeterinaryCare, String> TypePet;

	public void initialize() {
		data = new ArrayList<>();
		dataList = FXCollections.observableArrayList(data);

		TablePet.setEditable(true);

		Description.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, String>("Description"));
		Description.setCellFactory(TextFieldTableCell.<VeterinaryCare>forTableColumn());
		Description.setOnEditCommit((CellEditEvent<VeterinaryCare, String> t) -> {
			((VeterinaryCare) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setDescription(t.getNewValue());

			updateDescription(t.getRowValue().getCare_id(), t.getNewValue());
		});

		NamePet.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, String>("NamePet"));
		NamePet.setCellFactory(TextFieldTableCell.<VeterinaryCare>forTableColumn());
		NamePet.setOnEditCommit((CellEditEvent<VeterinaryCare, String> t) -> {
			((VeterinaryCare) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setNamePet(t.getNewValue());

			updateName(t.getRowValue().getCare_id(), t.getNewValue());
		});
		TypePet.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, String>("TypePet"));
		TypePet.setCellFactory(TextFieldTableCell.<VeterinaryCare>forTableColumn());
		TypePet.setOnEditCommit((CellEditEvent<VeterinaryCare, String> t) -> {
			((VeterinaryCare) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setTypePet(t.getNewValue());

			updateType(t.getRowValue().getCare_id(), t.getNewValue());
		});

		CareType.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, String>("CareType"));
		CareType.setCellFactory(TextFieldTableCell.<VeterinaryCare>forTableColumn());
		CareType.setOnEditCommit((CellEditEvent<VeterinaryCare, String> t) -> {
			((VeterinaryCare) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setCareType(t.getNewValue());

			updateCareType(t.getRowValue().getCare_id(), t.getNewValue());
		});

		PetId.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, Integer>("PetId"));
		PetId.setCellFactory(TextFieldTableCell.<VeterinaryCare, Integer>forTableColumn(new IntegerStringConverter()));

		Ownerssn.setCellValueFactory(new PropertyValueFactory<VeterinaryCare, Integer>("Ownerssn"));
		Ownerssn.setCellFactory(
				TextFieldTableCell.<VeterinaryCare, Integer>forTableColumn(new IntegerStringConverter()));

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

	private void getData() throws ClassNotFoundException, SQLException {
		String SQL;

		Connector.a.connectDB();
		System.out.println("Connection established");
		SQL = "select care_id,survice_id,ownerssn,careType,Description,NamePet,petId,Typepet from VeterinaryCare  order by care_id";
		java.sql.Statement stmt = Connector.a.connectDB().createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		while (rs.next())
			dataList.add(new VeterinaryCare(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
					Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6),
					Integer.parseInt(rs.getString(7)), rs.getString(8)));

		rs.close();
		stmt.close();
		Connector.a.connectDB().close();
		System.out.println("Connection closed" + data.size());

	}

	private void updateDescription(int care_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update VeterinaryCare  set Description  = '" + newValue + "' where care_id = '" + care_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateName(int care_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update  VeterinaryCare set NamePet  = '" + newValue + "' where care_id = '" + care_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateType(int care_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update VeterinaryCare  set TypePet  = '" + newValue + "' where care_id = '" + care_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateCareType(int care_id, String newValue) {
		try {

			Connector.a.connectDB();
			Connector.a.ExecuteStatement(
					"update VeterinaryCare  set CareType  = '" + newValue + "' where care_id = '" + care_id + "';");
			Connector.a.connectDB().close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// Event Listener on Button.onAction
	@FXML
	public void AddPet(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("AddPet.fxml"));
		Scene s = new Scene(root);
		Stage addPet = new Stage();
		addPet.setScene(s);
		addPet.show();
		if (VeterinaryCare.vc!=null) {
			dataList.add(VeterinaryCare.vc);
		}
		VeterinaryCare.vc=null;
		initialize();		
	}

	@FXML
	public void searchButton(ActionEvent event) {

	}

	@FXML
	public void DeleteButton(ActionEvent event) {
		ObservableList<VeterinaryCare> selectedRows = TablePet.getSelectionModel().getSelectedItems();
		ArrayList<VeterinaryCare> rows = new ArrayList<>(selectedRows);
		rows.forEach(row -> {
			TablePet.getItems().remove(row);
			try {
				System.out.println("delete from  VeterinaryCare where care_id=" + row.getCare_id() + ";");
				Connector.a.connectDB();
				Connector.a.ExecuteStatement("delete from VeterinaryCare where care_id='" + row.getCare_id() + "';");
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
