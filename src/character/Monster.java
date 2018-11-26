package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;
import character.Knight;

public abstract class Monster extends Entity{
	protected double HP;
	protected double Damage;
	protected String Name;
	protected double speed;
	protected boolean isVisible = true;
	private List<Image> left = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	protected Image monsterPic;
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	protected Knight knight;
	public Monster(double hp, double damage, String name) {
		super(0,0);
		this.HP=hp;
		this.Damage=damage;
		this.Name=name;
		this.isDead=false;
		this.MaxHP = hp;
		this.exp = 100;
	}
	public abstract void special();
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
	
}
