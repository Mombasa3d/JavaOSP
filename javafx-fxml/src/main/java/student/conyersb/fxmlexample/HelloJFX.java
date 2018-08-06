package student.conyersb.fxmlexample;

import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HelloJFX {

	@FXML
	private TextField userTextField;
	
	@FXML
	private void onLoginClicked(ActionEvent e)
	{
		
		
		Alert alert = new Alert(AlertType.INFORMATION, "You are logged in", ButtonType.OK, ButtonType.CANCEL);
		alert.setTitle("Good News!");
		alert.setHeaderText("Check Below");
		Optional<ButtonType> response = alert.showAndWait();
		if(response.isPresent() && response.get() == ButtonType.OK)
		{
			System.out.println("You said ok");
		}
	}
	
}
