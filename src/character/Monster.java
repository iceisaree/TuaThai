package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;
import character.Knight;

public class Monster extends Entity{
	protected double HP;
	protected double Damage;
	protected String Name;
	protected double speed;
	protected boolean isVisible = true;
	private List<Image> left = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private Character character;
	protected Image monsterPic;
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	protected Random rand = new Random();
	protected Knight knight;
	public Monster(double hp, double damage, String name) {
		super(0,0);
		this.HP=hp;
		this.Damage=damage;
		this.Name=name;
		this.isDead=false;
		this.MaxHP = hp;
		this.exp = 100;
		int way = rand.nextInt(8)+1;
		// set sponde monster different pos
		//case 1-4 for fix x
		//case 5-8 for fix y 
		//----- HAVE To fix number ------
		switch(way) {
		case 1:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 2:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 3:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 4:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 5:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 6:
			y = (double) rand.nextInt(500)+60;
			x = 40;			
		case 7:
			y = (double) rand.nextInt(500)+60;
			x = 40;
		case 8:
			y = (double) rand.nextInt(500)+60;
			x = 40;
			
		}
		setImage();
		setX(x);
		setY(y);
		
	}
	
	public boolean getStatus() {
		return this.isDead;
	}

	public void setStatus(boolean ddd) {
		this.isDead=ddd;
	}
	public double getHP() {
		return this.HP;
	}

	public void setHP(double hP) {
		if(hP <=0) {
			this.HP = 0;
			this.setStatus(true);
		}else this.HP=hP;
	}

	public double getDamage() {
		return this.Damage;
	}

	public void setDamage(double damage) {
		this.Damage = damage;
	}

	public String getName() {
		return Name;
	}
	public void attack(Character other) {
		other.takedDamage(this.Damage);
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(monsterPic, x, y);
	}
	public void setImage() {
		monsterPic = down.get(0);
	}
	
	public void hit(Character o) {
		this.setHP(this.getHP()-o.getAttack());	
	}
	public void takedDamage(double damage) {
		if (damage<=0) return;
		HP -= (damage);
		if (HP<=0) this.isDead = true;
	}
	public double getExp() {
		return exp;
	}
	public double getSpeed() {
		return speed;
	}
	public void updatePos() {
		x += getSpeed()*knight.getLevel();
		y += getSpeed()*knight.getLevel();
		if (HP==0) isVisible = false;
	}
	public double calculateSin(double charX,double charY) {
		double c = charX - this.x;
		double k = charY - this.y;
		double cha = Math.sqrt((k*k)+(c*c));
		double sin = k/cha;
		return sin;
	}
	public double calculateCos(double charX,double charY) {
		double c = charX - this.x;
		double k = charY - this.y;
		double cha = Math.sqrt((k*k)+(c*c));
		double cos = c/cha;
		return cos;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
