package character;
public class Character{
	protected double HP,mana,armor,max_HP,max_MANA,max_ARMOR,damage,exp,max_this_level_up;
	protected int [] indexExp = {10,50,200,800,3200,3200,3400,3800,4000,4200,3000,2000,1000,500,200};

	protected String name,classCh;
	protected int Level;
	protected boolean isDead;
	public Character(double HP,double mana,double armor,double damage,String name,String classCh,int Level) {
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
	public void takedDamage(double damage) {
		if ((damage-armor)<0) return;
		HP -= (damage-armor);
		if (HP<=0) this.isDead = true;
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
	
	
	
	
	
}
