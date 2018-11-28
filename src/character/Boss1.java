package character;

import javafx.scene.image.Image;

public class Boss1 extends Monster {

	public Boss1(double hp, double attack, String name) {
		super(hp, attack, name);
		// TODO Auto-generated constructor stub
		for (int i=1; i<4; i++) {
			left.add(new Image("dino_left"+i+".png"));
			right.add(new Image("dino_right"+i+".png"));
			down.add(new Image("dino_down"+i+".png"));
			up.add(new Image("dino_up"+i+".png"));
		}
	}
	public Boss1() {
		super(150,80,"Dinooo");
		for (int i=1; i<4; i++) {
			left.add(new Image("dino_left"+i+".png"));
			right.add(new Image("dino_right"+i+".png"));
			down.add(new Image("dino_down"+i+".png"));
			up.add(new Image("dino_up"+i+".png"));
		}
	}
	//****************status not available at this time pls call again later**************************
	/*@Override
	public void special() {
		if (this.getHP()<= this.MaxHP/2) {
			this.setDamage(this.Damage*02);
		}
	}*/
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
