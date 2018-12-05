package logic;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.canvas.Canvas;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class GameOverScene {
	protected static int Score1;
	private static Canvas bg;
	private static boolean isFinished;
	public static String image_path = ClassLoader.getSystemResource("endgameScene.png").toString();
	public static final Font FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),20);
	public static final Font BIG_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),40);
	public static String[] gameOverChar3 = {"P","R","E","S","S"," ","E","N","T","E","R"," ","T","O"," ","G","O"," ","T","O"," ","M","A","I","N"," ","M","E","N","U"};
	public static String[] gameOverChar2 = {"A","N","D"," ","T","R","Y"," ","A","G","A","I","N"};
	public GameOverScene(Stage primaryStage) {
		bg = new Canvas(950,600);
	
	}
	public static void draw(GraphicsContext gc) {
		Thread t2 = new Thread() {
		public void run() {
		Image image1 = new Image(image_path);
		gc.drawImage(image1, 0, 0);
		gc.setFont(BIG_FONT);
		gc.setFill(Color.RED);
		gc.fillText("This is your score", 325, 350);
		gc.fillText(String.valueOf(Score1), 435, 400);

		gc.setFill(Color.WHITE);
		gc.setFont(FONT);
		String text ="";
		for(int k=0;k<gameOverChar3.length;k++) {
			text+=gameOverChar3[k];
			System.out.println(""+text+" "+k+" "+gameOverChar3[k]);
			gc.strokeText(text, 300, 490);
			gc.fillText(text, 300, 490);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String text2="";
		for(int k=0;k<gameOverChar2.length;k++) {
			text2+=gameOverChar2[k];
			System.out.println(""+text2+" "+k+" "+gameOverChar2[k]);
			gc.strokeText(text2, 370, 550);
			gc.fillText(text2, 370, 550);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		isFinished = true;
	}

		};
		t2.setDaemon(true);
		t2.start();
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}
	public static void setScore(int score) {
		Score1 = score;
	}
	public static boolean isFinished() {
		return isFinished;
	}

}
