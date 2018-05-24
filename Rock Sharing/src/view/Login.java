package view;



import controller.UsersDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;
import view.DalinimosiAnketa;

public class Login{
	
	private BorderPane bpRoot;
	private Stage primaryStage;
	
	public Login(Stage primaryStage){
		this.primaryStage = primaryStage;
		addElementsToScene();
		primaryStage.show();
	}
		
		private void addElementsToScene()  {
			//BUTINA css
			this.bpRoot = new BorderPane();
			Scene scene = new Scene(this.bpRoot, 500, 340);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());								
			primaryStage.setTitle("Rock River");
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			
			//drop shadow effect
			DropShadow dropshadow = new DropShadow();
			dropshadow.setOffsetX(3);
			dropshadow.setOffsetY(3);
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(20,20,20,20));	
			grid.setVgap(8);
			grid.setHgap(10);
				
			//Name label
			Label nameLabel = new Label("Name:");
			GridPane.setConstraints(nameLabel,  0,  0);
			nameLabel.setTextFill(Color.WHITE);
			
			//Name input
			TextField nameInput = new TextField();
			GridPane.setConstraints(nameInput, 1, 0);
			
			//Password label
			Label passLabel = new Label("Password:");
			GridPane.setConstraints(passLabel,  3,  0);
			passLabel.setTextFill(Color.WHITE);
			
			//Password Input
			PasswordField passInput = new PasswordField();
			passInput.setPromptText("Password");
			GridPane.setConstraints(passInput,  4,  0);
			
			GridPane credentialsGP = new GridPane();
			credentialsGP.getChildren().addAll(nameLabel, nameInput, passLabel, passInput);
			credentialsGP.setHgap(20);
			
			DropShadow ds = new DropShadow();
			ds.setOffsetX(5);
			ds.setOffsetY(4);
			ds.setColor(Color.ALICEBLUE);
			credentialsGP.setEffect(ds);
						
			//Login
			Button loginButton = new Button("Sign in");
			loginButton.setPrefWidth(90);
			loginButton.setTextFill(Color.WHITE);
			loginButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
					
			//Register
			Button regButton = new Button("Register");
			regButton.setPrefWidth(90);	
			regButton.setTextFill(Color.WHITE);
			regButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
			
			GridPane buttonGP = new GridPane();
			buttonGP.getChildren().addAll(loginButton, regButton);
			GridPane.setConstraints(loginButton,  2,  4, 8, 8);
			GridPane.setConstraints(regButton,  35,  4, 8, 8);
			buttonGP.setHgap(50);
			
			HBox layout = new HBox(40);
			layout.getChildren().add(loginButton);
			layout.getChildren().add(regButton);
			
			grid.getChildren().addAll(loginButton, regButton);
			regButton.setOnAction(e -> {
			Registering registering = new Registering(this.primaryStage);
			
			});
			
			Label message = new Label();
			GridPane.setConstraints(message, 9, 0, 33, 4);
			grid.getChildren().add(message);
			message.setVisible(false);
			
			
			loginButton.setOnAction( e->{
				UsersDAO userDao = new UsersDAO();
				User user = userDao.getUser(
						nameInput.getText().toString(), passInput.getText().toString());
				
				if ((nameInput.getText().isEmpty()) || ( passInput.getText().isEmpty())){
					message.setText("Please write in your crediantials");
					message.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
					message.setTextFill(Color.RED);
					message.setVisible(true);
				}else if(user.getUsername() != null) {
					try {
						DalinimosiAnketa anketa = new DalinimosiAnketa(this.primaryStage, user);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					message.setText("         Incorrect credentials");
					message.setTextFill(Color.RED);
					message.setVisible(true);
				}	
			});
			
			bpRoot.setCenter(grid);
			bpRoot.setTop(credentialsGP);
			
			grid.setId("grid");
			loginButton.setId("buttons");
			regButton.setId("buttons");
			nameInput.setId("text");
			message.setId("msg");
			buttonGP.setId("loginButtons");
			credentialsGP.setId("forLoginGP");
			buttonGP.setId("forLoginGP");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			}
}
