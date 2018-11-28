package logic;

import javafx.scene.canvas.GraphicsContext;

public class GameOverScene {
	public static void draw(GraphicsContext gc) {
		gc.fillText("GameOver,press ENTER to start new game", 300, 200);
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

}
