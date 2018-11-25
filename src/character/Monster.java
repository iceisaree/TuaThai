package character;
public abstract class Monster {
	protected double HP;
	protected double Damage;
	protected String Name;
	protected boolean isDead;
	protected double MaxHP;
	protected double exp;
	public Monster(double hp, double damage, String name) {
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
	
}
