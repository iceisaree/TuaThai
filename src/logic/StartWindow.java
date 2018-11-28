package logic;

import java.awt.event.MouseEvent;

import logic.GameWindow;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartWindow {
	private static final Font LABEL_FONT = Font.font("Arial", 22);
	private Stage primaryStage;
	private Canvas bg;
	private GraphicsContext gc;
	public Image background = new Image("forest.png");
	private Image name = new Image("name3.png");
	private Image pbutton = new Image("pbutton.png");
	private Image pbuttonfade = new Image("pbuttonfade.png");
	private int check= 0;
	
	public StartWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		bg = new Canvas(950,600);
		gc = bg.getGraphicsContext2D();
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
		return e.getX() >= 390 && e.getX() < 460 && e.getY() >= 420 && e.getY() < 520;
	}
	private void addCanvasEventHandler() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		bg.setOnMouseMoved(e -> {
			if (isOnPlayButton(e)) {
				check=1;
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbuttonfade, 0, 0);
				
			}
			else {
				check=0;
				gc.drawImage(background, 0, 0);
				gc.drawImage(name, 0, 0);
				gc.drawImage(pbutton, 0, 0);
			}
			
		});
		bg.setOnMouseClicked(e -> {
			if (isOnPlayButton(e)) {
				GameWindow game = new GameWindow(primaryStage);
				game.drawGameWinDow();
			}
			
		});
	}
	
	public void setBackground() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, bg.getWidth(), bg.getHeight());
		gc.drawImage(background, 0,0);
		gc.drawImage(name, 0, 0);
		Image playbutton = new Image("pbutton.png");
		gc.drawImage(playbutton, 0, 0);
	}
	public void startAnimation() {
		draw(gc);
		
	}
	
	
	
	
}
