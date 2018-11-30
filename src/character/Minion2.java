package character;

import javafx.scene.image.Image;

public class Minion2 extends Monster {
	public Image zombiePic;
	
	
	public Minion2(double hp, int attack,Knight knight) {
		super(100, 20, knight);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png"));
			right.add(new Image("zombiemale_Right ("+i+").png"));
			down.add(new Image("zombiemale_Up ("+i+").png"));
			up.add(new Image("zombiemale_Up ("+i+").png"));
		}
		setZombie();
		// TODO Auto-generated constructor stub
	}
	public Minion2(Knight knight) {
		super(100,20,knight);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png"));
			right.add(new Image("zombiemale_Right ("+i+").png"));
			down.add(new Image("zombiemale_Up ("+i+").png"));
			up.add(new Image("zombiemale_Up ("+i+").png"));
		}
		setZombie();
	}
	
	
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if ((this.x <= knight.getX()+20 && knight.getX()-20 <= this.x) && (this.y <= knight.getY()+10 && knight.getY()-10 <= this.y)) {
			return false;
		}
		
		return true;
	}
	public void setZombie() {
		zombiePic = left.get(0);
	}
	/*public void updatePos() {
		if(x>=35) {
			x-=speed;
			knightPic = left.get(timeOfPics/10);
		}
		if (control.contains("s")) if (y+90<=600) {
			y+=speed;
			knightPic = up.get(timeOfPics/10);
		}
		if (control.contains("w")) if(y>=0) {
			y-=speed;
			knightPic = down.get(timeOfPics/10);
		}
		if (control.contains("d")) if (x+90<=950) {
			x+=speed;
			knightPic = right.get(timeOfPics/10);
		}
	}*/
}
