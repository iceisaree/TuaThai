package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Minion3 extends Monster {
	public Image cowboyPic;
	int k = rand.nextInt(2);
	protected List<Image> left = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	private int timeOfPics = 0;
	
	
	public Minion3(Knight knight,Cowgirls cowgirl) {
		super(100,20,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<7; i++) {
			left.add(new Image("cowboy_left ("+i+").png",70,80,false,false));
			right.add(new Image("cowboy_right ("+i+").png",70,80,false,false));
		}
		super.speed = 1;
		setCowboy();
	}
	
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(cowboyPic, x, y);
	}
	@Override
	/*public void special() {
	 
	}
	@Override*/
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if ((knight.isVisible()==true)&&(this.x <= knight.getX()+20 && knight.getX()-20 <= this.x) && (this.y <= knight.getY()+10 && knight.getY()-10 <= this.y)) {
			//setChangeHp
			knight.setHP(knight.getHp()-10);
			isVisible = false;
			return false;
		}
		
		if ((cowgirl.isVisible()==true)&&(this.x <= cowgirl.getX()+20 && cowgirl.getX()-20 <= this.x) && (this.y <= cowgirl.getY()+10 && cowgirl.getY()-10 <= this.y)) {
			//set change HP
			cowgirl.setHP(cowgirl.getHp()-10);
			isVisible = false;
			return false;
		}
		
		return super.isVisible;
	}
	

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setCowboy() {
		cowboyPic = right.get(0);
	}
	
	public void updatePos() {

		if (k==0) {
			double cos =calculateCos(knight.getX(),knight.getY());
			x += getSpeed()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (knight.isVisible()==false) {
				k = 1;
			}
			if (cos>=0) {
				cowboyPic = right.get(timeOfPics/10);
			}
			else cowboyPic = left.get(timeOfPics/10);
		}
		if (k==1) {
			double cos =calculateCos(cowgirl.getX(),cowgirl.getY());
			x += getSpeed()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (cowgirl.isVisible()==false) {
				k = 0;
			}
			if (cos>=0) cowboyPic = right.get(timeOfPics/10);
			else cowboyPic = left.get(timeOfPics/10);
		}
		// change HP minus for change damage
		//if (isCharacterAttacked) takedDamage(character.getAttack());
	}
}
