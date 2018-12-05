package logic;

import java.net.URL;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameOverScene {
	public static String image_path = ClassLoader.getSystemResource("endgameScene.png").toString();
	 
	public static void draw(GraphicsContext gc) {
		Image image1 = new Image(image_path);
		gc.drawImage(image1, 0, 0);
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

}
