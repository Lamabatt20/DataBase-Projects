package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class MainPageFormController {
	@FXML
	private Menu ownersButton;
	@FXML
	private Menu petsButton;
	@FXML
	private Menu dashButton;
	
	
	@FXML
	public void petsButton(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddPetInHousing.fxml"));
		Scene s = new Scene(root);
		Stage addPet = new Stage();
		addPet.setScene(s);
		addPet.show();
		
	}


}
