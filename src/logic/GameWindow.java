package logic;

import share.RenderableHolder;
import character.Cowgirls;
import character.Knight;
import java.util.Random;
import character.*;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class GameWindow extends Canvas {
	private Scene scene;
	private boolean alreadyAddAllBoss;
	private boolean isBossDead;
	private int cooldownKnight1;
	private int cooldownKnight2;
	private int cooldownCowgirl1;
	private int cooldownCowgirl2;
	private Stage primaryStage;
	private Knight knight;
	private Cowgirls cowgirl;
	private GraphicsContext gc;
	private int f;
	private int score;
	private Minion1 minion1;
	private Minion2 minion2;
	private Minion3 minion3;
	private String control="";
	private char c;
	private Boss1 boss1;
	private Boss2 boss21,boss22,boss23,boss24;
	private Boss3 boss31,boss32,boss33,boss34,boss35,boss36,boss37,boss38;
	private boolean alreadyAddBoss1 = false;
	private boolean alreadyAddBoss2 = false;
	private boolean alreadyAddBoss3 = false;
	private boolean addedBoss = false;
	private boolean haveBoss;
	private static AnimationTimer gamewindowanimation;
	private PlayerDetail playerDetail;
	Random rand = new Random();
	int value = 0;
	public AudioClip cowgirlskill1sound = new AudioClip(ClassLoader.getSystemResource("cowgirlskill1.wav").toString());
	public AudioClip bggamesound = new AudioClip(ClassLoader.getSystemResource("bggame.mp3").toString());
	public AudioClip bosssound = new AudioClip(ClassLoader.getSystemResource("boss.mp3").toString());
	public AudioClip soundbg = new AudioClip(ClassLoader.getSystemResource("startgame.mp3").toString());
	
	public GameWindow(Stage primaryStage) {
		setWidth(950);
		setHeight(600);
		this.primaryStage = primaryStage;
		gc = getGraphicsContext2D();
		StackPane s = new StackPane();
		s.getChildren().add(gc.getCanvas());
		scene = new Scene(s);
		score = 0;
		this.primaryStage.setScene(scene);
		addAll();
		bggamesound.play();
		
		requestFocus();
	}
	// if add addAll() in drawGameWindow it will be bug in thread
	public void drawGameWindow() {
		addMoving(gc);
		f = 0;
		gamewindowanimation = new AnimationTimer() {
		public void handle(long now) {
			updateDetail();
			updateSong();
			isGameEnd();
			//addBackground();
			
			}
		};
		gamewindowanimation.start();
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
			if (cooldownKnight1==0 && knight.isVisible()==true) {
				knight.attack(c);
				cowgirlskill1sound.play();
				cooldownKnight1 = 60;
			}
			
		}
		if (KeyEvent.getCode() == KeyCode.E) {
			// for add sound skill fire.play();
			if (cooldownKnight2==0 && knight.isVisible()==true) {
				knight.attack2(c);
				cowgirlskill1sound.play();
				cooldownKnight2 = 60;
			}
		}
		if (KeyEvent.getCode() == KeyCode.N) {
			// for add sound skill fire.play();
			if (cooldownCowgirl1==0 && cowgirl.isVisible()==true) {
				girlShoot();
				cowgirlskill1sound.play();
				cooldownCowgirl1 = 60;
			}
		}
		if (KeyEvent.getCode() == KeyCode.M) {
			// for add sound skill fire.play();
			if (cooldownCowgirl2==0 && cowgirl.isVisible()==true) {
				fire();
				cowgirlskill1sound.play();
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
		}if (KeyEvent.getCode() == KeyCode.ENTER) {
			if (GameWinnerScene.isFinished()) {
				StartWindow startwindow =new StartWindow(primaryStage);
				startwindow.startAnimation();
			}
			if (GameOverScene.isFinished()) {
				StartWindow startwindow = new StartWindow(primaryStage);
				startwindow.startAnimation();
			}
		}if (KeyEvent.getCode() == KeyCode.ESCAPE) {
			if (GameWinnerScene.isFinished()) {
				Platform.exit();
			}
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
		
		//System.out.println("this is update detail");
		//System.out.println("this is frame : "+ f);
		if ((f%600)<500)
			{
				if (f%60 ==0) {
					// maxCountMinion can change is 2
					if (addedBoss==false) {
						addMinion();
					}
				}
			}

		//addBackground();
			int exp2 = RenderableHolder.getinstance().setVisible2();
			int exp = RenderableHolder.getinstance().setVisible();
			isBossDead = RenderableHolder.getinstance().setVisibleBoss();
			
			if(!isBossDead) {
				addedBoss = false;
			}
			
			if (exp!=0) score += 10;
			if (exp2!=0) score += 10;
			RenderableHolder.getinstance().remove();
			RenderableHolder.getinstance().draw(gc);
			
			if (score>=300) value = 1;
			if (score>=600) value = 2;
			
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
			
			isGameEnd();
			haveBoss = RenderableHolder.getinstance().haveBossInList();
			if (alreadyAddBoss1 && addedBoss) {
				
			}
			if (score >= 300 && alreadyAddBoss1==false) {
				addBoss(0);
				alreadyAddBoss1 = true;
				addedBoss = true;
				bggamesound.stop();
				bosssound.play();

			}
			if (score >= 600 && alreadyAddBoss2==false) {
				addBoss(1);
				alreadyAddBoss2 = true;
				addedBoss = true;
				bggamesound.stop();
				bosssound.play();
			}
			if (score >= 900 && alreadyAddBoss3==false) {
				addBoss(2);
				addedBoss = true;
				bggamesound.stop();
				bosssound.play();
			}

			//if (boss1.isVisible()==true && alreadyAddBoss2==false) bosssound.stop();
			//if (checkAllBoss2Dead()==true && alreadyAddBoss3==false) bosssound.stop();


			playerDetail.setCooldownKnight(cooldownKnight1,cooldownKnight2);
			playerDetail.setCooldownCowgirl(cooldownCowgirl1, cooldownCowgirl2);
		
			playerDetail.setScore(score);
			RenderableHolder.getinstance().updatePos(control);
			

	}
	public boolean AllBoss3Dead() {
		boolean result1 = boss31.isDead()&&boss32.isDead();
		boolean result2 = boss33.isDead()&&boss34.isDead();
		boolean result3 = boss35.isDead()&&boss36.isDead();
		boolean result4 = boss37.isDead()&&boss38.isDead();
		
		return result1&&result2&&result3&&result4;
	}
	public boolean AllBoss2Dead() {
		return boss21.isDead()&&boss22.isDead()&&boss23.isDead()&&boss24.isDead();
	}
	
	public void addBoss(int countBoss) {
		if (countBoss==0) {
			boss1 = new Boss1(knight,cowgirl);
			RenderableHolder.getinstance().add(boss1);
		}else if(countBoss==1) {
			boss21 = new Boss2(knight,cowgirl);
			boss22 = new Boss2(knight,cowgirl);
			boss23 = new Boss2(knight,cowgirl);
			boss24 = new Boss2(knight,cowgirl);
			RenderableHolder.getinstance().add(boss21);
			RenderableHolder.getinstance().add(boss22);
			RenderableHolder.getinstance().add(boss23);
			RenderableHolder.getinstance().add(boss24);
		}else if(countBoss==2){
			boss31 = new Boss3(knight,cowgirl);
			boss32 = new Boss3(knight,cowgirl);
			boss33 = new Boss3(knight,cowgirl);
			boss34 = new Boss3(knight,cowgirl);
			boss35 = new Boss3(knight,cowgirl);
			boss36 = new Boss3(knight,cowgirl);
			boss37 = new Boss3(knight,cowgirl);
			boss38 = new Boss3(knight,cowgirl);
			RenderableHolder.getinstance().add(boss31);
			RenderableHolder.getinstance().add(boss32);
			RenderableHolder.getinstance().add(boss33);
			RenderableHolder.getinstance().add(boss34);
			RenderableHolder.getinstance().add(boss35);
			RenderableHolder.getinstance().add(boss36);
			RenderableHolder.getinstance().add(boss37);
			RenderableHolder.getinstance().add(boss38);
			alreadyAddBoss3 = true;
		}else {
			
		}
		
	}
	public void addKnight() {
		knight = new Knight("knight");
		RenderableHolder.getinstance().add(knight);
	}
	public void addcowgirl() {
		cowgirl = new Cowgirls();
		RenderableHolder.getinstance().add(cowgirl);
	}
	public void addMinion() {
		//add more minion
		if (value==0) {
			minion1 = new Minion1(knight,cowgirl);
			RenderableHolder.getinstance().add(minion1);
		}
		if (value==1) {
			minion2 = new Minion2(knight,cowgirl);
			RenderableHolder.getinstance().add(minion2);
			bosssound.stop();

		}
		if (value==2) {
			minion3 = new Minion3(knight,cowgirl);;
			RenderableHolder.getinstance().add(minion3);
			if (alreadyAddBoss3==false) bosssound.stop();
		}
	}
	public void addAll() {
	addPlayerDetail();
	addKnight();
	addcowgirl();
	addMinion();
	
	}
	public void addPlayerDetail() {
		playerDetail = new PlayerDetail();
		RenderableHolder.getinstance().add(playerDetail);
	}
	public void isGameEnd() {
		//if (knight.getHp()==0 && cowgirl.getHp()==0)
		if (knight.getHp()==0 && cowgirl.getHp()==0) {
			RenderableHolder.getinstance().clearList();
			gamewindowanimation.stop();
			bggamesound.stop();
			bosssound.stop();
			soundbg.play();
			GameOverScene.setScore(score);
			GameOverScene.startAnimation(gc);
		}
		// instance alreadyAddAllBoss with true
		//alreadyAddAllBoss
		if (alreadyAddBoss3 && AllBoss3Dead()) {
			RenderableHolder.getinstance().clearList();
			gamewindowanimation.stop();
			bggamesound.stop();
			bosssound.stop();
			soundbg.play();
			GameWinnerScene.setScore(score);
			GameWinnerScene.startAnimation(gc);
		}
	}
	//add getLevel in cowgirl and set attack in knight and cowgirl
	public void setState() {
		if (knight.getLevel()+cowgirl.getLevel()<5) {
			knight.setSpeed(1);
			cowgirl.setSpeed(1);
		}
		if (knight.getLevel()+cowgirl.getLevel()<10) {
			knight.setSpeed(2);
			cowgirl.setSpeed(3);
		}
		if (knight.getLevel()+cowgirl.getLevel()<15) {
			knight.setSpeed(3);
			cowgirl.setSpeed(3);
		}
		if (knight.getLevel()+cowgirl.getLevel()<20) {
			knight.setSpeed(4);
			cowgirl.setSpeed(4);
		}
	}
	// add updateState for rander window
	// add background stage
	public void girlShoot() {
		cowgirl.attack('h',20,20);
		cowgirl.attack('j',20,20);
		cowgirl.attack('u',20,20);
		cowgirl.attack('k',20,20);
		
	}
	public void playSong() {
		bggamesound.play();
	}
	public void updateSong() {
		if (bggamesound.isPlaying()==false && bosssound.isPlaying() ==false) playSong();
		
	}

}