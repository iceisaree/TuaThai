package skill;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class CowgirlSkill2 extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private int typeSkill;
	private boolean isFromCowgirls = false;
	
	public CowgirlSkill2(double x,double y,char route) {
		super(x,y);
		this.route = route;
		setKnightSkill();
	}

	public void setKnightSkill() {
		if (route=='w') {
			skillPic = new Image("missle_0.png",20,20,false,false);
		}else if (route == 'd') {
			skillPic = new Image("missle_90.png",20,20,false,false);
		}else if (route == 'a') {
			skillPic = new Image("missle_270.png",20,20,false,false);
		}else if (route == 'x') {
			skillPic = new Image("missle_180.png",20,20,false,false);
		}if (route=='e') {
			skillPic = new Image("missle_45.png",20,20,false,false);
		}else if (route == 'c') {
			skillPic = new Image("missle_135.png",20,20,false,false);
		}else if (route == 'z') {
			skillPic = new Image("missle_225.png",20,20,false,false);
		}else if (route == 'q') {
			skillPic = new Image("missle_315.png",20,20,false,false);
		}
	}
	public void draw(GraphicsContext gc) {
		//System.out.println("this is in CowgirlsSkill1");
		System.out.println("this is x : "+x+"This is y : "+y);
		gc.drawImage(skillPic, x, y+10);
	}
	public void updatePos() {
		if (route=='a') {
			x-=10;
		}
		if (route=='d') {
			x+=10;
		}
		if (route=='w') {
			y-=10;
		}
		if (route=='x') {
			y+=10;
		}
		if(x>960 || x <0 || y>600 || y<0) isVisible = false;
		if( route=='e') {
			x+=10;
			y+=10;
		}
		if(route=='c') {
			x+=10;
			y-=10;
		}
		if(route=='z') {
			x-=10;
			y-=10;
		}
		if(route=='q') {
			x-=10;
			y+=10;
		}
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
