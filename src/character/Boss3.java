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
	private String leftString,rightString;
	public Boss3(Knight knight,Cowgirls cowgirl) {
		super(100,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<11; i++) {
			leftString = ClassLoader.getSystemResource("dino_left ("+i+").png").toString();
			left.add(new Image(leftString,100,100,false,false));
			rightString = ClassLoader.getSystemResource("dino_right ("+i+").png").toString();
			right.add(new Image(rightString,100,100,false,false));
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
			x += getSpeed()*calculateCos(knight.getX(),knight.getY());
			y += getSpeed()*calculateSin(knight.getX(),knight.getY());
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
			x += getSpeed()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*calculateSin(cowgirl.getX(),cowgirl.getY());
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

}
