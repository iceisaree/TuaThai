package skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class KnightSkill extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private int typeSkill;
	private boolean isFromCowgirls = false;
	
	public KnightSkill(double x,double y,char route,int typeSkill) {
		super(x,y);
		this.typeSkill = typeSkill;
		this.route = route;
		this.typeSkill = typeSkill;
		setKnightSkill();
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
	public void draw(GraphicsContext gc) {
		System.out.println("this is in knightSkill1");
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
		if (route=='s') {
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
		if(route=='u') {
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
