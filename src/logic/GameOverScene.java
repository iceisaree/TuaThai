package logic;

import java.net.URL;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class GameOverScene {
	protected static int Score1;
	private static Canvas bg;
	private static GraphicsContext gc;
	public static String image_path = ClassLoader.getSystemResource("endgameScene.png").toString();
	public static final Font FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),20);
	public static final Font BIG_FONT = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),40);
	
	public GameOverScene(Stage primaryStage) {
		bg = new Canvas(950,600);
		gc = bg.getGraphicsContext2D();
	}
	public static void draw(GraphicsContext gc) {
		Thread t = new Thread() {
		public void run() {
		Image image1 = new Image(image_path);
		gc.drawImage(image1, 0, 0);
		gc.setFont(BIG_FONT);
		gc.setFill(Color.RED);
		gc.fillText("This is your score", 325, 350);
		gc.fillText(String.valueOf(Score1), 435, 400);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gc.setFill(Color.WHITE);
		gc.setFont(FONT);
		gc.fillText("PRESS ENTER TO GO TO MAIN MENU", 300, 490);
		gc.fillText("AND TRY AGANIN",370,550);
		
	}

		};
		t.setDaemon(true);
		t.start();
	}
	public static void startAnimation(GraphicsContext gc) {
		draw(gc);
	}

}
