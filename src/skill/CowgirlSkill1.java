package skill;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class CowgirlSkill1 extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private int typeSkill;
	private boolean isFromCowgirls = false;
	private int addX,addY;
	public CowgirlSkill1(double x,double y,char route,int addX,int addY) {
		super(x,y);
		this.route = route;
		this.addX = addX;
		this.addY = addY;
		setKnightSkill();
	}

	public void setKnightSkill() {
		if (route=='j') {
			skillPic = new Image("Tbomb_down.png",10,50,false,false);
		}else if (route == 'k') {
			skillPic = new Image("Tbomb_right.png",50,10,false,false);
		}else if (route == 'u') {
			skillPic = new Image("Tbomb_up.png",10,50,false,false);
		}else if (route == 'h') {
			skillPic = new Image("Tbomb_left.png",50,10,false,false);
		}
	}
	public void draw(GraphicsContext gc) {
		System.out.println("this is in CowgirlsSkill1");
		System.out.println("this is x : "+x+"This is y : "+y);
		gc.drawImage(skillPic, x+addX, y+addY);
	}
	public void updatePos() {
		if (route=='h') {
			x-=10;
		}
		if (route=='k') {
			x+=10;
		}
		if (route=='u') {
			y-=10;
		}
		if (route=='j') {
			y+=10;
		}
		if(x>960 || x <0 || y>600 || y<0) isVisible = false;
		if( route=='r') {
			x+=10;
			y+=10;
		}
		if(route=='t') {
			x+=10;
			y-=10;
		}
		if(route=='y') {
			x-=10;
			y-=10;
		}
		/*if(route=='u') {
			x-=10;
			y+=10;
		}*/
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public char getRoute() {
		return route;
	}

	public void setRoute(char route) {
		this.route = route;
	}

	public Image getSkillPic() {
		return skillPic;
	}

	public void setSkillPic(Image skillPic) {
		this.skillPic = skillPic;
	}

	public boolean isFromCowgirls() {
		return isFromCowgirls;
	}

	public void setFromCowgirls(boolean isFromCowgirls) {
		this.isFromCowgirls = isFromCowgirls;
	}
}
