package logic;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreditWindow extends Canvas {
	private Scene scene;
	private Stage primaryStage;
	private GraphicsContext gc;
	private Canvas bg;
	
	public CreditWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		bg = new Canvas(950,600);
	}
	
	public void drawCreditWindow() {
		
	}
}
