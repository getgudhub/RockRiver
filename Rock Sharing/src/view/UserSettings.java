package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UserSettings {

	private BorderPane root;
	private Stage primaryStage;
	
	UserSettings(Stage primaryStage){
		
		this.primaryStage = primaryStage;
		this.root = new BorderPane();
		
		Scene scene = new Scene(this.root,550,220);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Rock River");
		this.primaryStage.setResizable(false);
		this.primaryStage.centerOnScreen();
		
		addElementsToScene();
		
		primaryStage.show();
	}
	private void addElementsToScene(){
		
		Label userInfo = new Label();
		userInfo.setFont(Font.font("Verdana", FontPosture.ITALIC, 22));
		GridPane.setConstraints(userInfo, 1, 0, 2, 2);
		
		Button returnButton = new Button("Return");
		returnButton.setMinWidth(100);
		returnButton.setTextFill(Color.WHITE);
		returnButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		Button submitButton = new Button("Register");
		submitButton.setMinWidth(100);
		submitButton.setTextFill(Color.WHITE);
		submitButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		
	Label password = new Label("Password:");
		GridPane.setConstraints(password,  1,  3);
	PasswordField passwInput = new PasswordField();
		passwInput.setPromptText("Password");
		GridPane.setConstraints(passwInput,  2,  3, 3, 1);
	Label passwordR = new Label("Repeat password:");
		GridPane.setConstraints(passwordR,  1,  4);
	PasswordField passwInput2 = new PasswordField();
		passwInput2.setPromptText("Password");
		GridPane.setConstraints(passwInput2,  2,  4, 3, 1);
	Label eMail = new Label("Email:");
		GridPane.setConstraints(eMail,  1,  5);
	TextField mailInput = new TextField();
		mailInput.setPromptText("Email");
		GridPane.setConstraints(mailInput, 2, 5, 3, 1);
		
	}
}
