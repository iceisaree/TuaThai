
package logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameWinnerScene {
	protected static int Score1;
	public static String background = ClassLoader.getSystemResource("winnerScene.png").toString();
	public static String[] gameWinChar = {"G","a","m","e"," ","C","l","e","a","r",",","p","l","e","a","s","e"," ","c","h","o","s","e"," ","g","o"," ","t","o"," ","m","e","n","u"," ","o","r"," ","e","x","i","t"};
	private static Canvas bg;
	public static final Font CLEAR_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),40);
	public static final Font PRESS_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),20);
	public static boolean isFinished = false;
	public GameWinnerScene(Stage primaryStage) {
		bg = new Canvas(950,600);
		
		
	}
	public static void draw(GraphicsContext gc) {
		Thread t = new Thread() {
		public void run(){
		Image winnerImage = new Image(background);
		gc.drawImage(winnerImage, 0, 0);
		gc.setFont(CLEAR_FONT);
		gc.setFill(Color.GOLD);
		gc.fillText("This is your score", 300, 350);
		gc.fillText(String.valueOf(Score1), 425, 400);
		
		String text ="";
		for(int k=0;k<gameWinChar.length;k++) {
			text+=gameWinChar[k];
			System.out.println(""+text+" "+k+" "+gameWinChar[k]);
			gc.strokeText(text, 50, 275);
			gc.fillText(text, 50, 275);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("thread has been interrupted");
				break;
			}
		}
		//gc.drawImage(exit, 0, 0);
		gc.setFill(Color.WHITE);
		gc.setFont(PRESS_FONT);
		gc.fillText("PRESS ENTER TO GO TO MAIN MENU", 300, 490);
		gc.fillText("PRESS ESC TO EXIT", 370, 550);
		isFinished = true;

		
		}
	};
	t.setDaemon(true);
	t.start();
	}
		
	public static void setScore(int score) {
		Score1 = score;
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
		
	}
	public static boolean isFinished() {
		return isFinished;
	}

}
