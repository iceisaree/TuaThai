package character;
public class Minion3 extends Monster {
	public Minion3(double hp, int attack, String name) {
		super(hp, attack, name);
		// TODO Auto-generated constructor stub
	}
	public Minion3() {
		super(400,150,"CowBoy");
	}
	@Override
	public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
