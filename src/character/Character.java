package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;

public class Character extends Entity implements IRenderable{
	protected double HP,mana,armor,max_HP,max_MANA,max_ARMOR,damage,exp,max_this_level_up;
	protected int [] indexExp = {10,50,200,800,3200,3200,3400,3800,4000,4200,3000,2000,1000,500,200};
	protected boolean isKnight = false;
	protected String name,classCh;
	protected int Level;
	protected boolean isDead;
	protected double speed = 0;
	public Image characterPic;
	private String control;
	private int timeOfPic;
	protected List<Image> left = new ArrayList<>();
	protected List<Image> up = new ArrayList<>();
	protected List<Image> down = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	
	public Character(boolean isKngiht,double HP,double mana,double armor,double damage,String name,String classCh,int Level) {
		super(0,0);
		this.isKnight = isKnight;
		this.HP = HP;
		this.mana = mana;
		this.armor = armor;
		this.damage = damage;
		this.name = name;
		this.classCh = classCh;
		this.Level = Level;
		this.isDead = false;
		this.exp = 0;
	}
	public void setSkill(String skillName,double damage,double manaUse,double cooldown) {
		
	}
	//fix takedDamage
	public void takedDamage(double damage) {
		if ((damage-armor)<0) return;
		HP -= (damage-armor);
		if (HP<=0) this.isDead = true;
	}
	public void attackPos(int x,int y) {
		
	}
	public void attackMonster(Monster other) {
		if (!other.isDead) {
			other.takedDamage(damage);
			if (other.isDead) exp += other.getExp();
			
		}
	}
	public void setLevelup() {
		Level++;
	}
	public boolean canLevelUp() {
		if (exp>=max_this_level_up) {
			exp = exp - max_this_level_up;
			setLevelup();
			max_this_level_up = indexExp[Level];
			return true;
		}else {
			return false;
		}
	}
	
	
	
	public double getAttack() {
		return damage;
	}
	public void setAttack(double attack) {
		this.damage = attack;
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double hp) {
		HP = hp;
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
	public double getMAX_HP() {
		return max_HP;
	}
	public void setMAX_HP(double max_HP) {
		this.max_HP = max_HP;
	}
	public double getMAX_MANA() {
		return max_MANA;
	}
	public void setMAX_MANA(double max_MANA) {
		this.max_MANA = max_MANA;
	}
	public double getMAX_ARMOR() {
		return max_ARMOR;
	}
	public void setMAX_ARMOR(double max_ARMOR) {
		this.max_ARMOR = max_ARMOR;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		timeOfPic++;
		gc.drawImage(characterPic, 400, 400);
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
		if (!isKnight) {
			if (control.contains("h")) {
				if (x>=0) {
					x -= speed;
					characterPic = left.get(timeOfPic/10);
				}
			if (control.contains("k")){
				if (x+50<=950) {
					x += speed;
					characterPic = right.get(timeOfPic/10);
				}
			}
			if (control.contains("u")) {
				if (y-60>=0) {
					y -= speed;
					characterPic  = up.get(timeOfPic/10);
				}
			}
			if (control.contains("j")) {
				if (y+90<=550) {
					y += speed;
					characterPic = down.get(timeOfPic/10);
				}
			}
			
		}else {
			if (control.contains("a")) {
				if (x>=0) {
					x -= speed;
					characterPic = left.get(timeOfPic/10);
				}
			if (control.contains("d")){
				if (x+50<=950) {
					x += speed;
					characterPic = right.get(timeOfPic/10);
				}
			}
			if (control.contains("w")) {
				if (y-60>=0) {
					y -= speed;
					characterPic  = up.get(timeOfPic/10);
				}
			}
			if (control.contains("s")) {
				if (y+90<=550) {
					y += speed;
					characterPic = down.get(timeOfPic/10);
				}
			}
			}
		}
	}
	
	
	
	
	
}
