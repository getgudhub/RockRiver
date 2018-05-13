package view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.stream.IntStream;

import controller.AlbumasDAO;
import controller.UsersDAO;
import controller.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Albumas;
import model.User;

public class DalinimosiAnketa {

	private BorderPane bpRoot;
	private Scene scene;
	private Stage primaryStage;
	StackPane userLayout = new StackPane();
	Scene userScene = new Scene(userLayout, 600, 300);
	Stage userWindow = new Stage();
	final ObservableList<Albumas> dataSaved =
			FXCollections.observableArrayList();
	final ObservableList<Albumas> data =
			FXCollections.observableArrayList();
	TextField idInput = new TextField();
	final TextField titleInput = new TextField();
	ObservableList<String> options =
			FXCollections.observableArrayList(
			"all", "<1980", "1980-1990", "1990-2000", "2000-2010", ">2010"
			);
	final ComboBox comboBoxDecade = new ComboBox(options);
	TextField tfArtist = new TextField();
	TextField tfDownloadUrl = new TextField();
	TextField tfYear = new TextField();
	TextField tfSongs = new TextField();
	CheckBox cb1 = new CheckBox();
	CheckBox cb2 = new CheckBox();
	CheckBox cb3 = new CheckBox();
	CheckBox cb4 = new CheckBox();
	CheckBox cb5 = new CheckBox();
	CheckBox cb6 = new CheckBox();
	CheckBox cb7 = new CheckBox();
	CheckBox cb8 = new CheckBox();
	CheckBox cb9 = new CheckBox();
	CheckBox cb10 = new CheckBox();
	final ToggleGroup group = new ToggleGroup();
	RadioButton rb1 = new RadioButton();
	RadioButton rb2 = new RadioButton();
	RadioButton rb3 = new RadioButton();
	GridPane infoGP = new GridPane();
	TableView <Albumas> lentele = new TableView<Albumas>();
	private String style = "";
	private RadioButton rbSelected;
	private User user;
	
	
	public final static int ADMIN_LEVEL = 9;
	
	public DalinimosiAnketa(Stage primaryStage, User user) throws Exception{
		this.bpRoot = new BorderPane();
		if(user.getUserlevel() == ADMIN_LEVEL) {
			this.scene = new Scene(this.bpRoot,1600,710);
		}else {
			this.scene = new Scene(this.bpRoot,1500,710);
		}
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		userScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		this.primaryStage = primaryStage;
		this.user = user;
		
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Rock River");
		this.primaryStage.setResizable(false);
		this.primaryStage.centerOnScreen();
		
		addElementsToScene();
		this.primaryStage.show();
	}
	
	public void addElementsToScene(){
		
		idInput.setPromptText("For selecting and updating");
		titleInput.setPromptText("For search and adding");
		tfArtist.setPromptText("For search and adding");
		tfSongs.setPromptText("For adding");
		tfDownloadUrl.setPromptText("For adding");
		tfYear.setPromptText("For adding");
		Label lbId = new Label("ID");
		lbId.setTextFill(Color.WHITE);
		lbId.setPrefWidth(100);
		Label lbTitle = new Label("Album Title");
		lbTitle.setTextFill(Color.WHITE);
		Label lbYear = new Label("Release Year");
		lbYear.setTextFill(Color.WHITE);
		Label lbGenre = new Label("Style");
		lbGenre.setTextFill(Color.WHITE);
		Label lbDecade = new Label("Decade (for search)");
		lbDecade.setTextFill(Color.WHITE);
		Label lbSongs = new Label("Songs");
		lbSongs.setTextFill(Color.WHITE);
		Label lbArtist = new Label("Artist");
		lbArtist.setTextFill(Color.WHITE);
		Label lbRating = new Label("Vote to rate");
		lbRating.setTextFill(Color.WHITE);
		Label lbDownloadUrl = new Label("Download URL");
		lbDownloadUrl.setTextFill(Color.WHITE);
		Label lbUser = new Label("Logged in as: "+user.getUsername());
		lbUser.setTextFill(Color.WHITE);
		lbUser.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
		Label userInfo = new Label("Fill the fields you'd like to change");
		userInfo.setFont(Font.font("Verdana", FontPosture.ITALIC, 22));
		GridPane.setConstraints(userInfo, 0, 0, 3, 1);
		Label password = new Label("Password:");
		GridPane.setConstraints(password,  1,  2);
		PasswordField passwInput = new PasswordField();
		passwInput.setPromptText("Password");
		GridPane.setConstraints(passwInput,  2,  2);
		Label passwordR = new Label("Repeat password:");
		GridPane.setConstraints(passwordR,  1,  3);
		PasswordField passwInput2 = new PasswordField();
		passwInput2.setPromptText("Password");
		GridPane.setConstraints(passwInput2,  2,  3);
		Label eMail = new Label("Email:");
		GridPane.setConstraints(eMail,  1,  4);
		TextField mailInput = new TextField();
		mailInput.setPromptText("Email");
		GridPane.setConstraints(mailInput, 2, 4);
		mailInput.setPrefWidth(200);
		
		comboBoxDecade.setValue("all");
		comboBoxDecade.setPrefWidth(250);
		cb1.setSelected(true);
		cb1.setText("Pop");
		cb2.setText("Punk");
		cb3.setText("Alternative");
		cb4.setText("Hard");
		cb5.setText("Classic");
		cb6.setText("Post");
		cb7.setText("Funk");
		cb8.setText("Experimental");
		cb9.setText("Country");
		cb10.setText("Electronic");
		rb1.setText("Love it");
		rb2.setText("Like it");
		rb3.setText("Dislike it                     ");
		rb1.setSelected(true);
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		cb1.setTextFill(Color.WHITE);
		cb2.setTextFill(Color.WHITE);
		cb3.setTextFill(Color.WHITE);
		cb4.setTextFill(Color.WHITE);
		cb5.setTextFill(Color.WHITE);
		cb6.setTextFill(Color.WHITE);
		cb7.setTextFill(Color.WHITE);
		cb8.setTextFill(Color.WHITE);
		cb9.setTextFill(Color.WHITE);
		cb10.setTextFill(Color.WHITE);
		rb1.setTextFill(Color.WHITE);
		rb2.setTextFill(Color.WHITE);
		rb3.setTextFill(Color.WHITE);
		
		Button addBtn = new Button("Add");
		addBtn.setMinWidth(100);
		Button deleteBtn = new Button("Delete");
		deleteBtn.setMinWidth(100);
		Button updateBtn = new Button("Update");
		updateBtn.setMinWidth(100);
		Button searchBtn = new Button("Search");
		searchBtn.setMinWidth(100);
		Button returnBtn = new Button("Refresh Table");
		returnBtn.setMinWidth(100);
		returnBtn.setVisible(false);
		Button showBtn = new Button("Show Mine");
		showBtn.setMinWidth(100);
		Button logoutBtn = new Button("Log Out");
		logoutBtn.setMinWidth(100);
		Button settingsBtn = new Button("User Settings");
		settingsBtn.setMinWidth(100);
		Button voteBtn = new Button("Vote");
		voteBtn.setMinWidth(100);
		Button submitButton = new Button("Submit");
		submitButton.setMinWidth(100);
		GridPane.setConstraints(submitButton,  1,  1);
		submitButton.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		
		GridPane userInfoGP = new GridPane();
		userInfoGP.add(lbUser, 0, 0);
		userInfoGP.add(logoutBtn, 0, 1);
		userInfoGP.add(settingsBtn, 0, 2);
		userInfoGP.setVgap(20);
		
		GridPane buttonGP = new GridPane();
		buttonGP.add(addBtn, 0, 0);
		buttonGP.add(deleteBtn, 1, 0);
		buttonGP.add(updateBtn, 0, 1);
		buttonGP.add(searchBtn, 1, 1);
		buttonGP.add(returnBtn, 2, 1);
		buttonGP.add(showBtn,  2, 0);
		buttonGP.setHgap(20);
		buttonGP.setVgap(20);
		buttonGP.setPadding(new Insets(10,10,20,10));
		
		DropShadow shadow1 = new DropShadow();
		shadow1.setColor(Color.WHITE);
		shadow1.setOffsetX(2);
		shadow1.setOffsetY(3);
		buttonGP.setEffect(shadow1);
		logoutBtn.setEffect(shadow1);
		settingsBtn.setEffect(shadow1);
		voteBtn.setEffect(shadow1);
		
		GridPane gpStyle = new GridPane();
		gpStyle.add(cb1, 1, 1);
		gpStyle.add(cb2, 1, 2);
		gpStyle.add(cb3, 1, 3);
		gpStyle.add(cb4, 1, 4);
		gpStyle.add(cb5, 1, 5);
		gpStyle.add(cb6, 2, 1);
		gpStyle.add(cb7, 2, 2);
		gpStyle.add(cb8, 2, 3);
		gpStyle.add(cb9, 2, 4);
		gpStyle.add(cb10, 2, 5);
		gpStyle.setVgap(5);
		gpStyle.setHgap(20);
		gpStyle.setPrefWidth(200);
		
		GridPane gpRating = new GridPane();
		gpRating.addRow(1, rb1);
		gpRating.addRow(2, rb2);
		gpRating.addRow(3, rb3);
		gpRating.setVgap(5);
		gpRating.add(voteBtn, 2, 3);
		
		infoGP.add(lbId, 0, 0);
		infoGP.add(idInput, 1, 0);
		infoGP.add(lbTitle, 0, 1);
		infoGP.add(titleInput, 1, 1);
		infoGP.add(tfArtist, 1, 2);
		infoGP.add(lbArtist, 0, 2);
		infoGP.add(lbGenre, 0, 3);
		infoGP.add(gpStyle, 1, 3);
		infoGP.add(lbDecade, 0, 4);	
		infoGP.add(comboBoxDecade, 1, 4);
		infoGP.add(lbYear, 0, 5);
		infoGP.add(tfYear, 1, 5);
		infoGP.add(lbSongs, 0, 6);
		infoGP.add(tfSongs, 1, 6);
		infoGP.add(lbDownloadUrl, 0, 7);
		infoGP.add(tfDownloadUrl, 1, 7);
		infoGP.add(lbRating, 0, 8);
		infoGP.add(gpRating, 1, 8);
		infoGP.add(buttonGP, 0, 9, 2, 2);
		infoGP.setPadding(new Insets(10,10,10,10));	
		infoGP.setVgap(10);
		infoGP.setHgap(10);
		infoGP.setPrefWidth(400);
		
		bpRoot.setCenter(infoGP);
		
		
		GridPane top = new GridPane();
		top.add(userInfoGP,0,0,4,4);
		top.setPadding(new Insets(10,10,10,10));
		top.setPrefHeight(150);
		top.setEffect(shadow1);
		bpRoot.setTop(top);
		
		GridPane btnsGP = new GridPane();
		btnsGP.setVgap(10);
		btnsGP.setHgap(10);
		btnsGP.getChildren().addAll( submitButton);
		GridPane inputGP = new GridPane();
		inputGP.setPadding(new Insets(10,10,10,60));
		inputGP.setVgap(10);
		inputGP.setHgap(10);
		inputGP.add(btnsGP, 2, 5);
		inputGP.getChildren().addAll(password, passwInput, passwordR, passwInput2, eMail, mailInput, userInfo);	
		
		userWindow.setScene(userScene);
		userLayout.getChildren().addAll( inputGP);
		
		//Setting IDS
		infoGP.setId("gridDashboard");
		top.setId("bgTop");
		lbTitle.setId("label");
		lbUser.setId("user");
		userLayout.setId("userInfo");
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////TABLE
		TableColumn<Albumas, String> firstCol = new TableColumn<Albumas, String>("Id");
		firstCol.setText("Id");
		firstCol.setPrefWidth(40);
		firstCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("id")
			);
		TableColumn<Albumas, String> extraCol = new TableColumn<Albumas, String>("Username");
		extraCol.setText("User");
		extraCol.setPrefWidth(160);
		extraCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("username")
			);
		
		TableColumn<Albumas, String> secondCol = new TableColumn<Albumas, String>("Title");
		secondCol.setPrefWidth(200);
		secondCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("title")
			);
		TableColumn<Albumas, String> thirdCol = new TableColumn<Albumas, String>("Artist");
		thirdCol.setText("Artist");
		thirdCol.setPrefWidth(180);
		thirdCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("artist")
			);
		TableColumn<Albumas, String> fourthCol = new TableColumn<Albumas, String>("Songs");
		fourthCol.setText("Songs");
		fourthCol.setPrefWidth(50);
		fourthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("songs")
			);
		TableColumn<Albumas, String> fifthCol = new TableColumn<Albumas, String>("Genre");
		fifthCol.setText("Style");
		fifthCol.setPrefWidth(160);
		fifthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("genre")
			);
		TableColumn<Albumas, String> sixthCol = new TableColumn<Albumas, String>("Year");
		sixthCol.setText("Release Year");
		sixthCol.setPrefWidth(90);
		sixthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("year")
			);
		TableColumn<Albumas, String> seventhCol = new TableColumn<Albumas, String>("Rating");
		seventhCol.setText("Rating");
		seventhCol.setPrefWidth(50);
		seventhCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("rating")
			);
		TableColumn<Albumas, String> eighthCol = new TableColumn<Albumas, String>("Votes");
		eighthCol.setText("Votes");
		eighthCol.setPrefWidth(50);
		eighthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("votes")
			);
		TableColumn<Albumas, String> ninthCol = new TableColumn<Albumas, String>("lastUpdated");
		ninthCol.setText("Last Updated");
		ninthCol.setPrefWidth(80);
		ninthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("lastUpdated")
			);
		TableColumn<Albumas, String> tenthCol = new TableColumn<Albumas, String>("downloadSite");
		tenthCol.setText("Download URL");
		tenthCol.setPrefWidth(200);
		tenthCol.setCellValueFactory(
			    new PropertyValueFactory<Albumas,String>("downloadSite")
			);
		final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( lentele );
		
        bpRoot.getChildren().add(vbox);
		bpRoot.setRight(lentele);
		
		AlbumasDAO dao = new AlbumasDAO();
		UsersDAO uDao = new UsersDAO();
		dao.showAlbums(data, user);
		lentele.setItems(data);
		lentele.setPrefHeight(410);
			if(user.getUserlevel() == ADMIN_LEVEL) {
				lentele.getColumns().setAll(firstCol, extraCol, secondCol, thirdCol, fourthCol, fifthCol, sixthCol, seventhCol, eighthCol, ninthCol, tenthCol);
			}else {
				lentele.getColumns().setAll(firstCol, secondCol, thirdCol, fourthCol, fifthCol, sixthCol, seventhCol, eighthCol, ninthCol, tenthCol);
			}
		lentele.setEditable(true);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// buttons
		addBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(validation("add")==true){
				Albumas album = new Albumas(
						user.getUsername(),
						titleInput.getText().toString(),
						tfArtist.getText().toString(),
						Integer.parseInt(tfSongs.getText().toString()),
						style,
						Integer.parseInt(tfYear.getText().toString()),
						0 ,0,
						updateTime(),
					    tfDownloadUrl.getText().toString(),
					    0
						 );	
				dao.addAlbum(album);
				data.add(album);
				lentele.getItems().clear();
				idInput.clear();
				titleInput.clear();
				tfArtist.clear();
				tfDownloadUrl.clear();
				tfYear.clear();
				tfSongs.clear();
				dao.showAlbums(data, user);
				}
			}			
		});
		
		deleteBtn.setOnAction(e->{
			if(validation("delete")==true) {
				boolean found = false;
				for(Albumas album: data) {
					if(album.getId()==Integer.parseInt(idInput.getText().toString())){
						if(album.getUsername().toString().equals(user.getUsername().toString()) ) {
							data.remove(album);
							dao.deleteAlbum(Integer.parseInt(idInput.getText().toString()), user);
							found = true;
							break ;
						}else if(user.getUserlevel() == ADMIN_LEVEL) {
							data.remove(album);
							dao.deleteAlbum(Integer.parseInt(idInput.getText().toString()), user);
							found = true;
							break ;
						}else if(!album.getUsername().toString().equals(user.getUsername().toString())) {
							showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Wrong ID, You can only delete Your albums");
							found = true;
							break ;
						}
					}		
				}
				if(found == false) {
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Album with chosen ID not found");
				}
				idInput.clear();
			}
		});
	
		updateBtn.setOnAction(e->{
			if(validation("update")==true) {
				boolean found = false;
				 Albumas albumas = new Albumas(
						Integer.parseInt(idInput.getText().toString()),
						user.getUsername(),
						titleInput.getText().toString(),
						tfArtist.getText().toString(),
						Integer.parseInt(tfSongs.getText().toString()),
						style,
						Integer.parseInt(tfYear.getText().toString()),	
						updateTime(),
					    tfDownloadUrl.getText().toString()
						);
				for(Albumas album: data) {
					if(album.getId()==Integer.parseInt(idInput.getText().toString())){
						if(album.getUsername().toString().equals(user.getUsername().toString()) ) {	
							if(data.size()==1) {
								data.set(album.getId(), album);
							}else {
								data.set(album.getId()-1, album);
							}							
							dao.updateAlbum(albumas, user);								
							found = true;
							break;								
						}
					}
				}
				if(found == false) {
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Album with chosen ID not found or it doesn't belong to you");
					idInput.clear();
				}else {
					idInput.clear();
					titleInput.clear();
					tfArtist.clear();
					tfDownloadUrl.clear();
					tfYear.clear();
					tfSongs.clear();
					lentele.getItems().clear();
					dao.showAlbums(data, user);
				}
			}
		});
		
		searchBtn.setOnAction(e->{
			if(validation("search")==true) {
				lentele.getItems().clear();
				dao.showAlbums(data, user);
				returnBtn.setVisible(true);
				ObservableList<Albumas> dataSearch =
						FXCollections.observableArrayList();
				dataSaved.setAll(data);
					if(!idInput.getText().isEmpty()) {
						for(Albumas album : data) {						
							if(album.getId()==Integer.parseInt(idInput.getText().toString()) ) {
								dataSearch.add(album);	
								tfDownloadUrl.appendText(album.getDownloadSite());
								lbDownloadUrl.setTextFill(Color.YELLOW);
								break;
							}
						}
					}else if(!titleInput.getText().isEmpty()) {
						for(Albumas album : data) {
							if(album.getTitle().matches(".*?"+titleInput.getText().toString()+".*?")) {
								dataSearch.add(album);
							}
						}						
					}else if(!tfArtist.getText().isEmpty()) {
						for(Albumas album : data) {
							if(album.getArtist().matches(".*?"+tfArtist.getText().toString()+".*?")) {
								dataSearch.add(album);	
							}
						}
					}
					else if(comboBoxDecade.getValue().toString().matches("<1980")) {
						for(Albumas album : data) {
							for(int i=0;i<20;i++) {
								if(album.getYear() == (1960+i)) {
									System.out.println(album.getYear());
									dataSearch.add(album);
								}
							}
						}
					}else if(comboBoxDecade.getValue().toString().matches("1980-1990")) {
						for(Albumas album : data) {	
							for(int i=0;i<10;i++) {
								if(album.getYear() == (1980+i)) {
									dataSearch.add(album);
								}
							}
						}
					}else if(comboBoxDecade.getValue().toString().matches("1990-2000")) {
						for(Albumas album : data) {
							for(int i=0;i<10;i++) {
								if(album.getYear() == (1990+i)) {
									dataSearch.add(album);
								}
							}
						}
					}else if(comboBoxDecade.getValue().toString().matches("2000-2010")) {
						for(Albumas album : data) {
							for(int i=0;i<10;i++) {
								if(album.getYear() == (2000+i)) {
									dataSearch.add(album);
								}
							}
						}
					}else if(comboBoxDecade.getValue().toString().matches(">2010")) {
						for(Albumas album : data) {
							for(int i=0;i<10;i++) {
								if(album.getYear() == (2010+i)) {
									dataSearch.add(album);
								}
							}
						}
					}
					else if(comboBoxDecade.getValue().toString().matches("all")) {						
								dataSearch.addAll(data);
					}
				data.clear();
				lentele.getItems().clear();
				data.setAll(dataSearch);
				titleInput.clear();
				tfArtist.clear();
			}
		});
		
		returnBtn.setOnAction(e->{
			lentele.getItems().clear();
			dao.showAlbums(data, user);
			tfDownloadUrl.clear();
			lbDownloadUrl.setTextFill(Color.WHITE);
			returnBtn.setVisible(false);
		});
		
		showBtn.setOnAction(e->{
			returnBtn.setVisible(true);
			lentele.getItems().clear();
			dao.showMyAlbums(data, user);
		});
		
		voteBtn.setOnAction(e->{
			if(validation("delete")==true) { // same condition for id
				boolean voted = false;
				Iterator<Integer> it = user.getUserVotesOn().iterator();
				for(Albumas album: data) {
					if(album.getId()==Integer.parseInt(idInput.getText().toString())){
						while(it.hasNext()) {
							if( //IntStream.of(user.getUserVotesOn()).anyMatch(x -> x == album.getId())){
								//Arrays.asList(user.getUserVotesOn()).contains(album.getId())) {
								user.getUserVotesOn().contains(album.getId())){
								voted = true;
								break;
							}else if(!user.getUserVotesOn().contains(album.getId())) {
								album.setRating(findRating(album.getRating(), album.getVotes(), album.getRatingPoints()));
								album.setVotes(album.getVotes()+1);
								album.setratingpoints(findRatingPoints(album.getRatingPoints()));								
								dao.rateAlbum(album, user);
								user.getUserVotesOn().add(album.getId());
								uDao.updateUserVotes(user.getUsername(), user.getUserVotesOn());
								break;
							}
						}
					}
				}if (voted == true){
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "You have already voted on this album, thank you");
				}
				lentele.getItems().clear();
				dao.showAlbums(data, user);
			}
		});
		
		logoutBtn.setOnAction(e->{
			Login login = new Login(this.primaryStage);
		});
		
		settingsBtn.setOnAction(e->{ 										
			userWindow.show();			
		});
		
		submitButton.setOnAction(e->{
			if(!mailInput.getText().isEmpty()) {
				if(Validation.isValidEmail(mailInput.getText().toString()) ) {
					uDao.updateUserEmail(user.getUsername(), mailInput.getText().toString());
					mailInput.clear();
					userWindow.hide();			
					showAlert(Alert.AlertType.CONFIRMATION, infoGP.getScene().getWindow(),"CONFIRMATION", "User information has been modified");
				}else {
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User email is invalid");
				}
			}
			else if(!passwInput.getText().isEmpty() && !passwInput2.getText().isEmpty()) {
				
				if (passwInput.getText().contentEquals(passwInput2.getText())) {
					if(Validation.isValidCredentials(passwInput.getText().toString()) && 
							Validation.isValidCredentials(passwInput2.getText().toString())) {
						uDao.updateUserPassword(user.getUsername(), passwInput.getText().toString());
						passwInput.clear();
						passwInput2.clear();
						userWindow.hide();			
						showAlert(Alert.AlertType.CONFIRMATION, infoGP.getScene().getWindow(),"CONFIRMATION", "User information has been modified");
					}else {
						showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User password fields are invalid");
					}
				}else {
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User password fields are invalid");
				}
			}
			else if(!passwInput.getText().isEmpty() && !passwInput2.getText().isEmpty() && !mailInput.getText().isEmpty()) {
					if (passwInput.getText().contentEquals(passwInput2.getText())) {
						if(Validation.isValidCredentials(passwInput.getText().toString()) && 
								Validation.isValidCredentials(passwInput2.getText().toString())) {
							if(Validation.isValidEmail(mailInput.getText().toString())){
								uDao.updateUserPassword(user.getUsername(), passwInput.getText().toString());
								passwInput.clear();
								passwInput2.clear();
								mailInput.clear();
								userWindow.hide();								
								showAlert(Alert.AlertType.CONFIRMATION, infoGP.getScene().getWindow(),"CONFIRMATION", "User information has been modified");
							}else {
								showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User email is invalid");
							}						
						}else {
							showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User password fields are invalid");
						}
				}else {
					showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User password fields are invalid");
				}
			}
			else{					
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "User information fields are empty");
			}
		});
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// end of addElementsToScene()
	private boolean validation(String action) {
		switch(action) {
		case "add":
			if(!Validation.isValidName(titleInput.getText().toString())||
			   !Validation.isValidName(tfArtist.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Title or Artist name contains bad symbols");
				return false;
			}
			else if(!Validation.isValidYear(tfYear.getText().toString()) ) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Years must be from 1960 till now");
				return false;
				}
			else if(!Validation.isValidSongNumb(tfSongs.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Sorry, but the songs amount must be from 1 to 99");
				return false;
			}
			else if(!(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected()||cb5.isSelected()||
					cb6.isSelected()||cb7.isSelected()||cb8.isSelected()||cb9.isSelected()||cb10.isSelected())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Must choose adleast one genre");
				return false;
			}
			else if(tfDownloadUrl.getText().isEmpty()){
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Please share the albums' download location in the 'Download URL' field");
			}
			else {
				style = "";
				if(cb1.isSelected()) {
					style += "Pop ";
				}
				if(cb2.isSelected()) {
					style += "Punk ";
				}
				if(cb3.isSelected()) {
					style += "Alternative ";
				}
				if(cb4.isSelected()) {
					style += "Hard ";
				}
				if(cb5.isSelected()) {
					style += "Classic ";
				}
				if(cb6.isSelected()) {
					style += "Post ";
				}
				if(cb7.isSelected()) {
					style += "Funk ";
				}
				if(cb8.isSelected()) {
					style += "Experimental ";
				}
				if(cb9.isSelected()) {
					style += "Country ";
				}
				if(cb10.isSelected()) {
					style += "Electronic ";
				}
				style += "Rock";
				rbSelected = (RadioButton)group.getSelectedToggle();
				
				return true;
			}
		case "update":
			if(!Validation.isValidID(idInput.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Wrong ID");
				return false;
			}
			else if(!Validation.isValidYear(tfYear.getText().toString()) ) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Years must be from 1960 till now");
				return false;
				}
			else if(!Validation.isValidName(titleInput.getText().toString())||
				    !Validation.isValidName(tfArtist.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Title or Artist name contains bad symbols");
				return false;
			}
			else if(!Validation.isValidSongNumb(tfSongs.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Sorry, but the songs amount must be from 1 to 99");
				return false;
			}
			else if(!(cb1.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected()||cb5.isSelected()||
					cb6.isSelected()||cb7.isSelected()||cb8.isSelected()||cb9.isSelected()||cb10.isSelected())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Must choose adleast one style");
				return false;
			}
			else if(tfDownloadUrl.getText().isEmpty()){
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Please share the albums' download location in the 'Download URL' field");
			}
			else {
				style = "";
				if(cb1.isSelected()) {
					style += "Pop ";
				}
				if(cb2.isSelected()) {
					style += "Punk ";
				}
				if(cb3.isSelected()) {
					style += "Alternative ";
				}
				if(cb4.isSelected()) {
					style += "Hard ";
				}
				if(cb5.isSelected()) {
					style += "Classic ";
				}
				if(cb6.isSelected()) {
					style += "Post ";
				}
				if(cb7.isSelected()) {
					style += "Funk ";
				}
				if(cb8.isSelected()) {
					style += "Experimental ";
				}
				if(cb9.isSelected()) {
					style += "Country ";
				}
				if(cb10.isSelected()) {
					style += "Electronic ";
				}
				style += "Rock";
				rbSelected = (RadioButton)group.getSelectedToggle();
				
				return true;
			}
		case "delete":
			if(!Validation.isValidID(idInput.getText().toString())) {
				showAlert(Alert.AlertType.ERROR, infoGP.getScene().getWindow(),"Error", "Wrong ID");
				return false;
			}else {
				return true;
			}
			
		default: //search:
				return true;		
		}
	}
	
	private void showAlert(Alert.AlertType alerType, Window owner, String title, String message){
		Alert alert = new Alert(alerType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
		}
	
	public Date updateTime() {
		Date updateTime;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		updateTime = date;
		return updateTime;
	}
	
	private int findRating(int rating, int votes, int ratingPoints) {
		rbSelected = (RadioButton)group.getSelectedToggle();
		if(rb1.isSelected()) {
			rating = (ratingPoints + 10)/(votes+1);
		}else if(rb2.isSelected()) {
			rating = (ratingPoints + 7)/(votes+1);
		}else {
			rating = (ratingPoints + 2)/(votes+1);
		}
		return rating;
	}
	private int findRatingPoints( int ratingPoints) {
		rbSelected = (RadioButton)group.getSelectedToggle();
		if(rb1.isSelected()) {
			ratingPoints = ratingPoints + 10;
		}else if(rb2.isSelected()) {
			ratingPoints = ratingPoints + 7;
		}else {
			ratingPoints = ratingPoints + 2;
		}
		return ratingPoints;
	}
	
}
