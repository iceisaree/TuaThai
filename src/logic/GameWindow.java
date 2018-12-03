package logic;

import share.IRenderable;
import share.RenderableHolder;
import character.Cowgirls;
import character.Knight;

import java.awt.event.KeyEvent;
import java.util.Random;

import com.sun.javafx.tk.PlatformImage;

import character.Minion1;
import character.Minion2;
import character.Minion3;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends Canvas {
	private Scene scene;
	private int cooldownKnight1;
	private int cooldownKnight2;
	private int cooldownCowgirl1;
	private int cooldownCowgirl2;
	private Stage primaryStage;
	private Knight knight;
	private Cowgirls cowgirl;
	private GraphicsContext gc;
	private int f;
	private Minion1 minion1;
	private Minion2 minion2;
	private Minion3 minion3;
	private int countMinion = 1;
	private String control="";
	private char c;
	private String image_path = "file:image/character/cowboy/Dead__001.png";
	private int FireTimes = 0;
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
		addAll();
		
		requestFocus();
	}
	// if add addAll() in drawGameWindow it will be bug in thread
	public void drawGameWindow() {
		addMoving(gc);
		f = 0;
		gamewindowanimation = new AnimationTimer() {
		public void handle(long now) {
			updateDetail();
			upPlayerDetail();
			isGameEnd();
			//addBackground();
			
			}
		};
		gamewindowanimation.start();
	}
	public void upPlayerDetail() {
		
	}
	public void fire() {
		
			
			// for add sound fire.play();
			cowgirl.attack2('q');
			cowgirl.attack2('w');
			cowgirl.attack2('d');
			cowgirl.attack2('a');
			cowgirl.attack2('x');
			cowgirl.attack2('e');
			cowgirl.attack2('c');
			cowgirl.attack2('z');
		
	}
	
public void addMoving(GraphicsContext gc) {
	this.setOnKeyPressed((KeyEvent) -> {
		if (KeyEvent.getCode() == KeyCode.Q) {
			// for add sound skill fire.play();
			if (cooldownKnight1==0) {
				knight.attack(c);
				cooldownKnight1 = 180;
			}
			
		}
		if (KeyEvent.getCode() == KeyCode.E) {
			// for add sound skill fire.play();
			if (cooldownKnight2==0) {
				knight.attack2(c);
				cooldownKnight2 = 180;
			}
		}
		if (KeyEvent.getCode() == KeyCode.N) {
			// for add sound skill fire.play();
			if (cooldownCowgirl1==0) {
				girlShoot();
				cooldownCowgirl1 = 180;
			}
		}
		if (KeyEvent.getCode() == KeyCode.M) {
			// for add sound skill fire.play();
			if (cooldownCowgirl2==0) {
				fire();
				cooldownCowgirl2 = 180;
			}
		}

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
		value = rand.nextInt(3);
		//System.out.println("this is update detail");
		//System.out.println("this is frame : "+ f);
		if ((f%600)<500)
			{
				if (f%60 ==0) {
					// maxCountMinion can change is 2
					for(int i = countMinion ; i>0 ; i--) {
						addMinion();
						
					}
				}
				// add item by time
				// add Character detail
				// add cooldown and add Skill
			}

		addBackground();
			int exp2 = RenderableHolder.getinstance().setVisible2();
			int exp = RenderableHolder.getinstance().setVisible();
			
			RenderableHolder.getinstance().remove();
			RenderableHolder.getinstance().draw(gc);
			
			
			cowgirl.setExp(cowgirl.getExp()+exp);
			cowgirl.updateLevel();
			knight.setExp(knight.getExp()+exp2);
			knight.updateLevel();
			playerDetail.setKnightData(knight.getMaxExp(),knight.getExp(),knight.getLevel(),knight.getMaxHp(),knight.getHp());
			playerDetail.setCowgirlData(cowgirl.getMaxExp(),cowgirl.getExp(), cowgirl.getLevel(), cowgirl.getMaxHp(), cowgirl.getHp());
				
			
			//set knight and cowgirls detail
		
			if (cooldownKnight1!=0) cooldownKnight1--;
			if (cooldownKnight2!=0) cooldownKnight2--;
			if (cooldownCowgirl1!=0) cooldownCowgirl1--;
			if (cooldownCowgirl2!=0) cooldownCowgirl2--;
			
			
			
			
			playerDetail.setCooldownKnight(cooldownKnight1,cooldownKnight2);
			playerDetail.setCooldownCowgirl(cooldownCowgirl1, cooldownCowgirl2);
		
			
			RenderableHolder.getinstance().updatePos(control);

	}
	public void addKnight() {
		knight = new Knight("knight");
		RenderableHolder.getinstance().add(knight);
	}
	public void addcowgirl() {
		cowgirl = new Cowgirls("cowgirl");
		RenderableHolder.getinstance().add(cowgirl);
	}
	public void addMinion() {
		//add more minion
		if (value==0) {
			minion1 = new Minion1(knight,cowgirl);
			RenderableHolder.getinstance().add(minion1);
		}
		System.out.println(value);
		if (value==1) {
			minion2 = new Minion2(knight,cowgirl);
			RenderableHolder.getinstance().add(minion2);
			System.out.println("zombieeeee");
		}
		if (value==2) {
			minion3 = new Minion3(knight,cowgirl);
			RenderableHolder.getinstance().add(minion3);
			System.out.println("cowboyyyyy");
		}
	}
	/*public void addMinion2() {
		minion2 = new Minion2(knight,cowgirl);
		RenderableHolder.getinstance().add(minion2);
	}*/
	public void addAll() {
	addPlayerDetail();
	addKnight();
	addcowgirl();
	addMinion();
	//addMinion2();
	//addBackground();
	
}
	public void addPlayerDetail() {
		playerDetail = new PlayerDetail();
		RenderableHolder.getinstance().add(playerDetail);
	}
	public void isGameEnd() {
		if (knight.getHp()==0 && cowgirl.getHp()==0) {
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
	//add getLevel in cowgirl and set attack in knight and cowgirl
	public void setState() {
		if (knight.getLevel()+cowgirl.getLevel()<5) {
			knight.setSpeed(3);
			//knight.setAttack();
			cowgirl.setSpeed(2);
			//cowgirl.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirl.getLevel()<10) {
			knight.setSpeed(3);
			//knight.setAttack();
			cowgirl.setSpeed(2);
			//cowgirl.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirl.getLevel()<15) {
			knight.setSpeed(3);
			//knight.setAttack();
			cowgirl.setSpeed(2);
			//cowgirl.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		if (knight.getLevel()+cowgirl.getLevel()<20) {
			knight.setSpeed(3);
			//knight.setAttack();
			cowgirl.setSpeed(2);
			//cowgirl.setAttack();
			minion1.setDamage(10);
			minion2.setDamage(20);
			minion3.setDamage(40);
		}
		
	}
	// add updateState for rander window
	// add background stage
	public void addBackground() {
		Image imagenew = new Image("winter.png");

		gc.drawImage(imagenew, 0, 0);
		//gc.drawImage(imagek,0,0);
	
	}
	public void girlShoot() {
		cowgirl.attack('h',20,20);
		cowgirl.attack('j',20,20);
		cowgirl.attack('u',20,20);
		cowgirl.attack('k',20,20);
		
	}
		
}

