package logic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartWindow extends Scene {
private static final Font LABEL_FONT = Font.font("Arial", 22);
	
	private Pane root;
	private Canvas canvas;
	private TextField nameField;
	private Button backBtn;
	private Button startBtn;
	private Timeline screenloop;
	private Image b = new Image("forest.png");
	private Image nameplate = new Image("name3.png");
	private Image pbutton = new Image("pbutton.png");
	private Image pbuttonfade = new Image("pbuttonfade.png");
	private Image selecthero = new Image("selecth.png");
	private int page = 0;
	private int animationTick = 0;
	private Button knightBtn;
	private Button cowgirlBtn;
	
	public StartWindow() {
		super(new Pane(), 950, 600);
		root = (Pane) getRoot();
		
		canvas = new Canvas(950, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(b, 0, 0);
		gc.drawImage(nameplate, 0, 0);
		gc.drawImage(pbutton, 0, 0);
		addCanvasEventHandler();
		
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
	}
	
	
	private boolean isOnPlayButton(MouseEvent event) {
		return event.getX() >= 390 && event.getX() < 460 && event.getY() >= 420 && event.getY() < 520;
	}
	private void addCanvasEventHandler() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.setOnMouseMoved(e -> {
			if (page == 0) {
				if (isOnPlayButton(e)) {
					gc.drawImage(b, 0, 0);
					gc.drawImage(nameplate, 0, 0);
					gc.drawImage(pbuttonfade, 0, 0);
				}
				else {
					gc.drawImage(b, 0, 0);
					gc.drawImage(nameplate, 0, 0);
					gc.drawImage(pbutton, 0, 0);
				}
			}
		});
		canvas.setOnMouseClicked(e -> {
			if (page == 0 && isOnPlayButton(e)) {
				page = 1;
				screenloop.play();
			}
		});
	}
	private void addBackBtnHandler() {
		backBtn.setOnAction(e -> {
			nameField.setVisible(false);
			backBtn.setVisible(false);
			startBtn.setVisible(false);
			page = 0;
			screenloop.play();
		});
	}
	private void addStartBtnHandler() {
		startBtn.setOnAction(e -> {
			if (nameField.getText().trim().equals("")) {
				Alert alert = new Alert(AlertType.INFORMATION, "The name must not be empty");
				alert.setHeaderText(null);
				alert.setTitle("Name doesn't accepted");
				alert.getDialogPane().getScene().getWindow();
				alert.showAndWait();
			}
			knightBtn.setVisible(true);
			cowgirlBtn.setVisible(true);
			nameField.setVisible(false);
			backBtn.setVisible(false);
			startBtn.setVisible(false);
			page = 2;
			//GameManager.getInstance().startGame();
			//GameManager.getInstance().getPlayer().setName(nameField.getText().trim());
			screenloop.play();
		});
	}
	private void addknightBtnHandler() {
		knightBtn.setOnAction(e ->{
			page = 3;
			screenloop.play();
		});
	}
}