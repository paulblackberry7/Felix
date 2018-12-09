package presentation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainClass extends Application{

	private int fps = 60;
    private Game myGame;
    
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage s) {
    	myGame = new Game(s);
        s.setTitle(myGame.getTitle());
        final int MILLISECOND_DELAY = 1000 / fps;
        final double SECOND_DELAY = 1.0 / fps;
        // attach game to the stage and display it
        boolean result = ConfirmBox.display("Login", "Are you an admin?");
        Scene scene = null;
        if(!result) {
        	scene = myGame.startmenu();
		}else {
			myGame.login("Login", "Introduce your password");
			scene = myGame.startmenuAdmin();
		}  
        s.setScene(scene);
        s.show();
        
        // sets the game's loop
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                                      e -> myGame.step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }
	
}
