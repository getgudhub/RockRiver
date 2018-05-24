package view;

import controller.UsersDAO;
import controller.Validation;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class Registering {

	private BorderPane root;
	private Stage primaryStage;
	UsersDAO userDao = new UsersDAO();
	
	Registering(Stage primaryStage){
		
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
		
		GridPane grid2 = new GridPane();
			grid2.setVgap(10);
			grid2.setHgap(30);
			
		Label label2 = new Label("Fill the fields to register");
		label2.setFont(Font.font("Verdana", FontPosture.ITALIC, 22));
		GridPane.setConstraints(label2, 1, 0, 2, 2);
		
		Button returnButton = new Button("Return");
		returnButton.setMinWidth(100);
		returnButton.setTextFill(Color.WHITE);
		returnButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		Button submitButton = new Button("Register");
		submitButton.setMinWidth(100);
		submitButton.setTextFill(Color.WHITE);
		submitButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		
		Label name = new Label("Name:");
			GridPane.setConstraints(name, 1, 2);
		TextField nameInp = new TextField();
			nameInp.setMinWidth(200);
			nameInp.setPromptText("Name");
			GridPane.setConstraints(nameInp, 2, 2, 3, 1);
		Label password = new Label("Password:");
			GridPane.setConstraints(password, 1, 3);
		PasswordField passwInput = new PasswordField();
			passwInput.setPromptText("Password");
			GridPane.setConstraints(passwInput, 2, 3, 3, 1);
		Label passwordR = new Label("Repeat password:");
			GridPane.setConstraints(passwordR, 1, 4);
		PasswordField passwInput2 = new PasswordField();
			passwInput2.setPromptText("Password");
			GridPane.setConstraints(passwInput2,  2,  4, 3, 1);
		Label eMail = new Label("Email:");
			GridPane.setConstraints(eMail, 1, 5);
		TextField mailInput = new TextField();
			mailInput.setPromptText("Email");
			GridPane.setConstraints(mailInput, 2, 5, 3, 1);
			
		grid2.getChildren().addAll(label2, name, nameInp, password,
				passwInput, passwordR, passwInput2, eMail,
				mailInput, returnButton, submitButton );
		
		returnButton.setOnAction(e -> {
			Login login = new Login (this.primaryStage);
		});
		
		GridPane.setConstraints(returnButton, 0, 6, 2, 1);
		GridPane.setConstraints(submitButton, 3, 6);
		grid2.setPadding(new Insets(20,20,20,20));
		
		this.root.setCenter(grid2);
		
		Label errorMessage = new Label();
			GridPane.setConstraints(errorMessage, 2, 6);
			grid2.getChildren().add(errorMessage);
			errorMessage.setVisible(false);
			
		
		submitButton.setOnAction( e->{
			if(Validation.isValidCredentials(nameInp.getText().toString() ) &&
					Validation.isValidCredentials(passwInput.getText().toString() ) &&
					Validation.isValidCredentials(passwInput2.getText().toString() ) &&
					(passwInput.getText().equals(passwInput2.getText())) &&
					Validation.isValidEmail(mailInput.getText().toString() )) {
				User user = new User(nameInp.getText().toString(),passwInput.getText().toString(), 1,
						mailInput.getText().toString());
				userDao.addUser(user);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Uzsiregistravote sekmingai");
				alert.showAndWait();
				Login login = new Login(primaryStage);
			}else if(!Validation.isValidCredentials(nameInp.getText().toString())) {	
				errorMessage.setText("Neteisingai pasirinktas vardas");
				errorMessage.setTextFill(Color.RED);
				errorMessage.setVisible(true);
			}else if(!Validation.isValidCredentials(passwInput.getText().toString())||
					(!Validation.isValidCredentials(passwInput2.getText().toString()) ) ||
					(!passwInput.getText().equals(passwInput2.getText()) )){
				errorMessage.setText("Neteisingai pasirinktas slaptazodis, arba ju nesutapimas");
				errorMessage.setTextFill(Color.RED);
				errorMessage.setVisible(true);
			}else if(!Validation.isValidEmail(mailInput.getText().toString() )){ 
				errorMessage.setText("Neteisingai surasytas eMail'as");
				errorMessage.setTextFill(Color.RED);
				errorMessage.setVisible(true);
			}
		});
		
		//susiejimas su css
		label2.setId("txt2");
		grid2.setId("grid2");
		returnButton.setId("buttons");
		submitButton.setId("buttons");

	}

}
