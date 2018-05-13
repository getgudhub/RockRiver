package application;


import javafx.stage.Stage;
import view.Login;
import javafx.application.Application;

public class Main extends Application {

	Stage primaryStage;;
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		Login login = new Login(primaryStage);
	
	}
	
	public static void main(String[] args) {
		launch(args);
		

	}

}