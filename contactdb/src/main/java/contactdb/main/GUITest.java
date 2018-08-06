package contactdb.main;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUITest extends Application {

	@Override
	public void start(Stage stage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("ContactGUI.fxml"));
//		Scene scene = new Scene(root, 1920, 1080);
//		

		URL url = this.getClass().getClassLoader().getResource("ContactGUI.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

	public void main(String[] args)
	{
		Application.launch(GUITest.class, args);
	}
}
