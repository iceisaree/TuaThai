package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import share.Entity;
import share.IRenderable;
import share.RenderableHolder;
import skill.KnightSkill;


//change data in character and Knight
public class Knight extends Entity implements IRenderable {
	private int max_Exp;
	private int speed = 4;
	private int Hp=100;
	private double attack;
	private int Level=1;
	private int timeOfPics = 0;
	public Image knightPic = new Image("desert.png");
	private String control;
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private int exp;
	private int [] indexExp = {10,20,30,40,50,60,70,80,90,100,2000,3000,4000,5000,60000};
	private String name;
	public Knight(String name){
		super(0,0);
		for (int i=1;i<5;i++) {
			left.add(new Image("knight_Right ("+i+").png",70,80, false, false));
			up.add(new Image("knight_up ("+i+").png",70,80,false,false));
			down.add(new Image("knight_up ("+i+").png",70,80,false,false));
			right.add(new Image("knight_Right ("+i+").png",70,80,false,false));
		}
		setKnight();
		}
	public void setKnight() {
		knightPic = right.get(0);
	}
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		//System.out.println("This is in knight draw");
		gc.drawImage(knightPic, x, y);
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getMaxExp() {
		return indexExp[Level];
	}
	public void setMaxExp(int maxExp) {
		this.max_Exp = maxExp;
	}
	public void updatePos() {
		if (control.contains("a")) if(x>=35) {
			x-=speed;
			knightPic = left.get(timeOfPics/10);
		}
		if (control.contains("s")) if (y+90<=600) {
			y+=speed;
			knightPic = up.get(timeOfPics/10);
		}
		if (control.contains("w")) if(y>=0) {
			y-=speed;
			knightPic = down.get(timeOfPics/10);
		}
		if (control.contains("d")) if (x+90<=950) {
			x+=speed;
			knightPic = right.get(timeOfPics/10);
		}
	}
	public boolean isVisible() {
		return true;
	}
	public KnightSkill attack(char c) {
		KnightSkill knightSkill1 = new KnightSkill(x,y,c,0);
		RenderableHolder.getinstance().add(knightSkill1);
		knightSkill1.setKnightSkill();
		return knightSkill1;
	}
	public KnightSkill attack2(char c) {
		KnightSkill knightSkill2 = new KnightSkill(x,y,c,1);
		RenderableHolder.getinstance().add(knightSkill2);
		knightSkill2.setKnightSkill2();
		return knightSkill2;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public void updateLevel() {
		if (Level>indexExp.length) return;
		if (exp>=indexExp[Level]) {
			Level++;
			exp=0;
		}
	}
	public int getHp() {
		return Hp;}
	public List<Image> getLeft() {
		return left;
	}
	public void setLeft(List<Image> left) {
		this.left = left;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getAttack() {
		return attack;
	}
	public void setAttack(double attack) {
		this.attack = attack;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public int getTimeOfPics() {
		return timeOfPics;
	}
	public void setTimeOfPics(int timeOfPics) {
		this.timeOfPics = timeOfPics;
	}
	public Image getKnightPic() {
		return knightPic;
	}
	public void setKnightPic(Image knightPic) {
		this.knightPic = knightPic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getControl() {
		return control;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public int getMaxHp() {
		return 150+(Level*50);
	}
	public boolean attackPos(int xIn,int yIn) {
		
		// 10 have to change by charcter pic 
		if (Math.abs(this.x-xIn)<=10 && Math.abs(this.y-yIn)<=100) {
			Hp--;
			return true;
		}else return false;
	}
	
	
}
