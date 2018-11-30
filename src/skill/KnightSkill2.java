package skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class KnightSkill2 extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private boolean isFromCowgirls = false;
	public KnightSkill2(double x,double y,char route) {
		super(x,y);
		this.route = route;
		setKnightSkill2();
	}

	public void setKnightSkill2() {
		skillPic = new Image("Horizon_explosion.png",30,30,false,false);
		
	}
	public void draw(GraphicsContext gc) {
		System.out.println("this is in knightSkill1");
		System.out.println("this is x : "+x+"This is y : "+y);
		gc.drawImage(skillPic, x+20 , y+30);
		
	}
	public void updatePos() {
		if (route=='a') x-=10;
		if (route=='d') x+=10;
		if (route=='w') y-=10;
		if (route=='s') y+=10;
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
