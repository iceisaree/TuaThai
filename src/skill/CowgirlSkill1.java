package skill;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class CowgirlSkill1 extends Entity {
	private boolean isVisible = true;
	private char route;
	private int addX,addY;
	private String skillPic_path;
	protected Image skillPic;
	public CowgirlSkill1(double x,double y,char route,int addX,int addY) {
		super(x,y);
		this.route = route;
		this.addX = addX;
		this.addY = addY;
		setCowgirlSkill1();
	}

	public void setCowgirlSkill1() {
		if (route=='j') {
			skillPic_path = ClassLoader.getSystemResource("Tbomb_down.png").toString();
			skillPic = new Image(skillPic_path,10,50,false,false);
		}else if (route == 'k') {
			skillPic_path = ClassLoader.getSystemResource("Tbomb_right.png").toString();
			skillPic = new Image(skillPic_path,50,10,false,false);
		}else if (route == 'u') {
			skillPic_path = ClassLoader.getSystemResource("Tbomb_up.png").toString();
			skillPic = new Image(skillPic_path,10,50,false,false);
		}else if (route == 'h') {
			skillPic_path = ClassLoader.getSystemResource("Tbomb_left.png").toString();
			skillPic = new Image(skillPic_path,50,10,false,false);}
		
	}
	public void draw(GraphicsContext gc) {
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
