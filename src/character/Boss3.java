package character;

import javafx.scene.image.Image;

public class Boss3 extends Monster {

	public Boss3(double hp, int attack, String name) {
		super(hp, attack, name);
		for (int i=1;i<4;i++) {
			left.add(new Image("robot_left"+i+".png"));
			right.add(new Image("robot_right"+i+".png"));
			down.add(new Image("robot_down"+i+".png"));
			up.add(new Image("robot_up"+i+".png"));
		}
		// TODO Auto-generated constructor stub
	}
	public Boss3() {
		super(900,350,"ROBOT");
		for (int i=1;i<4;i++) {
		left.add(new Image("robot_left"+i+".png"));
		right.add(new Image("robot_right"+i+".png"));
		down.add(new Image("robot_down"+i+".png"));
		up.add(new Image("robot_up"+i+".png"));
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
