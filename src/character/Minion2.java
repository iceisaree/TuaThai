package character;

import javafx.scene.image.Image;

public class Minion2 extends Monster {
	public Minion2(double hp, int attack, String name,Knight knight) {
		super(hp, attack, name,knight);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png"));
			right.add(new Image("zombiemale_Right ("+i+").png"));
			down.add(new Image("zombiemale_Up ("+i+").png"));
			up.add(new Image("zombiemale_Up ("+i+").png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Minion2(Knight knight) {
		super(160,100,"Zombieee",knight);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png"));
			right.add(new Image("zombiemale_Right ("+i+").png"));
			down.add(new Image("zombiemale_Up ("+i+").png"));
			up.add(new Image("zombiemale_Up ("+i+").png"));
		}
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
