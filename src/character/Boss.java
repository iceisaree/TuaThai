package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;
import character.Knight;

public abstract class Boss extends Entity{
	protected double HP = 100;
	protected double Damage;
	protected double speed;
	protected boolean isVisible = true;
	protected List<Image> left = new ArrayList<>();
	protected List<Image> up = new ArrayList<>();
	protected List<Image> down = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	ClassLoader loader = ClassLoader.getSystemClassLoader();
	public Image monsterPic;
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	protected Random rand = new Random();
	protected Knight knight;
	protected Cowgirls cowgirl;

	public Boss(double hp, Knight knight,Cowgirls cowgirl) {
		
		super(0,0);
		this.HP=100;
		this.isDead=false;
		this.MaxHP = hp;
		this.exp = 100;
		this.speed=1;
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
		//setImage();
		
		setX(x);
		setY(y);
		this.knight = knight;
		this.cowgirl = cowgirl;
		
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

	public void setHP(double HP) {
		if(HP <=0) {
			this.HP = 0;
			this.setStatus(true);
		}else this.HP=HP;
	}
	
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if ((knight.isVisible()==true)&&(this.x <= knight.getX()+20 && knight.getX()-20 <= this.x) && (this.y <= knight.getY()+10 && knight.getY()-10 <= this.y)) {
			//setChangeHp
			knight.setHP(knight.getHp()-1);
			System.out.println("This is HP Boss : " + HP);
			if (isDead) return false;
			return true;
		}
		
		if ((cowgirl.isVisible()==true)&&(this.x <= cowgirl.getX()+20 && cowgirl.getX()-20 <= this.x) && (this.y <= cowgirl.getY()+10 && cowgirl.getY()-10 <= this.y)) {
			//set change HP
			cowgirl.setHP(cowgirl.getHp()-1);
			System.out.println("This is HP Boss : " + HP);
			if (isDead) return false;
			return true;
		}
		
		return isVisible;
	}

	
	@Override
	public void draw(GraphicsContext gc) {
		//monsterPic = new Image("zombiefemale_Up (1).png");
		//System.out.println("monster in draw");
		gc.drawImage(monsterPic, x, y);
	}
	public void setImage() {
		
	}
	//didn't use
	/*public void takedDamage(double damage) {
||||||| merged common ancestors
	public void attack(Character other) {
		other.takedDamage(this.Damage);
	}
	@Override
	public void draw(GraphicsContext gc) {
		//monsterPic = new Image("zombiefemale_Up (1).png");
		//System.out.println("monster in draw");
		gc.drawImage(monsterPic, x, y);
	}
	public void setImage() {
		
	}
	
	public void takedDamage(double damage) {
=======
	public void attack(Character other) {
		other.takedDamage(this.Damage);
	}
	public void takedDamage(double damage) {
>>>>>>> 6049b6da91600e94da1d26f8e6524ea198ff71cf
		if ((this.x < knight.getX()+10 && knight.getX()-10 < this.x) && (this.y < knight.getY()+10 && knight.getY()-10 < this.y)) {
			this.isVisible = false;
			if (damage<=0) return;
			HP -= damage;
		}
		if ((this.x < cowgirl.getX()+10 && cowgirl.getX()-10 < this.x) && (this.y < cowgirl.getY()+10 && cowgirl.getY()-10 < this.y)) {
			this.isVisible = false;
			if (damage<=0) return;
			HP -= damage;
		}
		if (HP<=0) this.isVisible = false;
	}*/
	public double getExp() {
		return exp;
	}
	public double getSpeed() {
		return speed;
	}
	public void updatePos() {
/*
		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos Monster");
		//System.out.println(getSpeed()+" "+knight.getX()+" "+knight.getY());
		x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
		y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
		//System.out.println(getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY())+" "+y+"aaaaaaaaaaa");
		//x += getSpeed();
		//y += getSpeed();
		boolean isKnightAttacked,isCowgirlAttacked;
		isKnightAttacked = knight.attackPos((int) x,(int)y);
		isCowgirlAttacked = cowgirl.attackPos((int) x,(int)y);
		// change HP minus for change damage
<<<<<<< HEAD
	
		System.out.println("this is HP knight : "+knight.getHP());
		
		System.out.println("This is HP cowgirl : "+cowgirl.getHP());
||||||| merged common ancestors
		//if (isCharacterAttacked) takedDamage(character.getAttack());
=======
		//if (isCharacterAttacked) takedDamage(character.getAttack());*/
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
	// add for boss
	public boolean isDead() {
		if (HP<=0) return true;
		else return false;
	}
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+20 && x-20 < this.x) && (this.y < y+20 && y-20 < this.y)) {
			if (isDead()) return true;
			return true;
		}
		return false;
	}
	public void decreaseBossHp(int damage) {
		HP -= damage;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
}
