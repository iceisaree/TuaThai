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
		
<<<<<<< HEAD
		root.getChildren().addAll(bg);
		Scene scene = new Scene(root);
		bg.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("TuaThaiKraiGorDai");
||||||| merged common ancestors
		nameField = new TextField();
	    nameField.setMaxWidth(380);
	    nameField.setMinWidth(380);
	    nameField.setLayoutX(300);
	    nameField.setLayoutY(230);
	    nameField.setStyle("-fx-background-color:white;"
	    		+ "-fx-font-size:28px;"
	    		+ "-fx-font-family:Consolas;"
	    		+ "-fx-alignment:center;"
	    		+ "-fx-border-width:2px;"
	    		+ "-fx-border-color:black;"
	    		+ "-fx-border-radius:5px;");
	    nameField.setVisible(false);
		backBtn = new Button("Back");
		backBtn.setLayoutX(300);
		backBtn.setLayoutY(320);
		backBtn.setVisible(false);
		addBackBtnHandler();
		startBtn = new Button("OK");
		startBtn.setLayoutX(600);
		startBtn.setLayoutY(320);
		startBtn.setVisible(false);
		addStartBtnHandler();
		knightBtn = new Button("Knight !");
		knightBtn.setLayoutX(345);
		knightBtn.setLayoutY(300);
		knightBtn.setVisible(false);
		//addknightBtnHandler();
		cowgirlBtn = new Button("Cowgirl !");
		cowgirlBtn.setLayoutX(555);
		cowgirlBtn.setLayoutY(300);
		cowgirlBtn.setVisible(false);
		//addcowgirlBtnHandler();
		
		KeyFrame kf = new KeyFrame(Duration.seconds(1./60), e -> {
			if (page == 0 || page == 2) {
				animationTick--;
			}
			else if (page == 1) {
				animationTick++;
			}
			gc.drawImage(b, 0, 0);
			gc.drawImage(nameplate, 0, 0);
			gc.drawImage(pbutton, 0, 0);
			gc.setFill(Color.color(1, 1, 1, 0.1*animationTick/30));
			gc.fillRect(0, 0, 950, 600);
			gc.setFill(Color.BISQUE);
			gc.fillRoundRect(200, 600-15*animationTick, 570, 250, 100, 100);
			gc.setFont(LABEL_FONT);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFill(Color.BLACK);
			gc.fillText("Enter your name:", 475, 660-15*animationTick);
			if (page == 2) {
			  	knightBtn.setVisible(true);
				cowgirlBtn.setVisible(true);
				gc.setGlobalAlpha(1-animationTick/30.);
				gc.setFill(Color.BISQUE);
				gc.fillRect(0, 0, 950, 600);
				gc.setGlobalAlpha(1);
				gc.drawImage(selecthero, 0, 0);
			}
			if (page == 1 && animationTick == 30) {
				nameField.setVisible(true);
				backBtn.setVisible(true);
				startBtn.setVisible(true);
			}
			/*if (page == 3 && animationTick == 0) {
				Main.getStage().setScene(Main.getGameScene());
			}*/
		});
		screenloop = new Timeline();
		screenloop.setCycleCount(30);
		screenloop.getKeyFrames().add(kf);
		
		root.getChildren().addAll(canvas, nameField, backBtn, startBtn,knightBtn,cowgirlBtn);
=======
		nameField = new TextField();
	    nameField.setMaxWidth(380);
	    nameField.setMinWidth(380);
	    nameField.setLayoutX(300);
	    nameField.setLayoutY(230);
	    nameField.setStyle("-fx-background-color:white;"
	    		+ "-fx-font-size:28px;"
	    		+ "-fx-font-family:Consolas;"
	    		+ "-fx-alignment:center;"
	    		+ "-fx-border-width:2px;"
	    		+ "-fx-border-color:black;"
	    		+ "-fx-border-radius:5px;");
	    nameField.setVisible(false);
		backBtn = new Button("Back");
		backBtn.setLayoutX(300);
		backBtn.setLayoutY(320);
		backBtn.setVisible(false);
		addBackBtnHandler();
		startBtn = new Button("OK");
		startBtn.setLayoutX(600);
		startBtn.setLayoutY(320);
		startBtn.setVisible(false);
		addStartBtnHandler();
		knightBtn = new Button("Knight !");
		knightBtn.setLayoutX(345);
		knightBtn.setLayoutY(300);
		knightBtn.setVisible(false);
		//addknightBtnHandler();
		cowgirlBtn = new Button("Cowgirl !");
		cowgirlBtn.setLayoutX(555);
		cowgirlBtn.setLayoutY(300);
		cowgirlBtn.setVisible(false);
		//addcowgirlBtnHandler();
		
		KeyFrame kf = new KeyFrame(Duration.seconds(1./60), e -> {
			if (page == 0 || page == 2) {
				animationTick--;
			}
			else if (page == 1) {
				animationTick++;
			}
			gc.drawImage(b, 0, 0);
			gc.drawImage(nameplate, 0, 0);
			gc.drawImage(pbutton, 0, 0);
			gc.setFill(Color.color(1, 1, 1, 0.1*animationTick/30));
			gc.fillRect(0, 0, 950, 600);
			gc.setFill(Color.BISQUE);
			gc.fillRoundRect(200, 600-15*animationTick, 570, 250, 100, 100);
			gc.setFont(LABEL_FONT);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.setFill(Color.BLACK);
			gc.fillText("Enter your name:", 475, 660-15*animationTick);
			if (page == 2) {
			  	knightBtn.setVisible(true);
				cowgirlBtn.setVisible(true);
				gc.setGlobalAlpha(1-animationTick/30.);
				gc.setFill(Color.color(0.8, 0.8, 0.8, 0.9));
				gc.fillRect(0, 0, 950, 600);
				gc.setGlobalAlpha(1);
				gc.drawImage(selecthero, 0, 0);
			}
			if (page == 1 && animationTick == 30) {
				nameField.setVisible(true);
				backBtn.setVisible(true);
				startBtn.setVisible(true);
			}
			/*if (page == 3 && animationTick == 0) {
				Main.getStage().setScene(Main.getGameScene());
			}*/
		});
		screenloop = new Timeline();
		screenloop.setCycleCount(30);
		screenloop.getKeyFrames().add(kf);
		
		root.getChildren().addAll(canvas, nameField, backBtn, startBtn,knightBtn,cowgirlBtn);
>>>>>>> 9eb7354f06e81ecfa780bfa0a3e328c32d1398cc
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
