package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss3 extends Boss {

	public Image dinoPic;
	int k = rand.nextInt(2);
	protected List<Image> right = new ArrayList<>();
	protected List<Image> left = new ArrayList<>();
	private int timeOfPics = 0;
	
	public Boss3(Knight knight,Cowgirls cowgirl) {
		super(100,20,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<11; i++) {
			left.add(new Image("dino_left ("+i+").png",100,100,false,false));
			right.add(new Image("dino_right ("+i+").png",100,100,false,false));
		}
		setDino();
	}

	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(dinoPic, x, y);
	}

	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	public void setDino() {
		dinoPic = right.get(0);
	}
	
	public void updatePos() {
		if (k==0) {
			double cos =calculateCos(knight.getX(),knight.getY());
			x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
			y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
			if (knight.isVisible()==false) {
				k = 1;
			}
			if (cos>=0) {
				dinoPic = right.get(timeOfPics/10);
			}
			else dinoPic = left.get(timeOfPics/10);
		}
		if (k==1) {
			double cos =calculateCos(cowgirl.getX(),cowgirl.getY());
			x += getSpeed()*cowgirl.getLevel()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*cowgirl.getLevel()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (cowgirl.isVisible()==false) {
				k = 0;
			}
			if (cos>=0) {
				dinoPic = right.get(timeOfPics/10);
			}
			else dinoPic = left.get(timeOfPics/10);
		}
		
		boolean isCharacterAttacked;
		isCharacterAttacked = knight.attackPos((int) x,(int)y);
		isCharacterAttacked = cowgirl.attackPos((int) x,(int)y);
		// change HP minus for change damage
		//if (isCharacterAttacked) takedDamage(character.getAttack());
	}
	public double calculateSin(double charX,double charY) {
		double c = charX - this.x;
		double k = charY - this.y;
		double cha = Math.sqrt((k*k)+(c*c));
		double sin = k/cha;
		return sin;
	}
	public double calculateCos(double charX,double charY) {
		double c = charX - this.x;
		double k = charY - this.y;
		double cha = Math.sqrt((k*k)+(c*c));
		double cos = c/cha;
		return cos;
	}

}
