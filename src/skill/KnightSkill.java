package skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class KnightSkill extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private int type;
	
	public KnightSkill(double x,double y,char route,int type) {
		super(x,y);
		this.route = route;
		this.type = type;
		if(type==0) {
			setKnightSkill();
		}else {
			this.type = type;
			setKnightSkill2();
		}
		
	}

	public void setKnightSkill() {
		if (route=='s') {
			skillPic = new Image("Bullet_down.png",50,50,false,false);
		}else if (route == 'a') {
			skillPic = new Image("Bullet_right.png",50,50,false,false);
		}else if (route == 'w') {
			skillPic = new Image("Bullet_up.png",50,50,false,false);
		}else if (route == 'd') {
			skillPic = new Image("Bullet_left.png",50,50,false,false);
		}
	}
	public void setKnightSkill2() {
		if (route=='s') {
			skillPic = new Image("Horizon_explosion.png",30,30,false,false);
		}else if (route == 'a') {
			skillPic = new Image("Horizon_explosion.png",30,30,false,false);
		}else if (route == 'w') {
			skillPic = new Image("Horizon_explosion.png",30,30,false,false);
		}else if (route == 'd') {
			skillPic = new Image("Horizon_explosion.png",30,30,false,false);
		}
	}
	public void draw(GraphicsContext gc) {
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
		if (route=='s') {
			y+=10;
		}
		if(x>950 || x <0 || y>600 || y<0) isVisible = false;
		
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
	public int getType() {
		return type;
	}
	
}
