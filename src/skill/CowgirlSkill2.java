package skill;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class CowgirlSkill2 extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private String skillPic_path;
	public CowgirlSkill2(double x,double y,char route) {
		super(x,y);
		this.route = route;
		setCowgirlSkill2();
	}

	public void setCowgirlSkill2() {
		if (route=='w') {
			skillPic_path = ClassLoader.getSystemResource("missle_0.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'd') { //90
			skillPic_path = ClassLoader.getSystemResource("missle_90.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'a') { //270
			skillPic_path = ClassLoader.getSystemResource("missle_270.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'x') { //180
			skillPic_path = ClassLoader.getSystemResource("missle_180.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}if (route=='e') { //45
			skillPic_path = ClassLoader.getSystemResource("missle_45.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'c') { //135
			skillPic_path = ClassLoader.getSystemResource("missle_135.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'z') { //225
			skillPic_path = ClassLoader.getSystemResource("missle_225.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}else if (route == 'q') { //315
			skillPic_path = ClassLoader.getSystemResource("missle_315.png").toString();
			skillPic = new Image(skillPic_path,20,20,false,false);
		}
	}
	public void draw(GraphicsContext gc) {
		//System.out.println("this is in CowgirlsSkill1");
		//System.out.println("this is x : "+x+"This is y : "+y);
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
		if(x>950 || x <0 || y>600 || y<0) isVisible = false;
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
}
