package skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class KnightSkill extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private int type;
	private String skillPic_path;
	
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
			skillPic_path = ClassLoader.getSystemResource("Bullet_down.png").toString();
			skillPic = new Image(skillPic_path,40,40,false,false);
		}else if (route == 'a') {
			skillPic_path = ClassLoader.getSystemResource("Bullet_right.png").toString();
			skillPic = new Image(skillPic_path,40,40,false,false);
		}else if (route == 'w') {
			skillPic_path = ClassLoader.getSystemResource("Bullet_up.png").toString();
			skillPic = new Image(skillPic_path,40,40,false,false);
		}else if (route == 'd') {
			skillPic_path = ClassLoader.getSystemResource("Bullet_left.png").toString();
			skillPic = new Image(skillPic_path,40,40,false,false);
		}
	}
	public void setKnightSkill2() {
		if (route=='s' || route=='a' || route=='w' ||route=='d') {
			skillPic_path = ClassLoader.getSystemResource("Horizon_explosion.png").toString();
			skillPic = new Image(skillPic_path,30,30,false,false);
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
