package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class d extends Application {

	public static void main(String[] args) {
	   Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("LoginAdmin.fxml"));
		Scene s=new Scene(root);
		arg0.setScene(s);
		arg0.show();
		
		
		Parent root1=FXMLLoader.load(getClass().getResource("Care.fxml"));
		Scene s1=new Scene(root1);
		Stage ss=new Stage();
		ss.setScene(s1);
		ss.show();
		
		Parent root2=FXMLLoader.load(getClass().getResource("Housing.fxml"));
		Scene s2=new Scene(root2);
		Stage ss2=new Stage();
		ss2.setScene(s2);
		ss2.show();
		
		
		
	}

}
