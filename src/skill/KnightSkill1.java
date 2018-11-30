package skill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.Entity;

public class KnightSkill1 extends Entity {
	private boolean isVisible = true;
	private char route;
	public Image skillPic;
	private boolean isFromCowgirls = false;
	public KnightSkill1(double x,double y,char route) {
		super(x,y);
		this.route = route;
		setKnightSkill1();
	}

	public void setKnightSkill1() {
		if (isFromCowgirls) skillPic = new Image("desert.png",100,100,false,false);
		
	}
	public void draw(GraphicsContext gc) {
		gc.drawImage(skillPic, x, y);
	}
}
