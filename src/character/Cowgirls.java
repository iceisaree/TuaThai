package character;
public class Cowgirls extends Character{

	public Cowgirls(){
	super(100,150,50,20,"cowGirls","cowGirls",1);
	}
	public Cowgirls(double HP,double mana,double armor,double attack,String name,String classCh,int Level) {
		super(HP,mana,armor,attack,name,classCh,Level);
	}
	
	public boolean isCanAttack() {
		return true;
	}
	
	public boolean LevelUp() {
		if (super.canLevelUp()) {
			super.setLevelup();
			return true;
		}else {
			return false;
		}
	}
	
	
}
