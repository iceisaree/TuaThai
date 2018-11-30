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
		
		gc.drawImage(knightSkill1,0,0);
		gc.drawImage(knightSkill2, 0, 0);
		
		
		// fix position skill pic
		gc.drawImage(cowgirlSkill1, 0, 0);
		gc.drawImage(cowgirlSkill2, 0, 0);
		
		
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
	public void setCooldownKngiht(int cooldownKnight1,int cooldownKnight2,int cooldownKnight3) {
		knightSkill1 = new Image("");
		knightSkill2 = new Image("");
		if (cooldownKnightSkill1!=0) knightSkill1 = new Image("");
		if (cooldownKnightSkill2!=0) knightSkill2 = new Image("");
		
		// add cooldown depend on time
	}
	public void setCooldownCowgirls(int cooldownCowgirls1,int cooldownCowgirls2,int cooldownCowgirls3) {
		cowgirlSkill1 = new Image("");
		cowgirlSkill2 = new Image("");
		if (cooldownCowgirlSkill1!=0) cowgirlSkill1 = new Image("");
		if (cooldownCowgirlSkill2!=0) cowgirlSkill2 = new Image("");
		
	}
}
