package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;

public class Character extends Entity implements IRenderable{
	protected int HP;
	protected int exp;
	protected int damage;
	protected int [] indexExp = {10,50,200,800,3200,3200,3400,3800,4000,4200,3000,2000,1000,500,200};
	protected boolean isKnight = false;
	protected String name;
	protected int Level=1;
	protected boolean isDead=false;
	protected int speed = 1;
	public Character() {
		super(100,100);
		this.exp = 0;
		
	}
	public void setSkill(String skillName,double damage,double manaUse,double cooldown) {
		
	}
	//fix takedDamage
	
	public boolean attackPos(int xIn,int yIn) {
		
		// 10 have to change by charcter pic 
		if (Math.abs(this.x-xIn)<=10 && Math.abs(this.y-yIn)<=100) {
			//HP -= 10;
			return true;
		}else return false;
	}
		
	public void setLevelup() {
		Level++;
	}
	
	public double getHP() {
		return HP;
	}
	public void setHP(int hp) {
		HP = hp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
		// add Skill show
		
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void updatePos() {
		// TODO Auto-generated method stub
		
	}
}
	

