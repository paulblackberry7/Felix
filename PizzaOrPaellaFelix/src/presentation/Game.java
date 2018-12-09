package presentation;

import java.util.Random;

import domain.Character;
import domain.Map;
import domain.Sprite;
import domain.SpriteManager;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Game {

	public  final String title = "Pizza Or Paella";
	private Group root = new Group();
	private Scene myScene;
	private Character myPlayer;
	private Map map;
	private int myframe = 1;
	private SpriteManager manager = new SpriteManager();
	private Stage myStage;
	private boolean freeze = false;
	private int time = 0;
	private double speed = 1.0;
	private String mapType = "";
	
	public String getTitle () {
		return title;
	}

	public Game(Stage s){
		myStage = s;
	}
	
	public Scene startmenu(){
		final Label label1 = new Label("Username");
		final TextField nameInput = new TextField();
		final Label label2 = new Label("Team");
		final ChoiceBox cbteam = new ChoiceBox();
		cbteam.getItems().add("Pizza");
		cbteam.getItems().add("Paella");
		final Label label5 = new Label("Map");
		final ChoiceBox cbmap = new ChoiceBox();
		cbmap.getItems().add("Map 1");
		cbmap.getItems().add("Map 2");
		final Label label3 = new Label("Map's size");
		final ChoiceBox cbmapsize = new ChoiceBox();
		cbmapsize.getItems().add(400);
		cbmapsize.getItems().add(600);
		final Button button1 = new Button();
		 button1.setText("Play");
		button1.setOnAction(e -> {
			if(nameInput.getText().contentEquals("") || cbteam.getSelectionModel().isEmpty() || cbmapsize.getSelectionModel().isEmpty()) {
				AlertBox.displayAlert("Incorrect data", "Please, fill all the required data.");
			}else {
				if(cbmap.getValue().toString().contentEquals("Map 1")) {
					mapType = "one";
	        	}else {
	        		mapType = "two";
	        	}
				map = new Map((int)cbmapsize.getValue(), mapType);
				System.out.println(map.getSize());
				myPlayer= new Character(nameInput.getText(), cbteam.getValue().toString(), 0);
				System.out.println(myPlayer.getName() +"-"+myPlayer.getTeam());
				myScene.setOnKeyPressed(ex -> {
					newgame(map.getSize());
				});
				freeze=true;
			}
		});
		Label label4 = new Label("Ranking");
		ListView<Integer> list = new ListView<Integer>();
		int[] ranking = {2000, 100, 40000, 5};
		bubble(ranking);
		ObservableList<Integer> items =FXCollections.observableArrayList();
		for(int i=0; i<ranking.length; i++) {
			items.add(ranking[i]);
		}
		list.setItems(items);
		list.setPrefHeight(100);
		
		final VBox layout_map_back = new VBox(10);
		layout_map_back.getChildren().addAll(label5, cbmap);
		final VBox layout_map_size = new VBox(10);
		layout_map_size.getChildren().addAll(label3, cbmapsize);
		final HBox layout_maps = new HBox(20);
		layout_maps.getChildren().addAll(layout_map_back, layout_map_size);
		
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(label1,nameInput, label2, cbteam, layout_maps, button1, label4, list);
		myScene = new Scene(root, 400, 400);
		root.getChildren().add(layout1);
		
		//This part is to exit the game
		myStage.setOnCloseRequest(e -> {
			boolean result = ConfirmBox.display("Exit game", "Do you want to exit?");
			if(!result) {
				e.consume();
			}
	    });
		freeze = true;
		return myScene;
	}
	
	public Scene startmenuAdmin(){
		final Label adminLabel = new Label("You are an admin");
		final Label username = new Label("Username");
		TextField nameInput = new TextField();
		final Label label2 = new Label("Team");
		final ChoiceBox cbteam = new ChoiceBox();
		cbteam.getItems().add("Pizza");
		cbteam.getItems().add("Paella");
		Label label5 = new Label("Map");
		final ChoiceBox cbmap = new ChoiceBox();
		cbmap.getItems().add("Map 1");
		cbmap.getItems().add("Map 2");
		Label label3 = new Label("Map's size");
		final ChoiceBox cbmapsize = new ChoiceBox();
		cbmapsize.getItems().add(400);
		cbmapsize.getItems().add(600);
		final Button play = new Button();
		play.setText("Play");
		play.setOnAction(e -> {
			if(nameInput.getText().contentEquals("") || cbteam.getSelectionModel().isEmpty() || cbmapsize.getSelectionModel().isEmpty()) {
				AlertBox.displayAlert("Incorrect data", "Please, fill all the required data.");
			}else {
				if(cbmap.getValue().toString().contentEquals("Map 1")) {
					mapType = "one";
	        	}else {
	        		mapType = "two";
	        	}
				map = new Map((int)cbmapsize.getValue(), mapType);
				System.out.println(map.getSize());
				myPlayer= new Character(nameInput.getText(), cbteam.getValue().toString(), 0);
				System.out.println(myPlayer.getName() +"-"+myPlayer.getTeam());
				myScene.setOnKeyPressed(ex -> {
					newgame(map.getSize());
				});
				freeze=true;
			}
		});
		Label label4 = new Label("Ranking");
		ListView<Integer> list = new ListView<Integer>();
		int[] ranking = {2000, 100, 40000, 5};
		bubble(ranking);
		ObservableList<Integer> items =FXCollections.observableArrayList();
		for(int i=0; i<ranking.length; i++) {
			items.add(ranking[i]);
		}
		list.setItems(items);
		list.setPrefHeight(100);
		
		Button manageSongs = new Button();
		manageSongs.setText("Manage Songs");
		manageSongs.setOnAction(ex -> {
			
		});
		Button manageUsers = new Button();
		manageUsers.setText("Manage Users");
		manageUsers.setOnAction(ex -> {
			
		});
		
		final VBox layout_map_back = new VBox(10);
		layout_map_back.getChildren().addAll(label5, cbmap);
		final VBox layout_map_size = new VBox(10);
		layout_map_size.getChildren().addAll(label3, cbmapsize);
		final HBox layout_maps = new HBox(20);
		layout_maps.getChildren().addAll(layout_map_back, layout_map_size);
		
		VBox layout1 = new VBox(10);
		layout1.getChildren().addAll(adminLabel,username,nameInput,label2,
				cbteam,layout_maps,play,manageSongs,manageUsers,label4, list);
		myScene = new Scene(root, 500, 500);
		root.getChildren().add(layout1);
		
		//This part is to exit the game
		myStage.setOnCloseRequest(e -> {
			boolean result = ConfirmBox.display("Exit game", "Do you want to exit?");
			if(!result) {
				e.consume();
			}
	    });
		freeze = true;
		return myScene;

	}
	
	public void step (double elapsedTime) {
		time ++;
		if (!freeze){
			myPlayer.move(map.getSize());
			updateSprites();
			handledeath();
			gamecondition();
		}
	}
	
	private void gamecondition(){
		if(manager.getAllSprites().isEmpty()) {
			myPlayer.upgrade();
			freeze = true;
			System.out.println("You obtain "+myPlayer.getPoint()+" points.");
		}
	}
	
	private void newgame(int size) {
		spritecleanall();
		root = new Group();
		Scene scene = init(size);
		myframe = 1;
		myStage.setScene(scene);
		myStage.show();
	}
	
	public Scene init (int size) {
		freeze = false;
		myScene = new Scene(root, size, size);
		Image imageMap=null;
		if(map.getType().contentEquals("one")) {
			imageMap = new Image(getClass().getClassLoader().getResourceAsStream("base.jpg"));
		}else {
			imageMap = new Image(getClass().getClassLoader().getResourceAsStream("trolley.jpg"));
		}
		ImageView mantel = new ImageView(imageMap);
		mantel.setFitHeight(size);
		mantel.setFitWidth(size);
		root.getChildren().addAll(mantel,myPlayer.getPlayerImg());
		generateSprites(20, root);
		myScene.setOnKeyPressed(e -> myPlayer.speed(e.getCode(),0.5,size));
		return myScene;
	}
	
	private void generateSprites(int totalNum, Group root){
		Random r = new Random();
		for(int i=0; i<totalNum; i++) {
			int type = r.nextInt(18);
			int power = r.nextInt(10);
			int randX = r.nextInt(map.getSize());
			int randY = r.nextInt(map.getSize());
			Sprite s = new Sprite(type,power,randX,randY);
			manager.addSprites(s);
			root.getChildren().add(s.getSpriteImg());
		}
	}
	
	private void spritecleanall(){
		for (Sprite sprite:manager.getAllSprites()){
			manager.addSpritesToBeRemoved(sprite);
			root.getChildren().remove(sprite.getSpriteImg());
		}
		manager.cleanupSprites();
	}
	
	public static void login(String title, String message) {
		Stage window = new Stage();
		//It blocks interaction with other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		
		Label label = new Label(message);
		TextField password = new TextField();
		Button enter = new Button("Enter");
		enter.setOnAction(e -> {
			if(!password.getText().contentEquals("admin")) {
				AlertBox.displayAlert("Incorrect data", "Please, write a correct username");
			}else {
				window.close();
			}
		});
		
		window.setOnCloseRequest(e -> {
				Platform.exit();
	    });
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, password, enter);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		//Show and wait the other window
		window.showAndWait();
	}
	
	public static void bubble (int [] list) {
        int aux, n;
        n=list.length;
        for (int i=0; i<n-1; i++) {
        	for (int j=0; j< (n-1-i); j++) {
        		if (list [j]<list[j+1]) {
        			aux=list[j];
        			list[j]=list[j+1];
        			list[j+1]=aux;
        		}
        	}
        } 
    }//end bubble method. 
	
	private void updateSprites() {
		for (Sprite sprite:manager.getAllSprites()){
			myPlayer.eat(sprite,myScene);
		}
	}
	
	private void handledeath() {
		for (Sprite sprite:manager.getAllSprites()){
			if(sprite.getlife()){
				manager.addSpritesToBeRemoved(sprite);
				root.getChildren().remove(sprite.getSpriteImg());
			}
		}
		manager.cleanupSprites();
	}
	
}
