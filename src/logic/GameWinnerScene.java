package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameWinnerScene {
	protected int Score1;
	
	public void draw(GraphicsContext gc) {
		Image winnerImage = new Image("winter.png");
		gc.drawImage(winnerImage, 0, 0);
		gc.fillText("This is your score", 600, 400);
		gc.fillText(String.valueOf(Score1), 600, 450);
		gc.fillText("Game Clear,please chose go to menu or exit",300,200);
	}
	public void setScore(int score) {
		this.Score1 = score;
	}
	public void startAnimation(GraphicsContext gc) {
		draw(gc);
	}
	
}
