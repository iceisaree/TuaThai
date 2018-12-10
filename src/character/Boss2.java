package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss2 extends Boss {

	public Image pumpkinPic;
	int k = rand.nextInt(2);
	protected List<Image> right = new ArrayList<>();
	protected List<Image> left = new ArrayList<>();
	private int timeOfPics = 0;
	private String leftString,rightString;
	public Boss2(Knight knight,Cowgirls cowgirl) {
		super(200,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<6; i++) {
			leftString = ClassLoader.getSystemResource("pumpkin_left ("+i+").png").toString();
			left.add(new Image(leftString,100,100,false,false));
			rightString = ClassLoader.getSystemResource("pumpkin_right ("+i+").png").toString();
			
			right.add(new Image(rightString,100,100,false,false));
		}
		setPumpkin();
	}

	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(pumpkinPic, x, y);
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setPumpkin() {
		pumpkinPic = right.get(0);
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
				pumpkinPic = right.get(timeOfPics/10);
			}
			else pumpkinPic = left.get(timeOfPics/10);
		}
		if (k==1) {
			double cos =calculateCos(cowgirl.getX(),cowgirl.getY());
			x += getSpeed()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (cowgirl.isVisible()==false) {
				k = 0;
			}
			if (cos>=0) {
				pumpkinPic = right.get(timeOfPics/10);
			}
			else pumpkinPic = left.get(timeOfPics/10);
		}
		boolean isCharacterAttacked;
		isCharacterAttacked = knight.attackPos((int) x,(int)y);
		isCharacterAttacked = cowgirl.attackPos((int) x,(int)y);
		// change HP minus for change damage
		//if (isCharacterAttacked) takedDamage(character.getAttack());
	}
}
