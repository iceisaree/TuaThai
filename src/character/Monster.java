package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;
import character.Knight;

public abstract class Monster extends Entity{
	protected double HP;
	protected double Damage;
	protected double speed;
	protected boolean isVisible = true;
	ClassLoader loader = ClassLoader.getSystemClassLoader();
	public Image monsterPic = new Image("zombiefemale_Up (1).png",90,90,false,false);
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	protected Random rand = new Random();
	protected Knight knight;
	protected Cowgirls cowgirl;

	public Monster(double hp, double damage, Knight knight,Cowgirls cowgirl) {
		
		super(0,0);
		this.HP=hp;
		this.Damage=damage;
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

	public double getDamage() {
		return this.Damage;
	}

	public void setDamage(double damage) {
		this.Damage = damage;
	}


	
	@Override
	public void draw(GraphicsContext gc) {
		//monsterPic = new Image("zombiefemale_Up (1).png");
		//System.out.println("monster in draw");
		gc.drawImage(monsterPic, x, y);
	}
	public void setImage() {
		
	}
	
	public double getExp() {
		return exp;
	}
	public double getSpeed() {
		return speed;
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
	public boolean isDestroyed(double x,double y) {
		if ((this.x < x+20 && x-20 < this.x) && (this.y < y+20 && y-20 < this.y)) {
			isVisible = false;
			return true;
		}
		return false;
	}
	@Override
	public boolean isVisible() {
		
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
}
