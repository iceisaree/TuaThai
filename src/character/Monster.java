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
	protected List<Image> left = new ArrayList<>();
	protected List<Image> up = new ArrayList<>();
	protected List<Image> down = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	private Character character;
	ClassLoader loader = ClassLoader.getSystemClassLoader();
	public Image monsterPic = new Image("zombiefemale_Up (1).png",90,90,false,false);
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	protected Random rand = new Random();
	protected Knight knight;
	public Monster(double hp, double damage, String name,Knight knight) {
		
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
			x = 100;
		case 2:
			y = (double) rand.nextInt(500)+60;
			x = 200;
		case 3:
			y = (double) rand.nextInt(500)+60;
			x = 300;
		case 4:
			y = (double) rand.nextInt(500)+60;
			x = 450;
		case 5:
			y = (double) rand.nextInt(500)+60;
			x = 400;
		case 6:
			y = (double) rand.nextInt(500)+60;
			x = 350;			
		case 7:
			y = (double) rand.nextInt(500)+60;
			x = 250;
		case 8:
			y = (double) rand.nextInt(500)+60;
			x = 150;
			
		}
		setImage();
		x = 0;y =0;
		setX(x);
		setY(y);
		this.knight = knight;
		
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
		//monsterPic = new Image("zombiefemale_Up (1).png");
		gc.drawImage(monsterPic, x, y);
	}
	public void setImage() {
		
	}
	
	public void hit(Character o) {
		this.setHP(this.getHP()-o.getAttack());	
	}
	public void takedDamage(double damage) {
		if (damage<=0) return;
		HP -= (damage);
		if (HP<=0) this.isVisible = true;
	}
	public double getExp() {
		return exp;
	}
	public double getSpeed() {
		return speed;
	}
	public void updatePos() {
		System.out.println("This is in updatePos");
		x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
		y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
		x += getSpeed();
		y += getSpeed();
		boolean isCharacterAttacked;
		isCharacterAttacked = knight.attackPos((int) x,(int)y);
		// change HP minus for change damage
		//if (isCharacterAttacked) takedDamage(character.getAttack());
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
	public void setVisible(boolean visible) {
		this.isVisible = visible;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
