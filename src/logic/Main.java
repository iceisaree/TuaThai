package logic;
	
import logic.StartWindow;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		StartWindow startwindow = new StartWindow(primaryStage);
		startwindow.startAnimation();
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
