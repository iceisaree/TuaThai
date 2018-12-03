package character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Minion1 extends Monster {
	public Image ninjaPic;
	int k = rand.nextInt(2);
	
	public Minion1(Knight knight,Cowgirls cowgirl) {
		super(100,20,knight,cowgirl);
		if (!knight.isVisible()) k=1;
		if (!cowgirl.isVisible()) k=0;
		for (int i=1; i<7; i++) {
			left.add(new Image("ninja_right ("+i+").png"));
			right.add(new Image("ninja_right ("+i+").png"));
			down.add(new Image("ninja_right ("+i+").png"));
			up.add(new Image("ninja_right ("+i+").png"));
		}
		setNinja();
	}

	public void draw(GraphicsContext gc) {
		//monsterPic = new Image("zombiefemale_Up (1).png");
		//System.out.println("monster in draw");
		gc.drawImage(new Image("ninja_right (1).png",70,80,false,false), x, y);
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
			return false;
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
	}
	public void setNinja() {
		ninjaPic = left.get(0);
	}
	
	public void updatePos() {

		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos");
		//System.out.println("This is in updatePos Monster");
		//System.out.println(getSpeed()+" "+knight.getX()+" "+knight.getY());
		if (k==0) {
			x += getSpeed()*knight.getLevel()*calculateCos(knight.getX(),knight.getY());
			y += getSpeed()*knight.getLevel()*calculateSin(knight.getX(),knight.getY());
		}
		if (k==1) {
				x += getSpeed()*cowgirl.getLevel()*calculateCos(cowgirl.getX(),cowgirl.getY());
				y += getSpeed()*cowgirl.getLevel()*calculateSin(cowgirl.getX(),cowgirl.getY());
		}
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
