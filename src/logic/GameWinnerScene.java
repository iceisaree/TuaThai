package logic;

import javafx.scene.canvas.GraphicsContext;

public class GameWinnerScene {
	public static void draw(GraphicsContext gc) {
		gc.fillText("Game Clear,please chose go to menu or exit",300,200);
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}
	
}
