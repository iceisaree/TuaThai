package logic;
import share.IRenderable;
import share.RenderableHolder;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends Canvas {
	private Scene scene;
	private Stage primaryStage;
	private GraphicsContext gc;
	private int frame;
	private String control;
	private char c;
	private AnimationTimer gamewindowanimation;
	
	public GameWindow(Stage primaryStage) {
		setWidth(950);
		setHeight(600);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane s = new StackPane();
		s.getChildren().add(gc.getCanvas());
		scene = new Scene(s);
		this.primaryStage.setScene(scene);
		
	}
	public void drawGameWinDow() {	
		frame = 0;
		gamewindowanimation = new AnimationTimer() {
		public void handle(long now) {
			updateDetail();
			//updateState();
			}
		};
	}
public void addMoving(GraphicsContext gc) {
	this.setOnKeyPressed((KeyEvent) -> {
		

		if (KeyEvent.getCode() == KeyCode.RIGHT) {
			control+="d";
			c='d';
			System.out.println(control);
		}
		if (KeyEvent.getCode() == KeyCode.UP) {
			control+="w";
			c='w';
			System.out.println(control);
			
		}
		
		});
	this.setOnKeyReleased((KeyEvent) -> {
		
		if (KeyEvent.getCode() == KeyCode.RIGHT) {
			control = control.replace("d", "");
			RenderableHolder.getinstance().updatePos(control);
		}
		if (KeyEvent.getCode() == KeyCode.UP) {
			control = control.replace("w", "");
			RenderableHolder.getinstance().updatePos(control);
		}
		
	});
	
}
	public void updateDetail() {
	frame++;
	
}
	public void addAll() {
	//addGameScreen();
	//addKnight();
	
}
		
}

