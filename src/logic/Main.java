package logic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage stage;
	private static Scene startScene;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage inputStage) throws Exception {
		stage = inputStage;
		startScene = new StartWindow();
		stage.setTitle("TuaThaiKraiGorDai");
		stage.setScene(startScene);
		stage.show();
	}
}