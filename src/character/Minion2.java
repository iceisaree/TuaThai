package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Minion2 extends Monster {
	public Image zombiePic;
	protected List<Image> left = new ArrayList<>();
	protected List<Image> up = new ArrayList<>();
	protected List<Image> down = new ArrayList<>();
	protected List<Image> right = new ArrayList<>();
	
	public Minion2(double hp, int attack,Knight knight,Cowgirls cowgirl) {
		super(100, 20, knight,cowgirl);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png",70,80,false,false));
			right.add(new Image("zombiemale_Right ("+i+").png",70,80,false,false));
			down.add(new Image("zombiemale_Up ("+i+").png",70,80,false,false));
			up.add(new Image("zombiemale_Up ("+i+").png",70,80,false,false));
		}
		setZombie();
		// TODO Auto-generated constructor stub
	}
	public Minion2(Knight knight,Cowgirls cowgirl) {
		super(100,20,knight,cowgirl);
		for (int i=1; i<5; i++) {
			left.add(new Image("zombiemale_Right ("+i+").png",70,80,false,false));
			right.add(new Image("zombiemale_Right ("+i+").png",70,80,false,false));
			down.add(new Image("zombiemale_Up ("+i+").png",70,80,false,false));
			up.add(new Image("zombiemale_Up ("+i+").png",70,80,false,false));
		}
		setZombie();
	}
	
	public void draw(GraphicsContext gc) {
		//monsterPic = new Image("zombiefemale_Up (1).png");
		//System.out.println("monster in draw");
		gc.drawImage(new Image("zombiemale_Up (1).png",70,80,false,false), x, y);
	}
	@Override
	/*public void special() {
		// TODO Auto-generated method stub
		
	}
	@Override*/
	public boolean isVisible() {
		// TODO Auto-generated method stub
		if ((this.x <= knight.getX()+20 && knight.getX()-20 <= this.x) && (this.y <= knight.getY()+10 && knight.getY()-10 <= this.y)) {
			//setChangeHp
		
			return false;
		}
		if ((this.x <= cowgirl.getX()+20 && cowgirl.getX()-20 <= this.x) && (this.y <= cowgirl.getY()+10 && cowgirl.getY()-10 <= this.y)) {
			//set change HP
		
			return false;
		}
		
		return isVisible;
	}
	/*public boolean isDestroyed(int x,int y) {
		if ((this.x < x+20 && x-20 < this.x) && (this.y < y+20 && y-20 < this.y)) {
			isVisible = false;
			return true;
		}
		return false;
	}*/
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
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
	public void updatePos() {

		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos Monster");
		//System.out.println(getSpeed()+" "+knight.getX()+" "+knight.getY());
		x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
		y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
		//System.out.println(getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY())+" "+y+"aaaaaaaaaaa");
		//x += getSpeed();
		//y += getSpeed();
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
