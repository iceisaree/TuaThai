package logic;

import java.awt.event.MouseEvent;

import logic.GameWindow;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartWindow {
	private Stage primaryStage;
	private Canvas bg;
	
	private GraphicsContext gc;
	private Image background = new Image(ClassLoader.getSystemResource("forest.png").toString());
	private Image name = new Image(ClassLoader.getSystemResource("name3.png").toString());
	private Image pbutton = new Image(ClassLoader.getSystemResource("pbutton.png").toString());
	private Image pbuttonfade = new Image(ClassLoader.getSystemResource("pbuttonfade.png").toString());
	private Image exitButton = new Image(ClassLoader.getSystemResource("ex.png").toString());
	private Image exitButtonfade = new Image(ClassLoader.getSystemResource("exfade.png").toString());
	private Image creditButton = new Image(ClassLoader.getSystemResource("cr.png").toString());
	private Image creditButtonfade = new Image(ClassLoader.getSystemResource("crfade.png").toString());
	public AudioClip soundbg = new AudioClip(ClassLoader.getSystemResource("startgame.mp3").toString());
	
	public StartWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		bg = new Canvas(950,600);
		gc = bg.getGraphicsContext2D();
		soundbg.play();
	}
	public void draw(GraphicsContext gc) {
		Pane root = new Pane();
		root.setPrefSize(950, 600);
		
		setBackground();
		addCanvasEventHandler();
		
		root.getChildren().addAll(bg);
		Scene scene = new Scene(root);
		bg.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TuaThaiKraiGorDai");
		
	}
	private boolean isOnPlayButton(javafx.scene.input.MouseEvent e) {
		return e.getX() >= 350 && e.getX() < 525 && e.getY() >= 420 && e.getY() < 540;
	}
	private boolean isOnExitButton(javafx.scene.input.MouseEvent e) {
		return e.getX() >= 770 && e.getX() < 890 && e.getY() >= 500 && e.getY() < 570;
	}
	private boolean isOnCreditButton(javafx.scene.input.MouseEvent e) {
		return e.getX() >= 30 && e.getX() < 130 && e.getY() >= 500 && e.getY() < 570;
	}
	
	private void addCanvasEventHandler() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		bg.setOnMouseMoved(e -> {
			if (isOnPlayButton(e)) {
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbuttonfade, 0, 0);
				gc.drawImage(exitButton, 0, 0);
				gc.drawImage(creditButton, 0, 0);
			}
			else if (isOnExitButton(e)) {
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbutton, 0, 0);
				gc.drawImage(exitButtonfade, 0, 0);
				gc.drawImage(creditButton, 0, 0);
			}
			else if (isOnCreditButton(e)) {
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbutton, 0, 0);
				gc.drawImage(exitButton, 0, 0);
				gc.drawImage(creditButtonfade, 0, 0);
			}
			else {
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbutton, 0, 0);
				gc.drawImage(exitButton, 0, 0);
				gc.drawImage(creditButton, 0, 0);
			}
			
		});
		bg.setOnMouseClicked(e -> {
			if (isOnPlayButton(e)) {
				GameWindow game = new GameWindow(primaryStage);
				game.drawGameWindow();
				soundbg.stop();
			}
			if (isOnExitButton(e)) {
				Platform.exit();
			}
			if (isOnCreditButton(e)) {
				CreditWindow cr = new CreditWindow(primaryStage);
				cr.drawCreditWindow();
				//soundbg.stop();
			}
			
		});
	}
	
	public void setBackground() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, bg.getWidth(), bg.getHeight());
		gc.drawImage(background, 0,0);
		gc.drawImage(name, 0, 0);
		gc.drawImage(pbutton, 0, 0);
		gc.drawImage(exitButton, 0, 0);
		gc.drawImage(creditButton, 0, 0);
		
	}
	public void startAnimation() {
		draw(gc);
		
	}

	
}
