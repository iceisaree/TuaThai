package character;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import share.Entity;
import share.IRenderable;

public class Cowgirls extends Entity implements IRenderable{
	
	private int speed = 4;
	private static double Hp;
	private double mana;
	private double armor;
	private double attack;
	private int Level;
	private int timeOfPics = 0;
	public Image knightPic;
	private String control;
	private List<Image> left = new ArrayList<>();
	private List<Image> up = new ArrayList<>();
	private List<Image> down = new ArrayList<>();
	private List<Image> right = new ArrayList<>();
	public Cowgirls(){
		super(400,400);
		for (int i=1;i<5;i++) {
			left.add(new Image("left_"+i+".png"));
			up.add(new Image("up_"+i+".png"));
			down.add(new Image("down_"+i+".png"));
			right.add(new Image("right_"+i+".png"));
		}
	}
	public Cowgirls(double HP,double mana,double armor,double attack,String name,String classCh,int Level) {
		super(400,400);
		for (int i=1;i<5;i++) {
			left.add(new Image("left_"+i+".png"));
			up.add(new Image("up_"+i+".png"));
			down.add(new Image("down_"+i+".png"));
			right.add(new Image("right_"+i+".png"));
		}
	}
	
	public boolean isCanAttack() {
		return true;
	}
	
	public boolean LevelUp() {
		if (super.canLevelUp()) {
			super.setLevelup();
			return true;
		}else {
			return false;
		}
	}
	public static double getHp() {
		return Hp;
	}
	
	
}
