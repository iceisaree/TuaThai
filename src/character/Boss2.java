package character;

import javafx.scene.image.Image;

public class Boss2 extends Monster {

	public Boss2(double hp, int attack, String name) {
		super(hp, attack, name);
		for (int i=1; i<4; i++) {
			left.add(new Image("pumpkin_left"+i+".png"));
			right.add(new Image("pumpkin_right"+i+".png"));
			down.add(new Image("pumpkin_down"+i+".png"));
			up.add(new Image("pumpkin_up"+i+".png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Boss2() {
		super(400,200,"Pumpkin");
		for (int i=1; i<4; i++) {
			left.add(new Image("pumpkin_left"+i+".png"));
			right.add(new Image("pumpkin_right"+i+".png"));
			down.add(new Image("pumpkin_down"+i+".png"));
			up.add(new Image("pumpkin_up"+i+".png"));
		}
	}
	/*@Override
	public void special() {
		
	}*/
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
