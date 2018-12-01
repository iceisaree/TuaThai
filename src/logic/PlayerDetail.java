package logic;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import share.IRenderable;
public class PlayerDetail implements IRenderable {
	private int level;
	private int life;
	private int maxLife;
	private int exp;
	private int maxExp;
	public Image backgroundGame;
	public Image knightSkill1;
	public Image knightSkill2;
	protected int cooldownKnightSkill1=0;
	protected int cooldownKnightSkill2=0;
	protected int cooldownCowgirlSkill1=0;
	protected int cooldownCowgirlSkill2=0;
	public Image cowgirlSkill1;
	public Image cowgirlSkill2;
	public PlayerDetail() {
		setImage();
	}
	public void setImage() {
		backgroundGame = new Image("forest.png");
	}
	
	public void draw(GraphicsContext gc) {
		//draw Level exp Hp for knight and cowgirls
		gc.drawImage(backgroundGame, 0, 0);
		gc.fillText("Life : "+life+"/"+maxLife,50,20);
		gc.fillText("LV : "+level,500,20);
		gc.fillText("Exp : "+exp+"/"+maxExp, 600, 20);
		gc.drawImage(knightSkill1,0,400);
		gc.drawImage(knightSkill2, 100, 400);
		
		
		// fix position skill pic
		gc.drawImage(cowgirlSkill1, 200, 400);
		gc.drawImage(cowgirlSkill2, 300, 400);
		
		
	}
	public boolean isVisible() {
		return true;
	}
	public void setCharacterData(int maxExp,int exp,int level,int maxLife,int life) {
		this.maxExp = maxExp;
		this.exp = exp;
		this.level = level;
		this.maxLife = maxLife;
		this.life = life;
	}
	public void setCooldownKnight(int cooldownKnight1,int cooldownKnight2,int cooldownKnight3) {
		knightSkill1 = new Image("forset.png",50,50,false,false);
		knightSkill2 = new Image("forset.png",50,50,false,false);
		if (cooldownKnightSkill1!=0) knightSkill1 = new Image("winter.png",50,50,false,false);
		if (cooldownKnightSkill2!=0) knightSkill2 = new Image("winter.png",50,50,false,false);
		
		// add cooldown depend on time
	}
	public void setCooldownCowgirls(int cooldownCowgirls1,int cooldownCowgirls2,int cooldownCowgirls3) {
		cowgirlSkill1 = new Image("winter.png",50,50,false,false);
		cowgirlSkill2 = new Image("winter.png",50,50,false,false);
		if (cooldownCowgirlSkill1!=0) cowgirlSkill1 = new Image("winter.png",50,50,false,false);
		if (cooldownCowgirlSkill2!=0) cowgirlSkill2 = new Image("winter.png",50,50,false,false);
		
	}
}
