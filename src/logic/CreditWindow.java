package logic;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreditWindow extends Canvas {
	private Scene scene;
	private Stage primaryStage;
	private GraphicsContext gc;
	private Canvas bg;
	private Image name = new Image("crscene.png");
	private Image back = new Image("back.png");
	private Image backp = new Image("backfade.png");
	
	public CreditWindow(Stage primaryStage) {
		this.primaryStage = primaryStage;
		bg = new Canvas(950,600);
	}
	
	public void drawCreditWindow() {
		Pane root = new Pane();
		root.setPrefSize(950, 600);
		
		setBackground();
		addCanvasEventHandler();
		
		root.getChildren().addAll(bg);
		Scene scene = new Scene(root);
		this.primaryStage.setScene(scene);
		
	}
	private void addCanvasEventHandler() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		bg.setOnMouseMoved(e -> {
			if (isOnBackButton(e)) {
				//gc.drawImage(name, 0, 0);
				gc.drawImage(backp, 0, 0);
			}
			else {
				//gc.drawImage(name, 0, 0);
				gc.drawImage(back, 0, 0);
			}
		});
		bg.setOnMouseClicked(e -> {
			if (isOnBackButton(e)) {
				StartWindow startwindow = new StartWindow(primaryStage);
				startwindow.startAnimation();
				
			}
		});
	}

	private boolean isOnBackButton(MouseEvent e) {
		// TODO Auto-generated method stub
		return e.getX() >= 30 && e.getX() < 130 && e.getY() >= 500 && e.getY() < 570;
	}
	private void setBackground() {
		GraphicsContext gc = bg.getGraphicsContext2D();
		gc.drawImage(name, 0, 0);
		gc.drawImage(back, 0, 0);
	}
}
