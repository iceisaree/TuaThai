package character;

import javafx.scene.image.Image;

public class Minion3 extends Monster {
	public Minion3(double hp, int attack, String name,Knight knight) {
		super(hp, attack,knight);
		for (int i=1; i<4; i++) {
			left.add(new Image("cowboy_left"+i+".png"));
			right.add(new Image("cowboy_right"+i+".png"));
			down.add(new Image("cowboy_down"+i+".png"));
			up.add(new Image("cowboy_up"+i+".png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Minion3(Knight knight) {
		super(400,150,knight);
		for (int i=1; i<4; i++) {
			left.add(new Image("cowboy_left"+i+".png"));
			right.add(new Image("cowboy_right"+i+".png"));
			down.add(new Image("cowboy_down"+i+".png"));
			up.add(new Image("cowboy_up"+i+".png"));
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
