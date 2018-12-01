package character;

import java.util.ArrayList;
import java.util.List;
import share.Entity;
import share.IRenderable;
import share.RenderableHolder;
import skill.CowgirlSkill1;
import skill.CowgirlSkill2;
import skill.KnightSkill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
//change data in character and Knight
public class Cowgirls extends Entity implements IRenderable {
	
	public Cowgirls(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int [] indexExp = {10,50,200,800,3200,3200,3400,3800,4000,4200,3000,2000,1000,500,200};
	
	private int speed = 4;
	private int Hp;
	private double mana;
	private int skill1Count;
	private int maxLevel;
	private double armor;
	private double attack;
	private int exp;
	private int Level;
	private int timeOfPics = 0;
	public Image CowgirlPic;
	private String control;
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	
	private String name;
	public Cowgirls(String name){
		super(0,0);
		for (int i=1;i<5;i++) {
			left.add(new Image("cowgirl_Right ("+i+").png",100,80, false, false));
			up.add(new Image("cowgirl_up ("+i+").png",70,80,false,false));
			down.add(new Image("cowgirl_up ("+i+").png",70,80,false,false));
			right.add(new Image("cowgirl_Right ("+i+").png",70,80,false,false));
		}
		setKnight();
		}
	public void setKnight() {
		CowgirlPic = right.get(0);
	}
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		//System.out.println("This is in knight draw");
		gc.drawImage(CowgirlPic, x, y);
	}
	public void updatePos() {
		if (control.contains("h")) if(x>=35) {
			x-=speed;
			CowgirlPic = left.get(timeOfPics/10);
		}
		if (control.contains("j")) if (y+90<=600) {
			y+=speed;
			CowgirlPic = up.get(timeOfPics/10);
		}
		if (control.contains("u")) if(y>=0) {
			y-=speed;
			CowgirlPic = down.get(timeOfPics/10);
		}
		if (control.contains("k")) if (x+90<=950) {
			x+=speed;
			CowgirlPic = right.get(timeOfPics/10);
		}
	}

	public CowgirlSkill1 attack(char c,int addX,int addY) {
		CowgirlSkill1 cowgirlSkill1 = new CowgirlSkill1(x,y,c,addX,addY);
		RenderableHolder.getinstance().add(cowgirlSkill1);
		cowgirlSkill1.setCowgirlSkill1();
		return cowgirlSkill1;
	}
	public int getExp() {
		return this.exp;
	}
	public int getSkill1Count() {
		return skill1Count;
	}
	public void setSkill1Count(int skill1Count) {
		this.skill1Count = skill1Count;
	}
	public int getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public int getMaxExp() {
		return indexExp[Level];
	}
	
	public int getMaxHp() {
		
		return (Level*50)+50;
	}
	
	public CowgirlSkill2 attack2(char c) {
		CowgirlSkill2 cowgirlSkill2 = new CowgirlSkill2(x,y,c);
		RenderableHolder.getinstance().add(cowgirlSkill2);
		cowgirlSkill2.setCowgirlSkill2();
		return cowgirlSkill2;
	}
	public boolean isVisible() {
		return true;
	}
	public void setControl(String control) {
		this.control = control;
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
	public Image getCowgirlPic() {
		return CowgirlPic;
	}
	public void setCowgirlPic(Image CowgirlPic) {
		this.CowgirlPic = CowgirlPic;
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
public boolean attackPos(int xIn,int yIn) {
		
		// 10 have to change by charcter pic 
		if (Math.abs(this.x-xIn)<=10 && Math.abs(this.y-yIn)<=100) {
			Hp--;
			return true;
		}else return false;
	}
	
	
}
