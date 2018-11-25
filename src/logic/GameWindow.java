package logic;
import share.IRenderable;
import share.RenderableHolder;
import character.Knight;
import character.Cowgirls;
import java.awt.event.KeyEvent;
import java.util.Random;
import character.Minion1;
import character.Minion2;
import character.Minion3;

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
	private Knight knight;
	private Cowgirls cowgirls;
	private GraphicsContext gc;
	private int f;
	private Minion1 minion1;
	private Minion2 minion2;
	private Minion3 minion3;
	private String control;
	private char c;
	private boolean alreadyAddBoss;
	private boolean allBossDead;
	private static AnimationTimer gamewindowanimation;
	private boolean gameEnd = false;
	private PlayerDetail playerDetail;
	Random rand = new Random();
	int value = rand.nextInt(3);
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
		f = 0;
		gamewindowanimation = new AnimationTimer() {
		public void handle(long now) {
			upPlayerDetail();
			changeSong();
			isGameEnd;
			}
		};
	}
	public void upPlayerDetail() {
		
	}
	
public void addMoving(GraphicsContext gc) {
	this.setOnKeyPressed((KeyEvent) -> {
		

		if (KeyEvent.getCode() == KeyCode.RIGHT) {
			control+="k";
			c='k';
			System.out.println(control);
		}
		if (KeyEvent.getCode() == KeyCode.UP) {
			control+="u";
			c='u';
			System.out.println(control);
			
		}
		
		if (KeyEvent.getCode() == KeyCode.DOWN) {
			control += "j";
			c = 'j';
			System.out.println(control);
			
		}if (KeyEvent.getCode() == KeyCode.LEFT) {
			control += "h";
			c = 'h';
			System.out.println(control);
		}
		if (KeyEvent.getCode() == KeyCode.D) {
			control+="d";
			c='d';
			System.out.println(control);
		}
		if (KeyEvent.getCode() == KeyCode.W) {
			control+="w";
			c='w';
			System.out.println(control);
			
		}
		
		if (KeyEvent.getCode() == KeyCode.S) {
			control += "s";
			c = 's';
			System.out.println(control);
			
		}if (KeyEvent.getCode() == KeyCode.A) {
			control += "a";
			c = 'a';
			System.out.println(control);
		}
		
		});
	this.setOnKeyReleased((KeyEvent) -> {
		
		if (KeyEvent.getCode() == KeyCode.RIGHT) {
			control = control.replace("k", "");
			RenderableHolder.getinstance().updatePos(control);
		}
		if (KeyEvent.getCode() == KeyCode.UP) {
			control = control.replace("u", "");
			RenderableHolder.getinstance().updatePos(control);
		}if (KeyEvent.getCode() == KeyCode.DOWN) {
			control = control.replace("j","");
			RenderableHolder.getinstance().updatePos(control);
		}if (KeyEvent.getCode() == KeyCode.LEFT) {
			control = control.replace("h","");
			RenderableHolder.getinstance().updatePos(control);
		}

		if (KeyEvent.getCode() == KeyCode.D) {
			control = control.replace("d", "");
			RenderableHolder.getinstance().updatePos(control);
		}
		if (KeyEvent.getCode() == KeyCode.W) {
			control = control.replace("w", "");
			RenderableHolder.getinstance().updatePos(control);
		}if (KeyEvent.getCode() == KeyCode.S) {
			control = control.replace("s","");
			RenderableHolder.getinstance().updatePos(control);
		}if (KeyEvent.getCode() == KeyCode.A) {
			control = control.replace("a","");
			RenderableHolder.getinstance().updatePos(control);
		}
		
	});
	
}
public static AnimationTimer getGamewindowanimation() {
	return gamewindowanimation;
}
	public void updateDetail() {
	f++;
	
}
	public void addKnight() {
		knight = new Knight();
		RenderableHolder.getinstance().add(knight);
	}
	public void addCowgirls() {
		cowgirls = new Cowgirls();
		RenderableHolder.getinstance().add(cowgirls);
	}
	public void addMinion() {
		//add more minion
		if (value==0) {
			minion1 = new Minion1();
			RenderableHolder.getinstance().add(minion1);
		}
		if (value==1) {
			minion2 = new Minion2();
			RenderableHolder.getinstance().add(minion2);
		}
		if (value==2) {
			minion3 = new Minion3();
			RenderableHolder.getinstance().add(minion3);
		}
	}
	public void addAll() {
	addPlayerDetail();
	addKnight();
	addCowgirls();
	addMinion();
	
}
	public void addPlayerDetail() {
		playerDetail = new PlayerDetail();
		RenderableHolder.getinstance().add(playerDetail);
	}
	public void isGameEnd() {
		if (Knight.getHp()==0 && Cowgirls.getHp()==0) {
			RenderableHolder.getinstance().clearList();
			gamewindowanimation.stop();
			GameOverScene.startAnimation(gc);
			
			gameEnd = true;
			
		}
		if (alreadyAddBoss && allBossDead) {
			RenderableHolder.getinstance().clearList();
			gamewindowanimation.stop();
			GameWinnerScene.startAnimation(gc);
		}
	}
	//add getLevel in cowgirls and set attack in knight and cowgirls
	public void setState() {
		if (knight.getLevel()+cowgirls.getLevel()<5) {
			knight.setSpeed(3);
			knight.setAttack();
			cowgirls.setSpeed(2);
			cowgirls.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirls.getLevel()<10) {
			knight.setSpeed(3);
			knight.setAttack();
			cowgirls.setSpeed(2);
			cowgirls.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirls.getLevel()<15) {
			knight.setSpeed(3);
			knight.setAttack();
			cowgirls.setSpeed(2);
			cowgirls.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirls.getLevel()<20) {
			knight.setSpeed(3);
			knight.setAttack();
			cowgirls.setSpeed(2);
			cowgirls.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		
	}
		
}

