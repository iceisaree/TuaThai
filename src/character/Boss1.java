package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss1 extends Boss {

	public Image robotPic;
	int k = rand.nextInt(2);
	protected List<Image> right = new ArrayList<>();
	protected List<Image> left = new ArrayList<>();
	private int timeOfPics = 0;
	private String leftString,rightString;
	
	public Boss1(Knight knight,Cowgirls cowgirl) {
		super(200,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<6; i++) {
			leftString = ClassLoader.getSystemResource("robot_left ("+i+").png").toString();
			left.add(new Image(leftString,100,100,false,false));
			rightString = ClassLoader.getSystemResource("robot_right ("+i+").png").toString();
			right.add(new Image(rightString,100,100,false,false));
		}
		setRobot();
	}

	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(robotPic, x, y);
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setRobot() {
		robotPic = right.get(0);
	}
	
	public void updatePos() {
		if (k==0) {
			double cos =calculateCos(knight.getX(),knight.getY());
			x += super.getSpeed()*calculateCos(knight.getX(),knight.getY());
			y += super.getSpeed()*calculateSin(knight.getX(),knight.getY());
			if (knight.isVisible()==false) {
				k = 1;
			}
			if (cos>=0) {
				robotPic = right.get(timeOfPics/10);
			}
			else robotPic = left.get(timeOfPics/10);
		}
		if (k==1) {
			double cos =calculateCos(cowgirl.getX(),cowgirl.getY());
			x += super.getSpeed()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += super.getSpeed()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (cowgirl.isVisible()==false) {
				k = 0;
			}
			if (cos>=0) {
				robotPic = right.get(timeOfPics/10);
			}
			else robotPic = left.get(timeOfPics/10);
		}
		boolean isCharacterAttacked;
		isCharacterAttacked = knight.attackPos((int) x,(int)y);
		isCharacterAttacked = cowgirl.attackPos((int) x,(int)y);
		
		// change HP minus for change damage
		//if (isCharacterAttacked) takedDamage(character.getAttack());
	}
	
}
