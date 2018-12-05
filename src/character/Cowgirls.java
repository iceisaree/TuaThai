package character;

import java.util.ArrayList;
import java.util.List;
import share.Entity;
import share.IRenderable;
import share.RenderableHolder;
import skill.CowgirlSkill1;
import skill.CowgirlSkill2;
import skill.KnightSkill;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
//change data in character and Knight
public class Cowgirls extends Character{
	
	public Cowgirls(double x, double y) {
		super();
		// TODO Auto-generated constructor stub
	}
	protected int [] indexExp = {10,50,200,800,3200,3200,3400,3800,4000,4200,3000,2000,1000,500,200};
	private int timeOfPics = 0;
	public Image CowgirlPic;
	private String control;
	private List<Image> left = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	
	public Cowgirls(){
		super();
		for (int i=1;i<5;i++) {
			left.add(new Image("cowgirl_Left ("+i+").png",90,80, false, false));
			up.add(new Image("cowgirl_Right ("+i+").png",90,80,false,false));
			down.add(new Image("cowgirl_Right ("+i+").png",90,80,false,false));
			right.add(new Image("cowgirl_Right ("+i+").png",90,80,false,false));
		}
		setCowgirlPic();
		super.speed = 4;
		super.HP = 100;
		}
	public void setCowgirlPic() {
		CowgirlPic = right.get(0);
	}
	public void draw(GraphicsContext gc) {
		timeOfPics++;
		if(timeOfPics>=30) timeOfPics = 0; 
		//System.out.println("This is in knight draw");
		gc.drawImage(CowgirlPic, x, y);
	}
	public void updatePos() {
		if (control.contains("h")) if(x>=35) {
			x-=speed;
			CowgirlPic = left.get(timeOfPics/10);
		}
		if (control.contains("j")) if (y+90<=600) {
			y+=speed;
			CowgirlPic = up.get(timeOfPics/10);
		}
		if (control.contains("u")) if(y>=0) {
			y-=speed;
			CowgirlPic = down.get(timeOfPics/10);
		}
		if (control.contains("k")) if (x+90<=950) {
			x+=speed;
			CowgirlPic = right.get(timeOfPics/10);
		}
	}

	public CowgirlSkill1 attack(char c,int addX,int addY) {
		CowgirlSkill1 cowgirlSkill1 = new CowgirlSkill1(x,y,c,addX,addY);
		RenderableHolder.getinstance().add(cowgirlSkill1);
		cowgirlSkill1.setCowgirlSkill1();
		return cowgirlSkill1;
	}
	public int getExp() {
		return super.exp;
	}
	
	public CowgirlSkill2 attack2(char c) {
		
		CowgirlSkill2 cowgirlSkill2 = new CowgirlSkill2(x,y,c);
		RenderableHolder.getinstance().add(cowgirlSkill2);
		cowgirlSkill2.setCowgirlSkill2();
		return cowgirlSkill2;
	}
	public void updateLevel() {
		if (Level>indexExp.length) return;
		if (exp>=indexExp[Level]) {
			Level++;
			exp=0;
			super.HP = getMaxHp();
		}
	
	}
	public int getMaxExp() {
 		return indexExp[Level];
	}
	public int getMaxHp() {
		return 50+(Level*50);
	}
	public int getHp() {
		return super.HP;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public void setControl(String control) {
		this.control = control;
	}
	
	public int getSpeed() {
		return super.speed;
	}
	public void setSpeed(int speed) {
		super.speed = speed;
	}
	public int getTimeOfPics() {
		return timeOfPics;
	}
	public void setTimeOfPics(int timeOfPics) {
		this.timeOfPics = timeOfPics;
	}
	public Image getCowgirlPic() {
		return CowgirlPic;
	}
	public void setCowgirlPic(Image CowgirlPic) {
		this.CowgirlPic = CowgirlPic;
	}
	
	public String getControl() {
		return control;
	}
	public void minusHP() {
		super.HP-=10;
		System.out.println("this is in MinusHP");
	}
	
	

	
	
}
