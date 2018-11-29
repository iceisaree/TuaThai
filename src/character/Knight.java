package character;

import java.util.ArrayList;
import java.util.List;
import share.Entity;
import share.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
//change data in character and Knight
public class Knight extends Character {
	
	private int speed = 4;
	private static double Hp;
	private double mana;
	private double armor;
	private double attack;
	private int Level;
	private int timeOfPics = 0;
	public Image knightPic = new Image("desert.png");
	private String control;
	
	private String name,classCh;
	public Knight(String name){
		super(true,100,50,100,20,name,1);
		for (int i=1;i<5;i++) {
			left.add(new Image("left_("+i+").png",55,65,false,false));
			up.add(new Image("up_("+i+").png",55,65,false,false));
			down.add(new Image("down_("+i+").png",55,65,false,false));
			right.add(new Image("right_("+i+").png",55,65,false,false));
		}
		setKnight();
		}
	// fix in form Character
	public Knight(double HP,double mana,double armor,double attack,String name,int Level) {
			super(true,HP,mana,armor,attack,name,Level);
			for (int i=1;i<5;i++) {
				left.add(new Image("left_"+i+".png",55,65,false,false));
				up.add(new Image("up_"+i+".png",55,65,false,false));
				down.add(new Image("down_"+i+".png",55,65,false,false));
				right.add(new Image("right_"+i+".png",55,65,false,false));
			}
			setKnight();
		}
	public void setKnight() {
		
	}
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(knightPic, x, y);
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
	public void setControl(String control) {
		this.control = control;
	}
	public static double getHp() {return Hp;}
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
	public double getMana() {
		return mana;
	}
	public void setMana(double mana) {
		this.mana = mana;
	}
	public double getArmor() {
		return armor;
	}
	public void setArmor(double armor) {
		this.armor = armor;
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
	public String getClassCh() {
		return classCh;
	}
	public void setClassCh(String classCh) {
		this.classCh = classCh;
	}
	public String getControl() {
		return control;
	}
	public void setHp(double hp) {
		Hp = hp;
	}
	
	
}
