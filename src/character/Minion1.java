package character;

import javafx.scene.image.Image;

public class Minion1 extends Monster {
	
	public Minion1(double hp, int attack, String name,Knight knight) {
		super(hp, attack, name,knight);
		for (int i=1; i<4; i++) {
			left.add(new Image("ninja_left"+i+".png"));
			right.add(new Image("ninja_right"+i+".png"));
			down.add(new Image("ninja_down"+i+".png"));
			up.add(new Image("ninja_up"+i+".png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Minion1(Knight knight) {
		super(75,25,"Ninja",knight);
		for (int i=1; i<4; i++) {
			left.add(new Image("ninja_left"+i+".png"));
			right.add(new Image("ninja_right"+i+".png"));
			down.add(new Image("ninja_down"+i+".png"));
			up.add(new Image("ninja_up"+i+".png"));
		}
	}
	public void special() {
		
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
