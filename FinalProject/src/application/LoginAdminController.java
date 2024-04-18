package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;

public class LoginAdminController {
	@FXML
	private TextField userText;
	@FXML
	private PasswordField PassText;

	@FXML
	void initialize() {
		assert userText != null;
		assert PassText != null;

	}

	// Event Listener on Button.onAction
	@FXML
	public void LoginButton(ActionEvent event) {

		try {
			PreparedStatement st = Connector.a.connectDB()
					.prepareStatement("select * from Employees where e_name = ? AND e_password = ? ");
			st.setString(1, userText.getText());
			st.setString(2, PassText.getText());
			ResultSet r1 = st.executeQuery();

			if (userText.getText().isEmpty()) {
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("WARNING");
				a.setContentText("Please enter the user name");
				a.showAndWait();
				return;
			}
			if (PassText.getText().isEmpty()) {
				Alert a = new Alert(AlertType.WARNING);
				a.setTitle("WARNING");
				a.setContentText("Please enter the password");
				a.showAndWait();
				return;
			}
			if (r1.next()) {
				String empName;
				if (r1.getString(2).toLowerCase().equals(userText.getText().toLowerCase())
						&& (r1.getString(7).toLowerCase().equals(PassText.getText().toLowerCase()))&&( r1.getString(4).equals("admin"
								+ ""))) {
					empName = userText.getText().toLowerCase();
					String empPassword = PassText.getText().toLowerCase();
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
						Scene s = new Scene(root);
						Stage admin = new Stage();
						admin.setScene(s);
						admin.show();
					} catch (IOException e1) {

						Alert a = new Alert(AlertType.ERROR);
						a.setTitle("Error");
						a.setContentText("There is no account at this username and password, Try again");
						a.showAndWait();

					}

				} else {

					Alert a = new Alert(AlertType.ERROR);
					a.setTitle("Error");
					a.setContentText("There is no account at this username and password, Try again");
					a.showAndWait();

				}

			}
			

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
