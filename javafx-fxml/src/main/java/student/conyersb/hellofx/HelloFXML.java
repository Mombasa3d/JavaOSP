package student.conyersb.hellofx;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class HelloFXML extends Application {

	public static void main(String[] args) {
		Application.launch(HelloFXML.class, args);

	}
	
	public void start(Stage stage) throws Exception {
		URL url = this.getClass().getClassLoader().getResource("fxml/HelloJFX.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
