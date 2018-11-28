package character;

import javafx.scene.image.Image;

public class Minion2 extends Monster {
	public Minion2(double hp, int attack, String name) {
		super(hp, attack, name);
		for (int i=1; i<4; i++) {
			left.add(new Image("zombie_left"+i+".png"));
			right.add(new Image("zombie_right"+i+".png"));
			down.add(new Image("zombie_down"+i+".png"));
			up.add(new Image("zombue_up"+i+".png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Minion2() {
		super(160,100,"Zombieee");
		for (int i=1; i<4; i++) {
			left.add(new Image("zombie_left"+i+".png"));
			right.add(new Image("zombie_right"+i+".png"));
			down.add(new Image("zombie_down"+i+".png"));
			up.add(new Image("zombue_up"+i+".png"));
		}
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
