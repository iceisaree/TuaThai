package character;

import java.util.ArrayList;
import java.util.List;
import share.Entity;
import share.IRenderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Knight extends Entity implements IRenderable {
	private List<Image> left = new ArrayList<>();
	private List<Image> jump = new ArrayList<>();
	private int speed = 4;
	private double Hp,mana,armor,attack;
	private int Level;
	private int timeOfPics = 0;
	public Image knightPic;
	private String control;
	
	private String name,classCh;
	public Knight(){
		super(75,100);
		for (int i=1;i<7;i++) {
			left.add(new Image("Run ("+i+").png"));
			jump.add(new Image("Jump ("+i+").png"));
		}
		}
	public Knight(double HP,double mana,double armor,double attack,String name,String classCh,int Level) {
			super(75,100);
			for (int i=1;i<7;i++) {
				left.add(new Image("Run ("+i+").png"));
				jump.add(new Image("Jump ("+i+").png"));
			}
		}
	public void setKnight() {
		knightPic = left.get(0);
	}
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		gc.drawImage(knightPic, 0, 410);
	}
	public void updatePos() {
		if (control.contains("a")) if(x>=35) {
			x+=speed;
			knightPic = left.get(timeOfPics/10);
		}
		if (control.contains("s")) if (y+90<=460) {
			y+=speed;
			knightPic = jump.get(timeOfPics/10);
		}
	}
	public boolean isVisible() {
		return true;
	}
	public void setControl(String control) {
		this.control = control;
	}
	
}
