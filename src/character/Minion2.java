package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Minion2 extends Monster {
	public Image zombiePic;
	protected List<Image> left = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	int k = rand.nextInt(2);
	private int timeOfPics = 0;
	
	public Minion2(Knight knight,Cowgirls cowgirl) {
		super(100,20,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Left ("+i+").png",70,80,false,false));
			right.add(new Image("zombiemale_Right ("+i+").png",70,80,false,false));
		}
		setZombie();
	}
	
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(zombiePic, x, y);
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
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

		if ((this.x <= cowgirl.getX()+20 && cowgirl.getX()-20 <= this.x) && (this.y <= cowgirl.getY()+10 && cowgirl.getY()-10 <= this.y)) {
			//set change HP
		
			cowgirl.setHP(cowgirl.getHp()-10);
			return false;
		}
		
		
		}
		return super.isVisible;
	}
	public boolean isDestroyed(int x,int y) {
		if ((this.x < x+20 && x-20 < this.x) && (this.y < y+20 && y-20 < this.y)) {
			isVisible = false;
			return true;
		}
		return false;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		super.isVisible =false;
	}
	public void setZombie() {
		zombiePic = right.get(0);
	}
	
	public void updatePos() {
		if (k==0) {
			double cos =calculateCos(knight.getX(),knight.getY());
			x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
			y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
			if (cos>=0) {
				zombiePic = right.get(timeOfPics/10);
			}
			else zombiePic = left.get(timeOfPics/10);
		}
		if (k==1) {
			double cos =calculateCos(knight.getX(),knight.getY());
			x += getSpeed()*cowgirl.getLevel()*calculateCos(cowgirl.getX(),cowgirl.getY());
			y += getSpeed()*cowgirl.getLevel()*calculateSin(cowgirl.getX(),cowgirl.getY());
			if (cos>=0) {
				zombiePic = right.get(timeOfPics/10);
			}
			else zombiePic = left.get(timeOfPics/10);
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
