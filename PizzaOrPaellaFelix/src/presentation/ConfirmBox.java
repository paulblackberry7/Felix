package presentation;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static boolean answer;
	
	public static boolean display(String title, String message) {
		Stage window = new Stage();
		//It blocks interaction with other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(message);
		Button buttonYes= new Button("Yes");
		buttonYes.setOnAction(e -> {
			answer = true;
			window.close();
		});
		Button buttonNo= new Button("No");
		buttonNo.setOnAction(e ->{
			answer = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, buttonYes, buttonNo);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		//Show and wait the other window
		window.showAndWait();
		
		return answer;
	}

}
