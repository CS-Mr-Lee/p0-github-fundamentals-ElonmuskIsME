package view;

import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.RPGButton;
import model.RPGSubScene;

public class ViewManager {
	private static final int HIGH = 528;
	private static final int WIDTH = 824;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	
	private final static int MENU_BUTTON_STARTER_X = 80;
	private final static int MENU_BUTTON_STARTER_Y = 150;
	
	private RPGSubScene scoreSubScene;
	private RPGSubScene helpSubScene;
	private RPGSubScene creditsSubScene;
	
	List<RPGButton> menuButtons;
	
	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH,HIGH);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createButton();
		createBackground();
		createLogo();
		
		createSubScene();
		
	}
	
	public Stage getMainStage() {
		return mainStage;
		
	}
	
	private void addMenuButton(RPGButton button) {
		button.setLayoutX(MENU_BUTTON_STARTER_X);
		button.setLayoutY(MENU_BUTTON_STARTER_Y + menuButtons.size() * 70);
		menuButtons.add(button);
		mainPane.getChildren().add(button);
		
	}
	
	private void createButton() {
		createStartButton(); 
		createScoreButton();
		createHelpButton();
		createCreditsButton();
		createExitButton();
	}
	
	private void createStartButton() {
		RPGButton startButton = new RPGButton("PLAY");
		addMenuButton(startButton);
	}
	
	private void createScoreButton() {
		RPGButton scoreButton = new RPGButton("SCORE");
		addMenuButton(scoreButton);
	}
	
	private void createHelpButton() {
		RPGButton helpButton = new RPGButton("HELP");
		addMenuButton(helpButton);
		
	}
	
	private void createCreditsButton() {
		RPGButton creditsButton = new RPGButton("CREDITS");
		addMenuButton(creditsButton);
	}
	
	private void createExitButton() {
		RPGButton exitButton = new RPGButton("EXIT");
		addMenuButton(exitButton);
	}

	
	
	private void createBackground() {
		Image backgroundImage = new Image ("file:///D:/ICS4U/Eclipse/javacodes/finalRPG/src/view/resources/FA8mTI0VIAQRqst.jpg", 824, 528, false, true);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		mainPane.setBackground(new Background(background));
	}
	
	private void createLogo() {
		ImageView logo = new ImageView ("file:///D:/ICS4U/Eclipse/javacodes/finalRPG/src/view/resources/27974-5-league-of-legends-logo-transparent-background-thumb.png");
		logo.setLayoutX(500);
		logo.setLayoutY(-10);
		mainPane.getChildren().add(logo);
		
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
				
			}
			
			
		});
		
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);
			}
			
			
		});
		
	}
	
	private void createSubScene () {
		scoreSubScene = new RPGSubScene();
		mainPane.getChildren().add(scoreSubScene);
		
		
		
		
	}
}
