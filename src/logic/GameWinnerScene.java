package logic;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameWinnerScene {
	protected static int Score1;
	public static String background = ClassLoader.getSystemResource("winnerScene.png").toString();
	public static String[] gameWinChar = {"G","a","m","e"," ","C","l","e","a","r",",","p","l","e","a","s","e"," ","c","h","o","s","e"," ","g","o"," ","t","o"," ","m","e","n","u"," ","o","r"," ","e","x","i","t"};
	private static Canvas bg;
	private static GraphicsContext gc;
	public static final Font CLEAR_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),40);
	public GameWinnerScene(Stage primaryStage) {
		bg = new Canvas(950,600);
		gc = bg.getGraphicsContext2D();
	}
	public static void draw(GraphicsContext gc) {
		addCanvasEventHandler();
		Thread t = new Thread() {
		public void run(){
		Image winnerImage = new Image(background);
		gc.drawImage(winnerImage, 0, 0);
		gc.setFont(CLEAR_FONT);
		gc.setFill(Color.GOLD);
		gc.fillText("This is your score", 300, 350);
		gc.fillText(String.valueOf(Score1), 425, 400);
		String text ="";
		for(int k=0;k<=gameWinChar.length;k++) {
			text+=gameWinChar[k];
			System.out.println(""+text+" "+k+" "+gameWinChar[k]);
			gc.strokeText(text, 50, 275);
			gc.fillText(text, 50, 275);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	};
	t.setDaemon(true);
	t.start();
	}
	private static boolean isOnPlayAgainBtn(MouseEvent e) {
		// TODO Auto-generated method stub
		return e.getX() >= 30 && e.getX() < 130 && e.getY() >= 500 && e.getY() < 570;
	}
	private static void addCanvasEventHandler() {
		//GraphicsContext gc = bg.getGraphicsContext2D();
		bg.setOnMouseClicked(e->{
			if (isOnPlayAgainBtn(e)) {
				System.out.println("true");
			}
		});
	}
	
	public static void setScore(int score) {
		Score1 = score;
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

}
