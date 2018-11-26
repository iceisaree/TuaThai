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
	
	public Image knightSkill1;
	public Image knightSkill2;
	public Image knightSkill3;
	
	public Image cowgirlsSkill1;
	public Image cowgirlsSkill2;
	public Image cowgirlsSkill3;
	
	public void draw(GraphicsContext gc) {
		//draw Level exp Hp for knight and cowgirls
		
		gc.drawImage(knightSkill1,0,0);
		gc.drawImage(knightSkill2, 0, 0);
		gc.drawImage(knightSkill3,0,0);
		
		// fix position skill pic
		gc.drawImage(cowgirlsSkill1, 0, 0);
		gc.drawImage(cowgirlsSkill2, 0, 0);
		gc.drawImage(cowgirlsSkill3,0,0);
		
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
		knightSkill3 = new Image("");
		// add cooldown depend on time
	}
	public void setCooldownCowgirls(int cooldownCowgirls1,int cooldownCowgirls2,int cooldownCowgirls3) {
		cowgirlsSkill1 = new Image("");
		cowgirlsSkill2 = new Image("");
		cowgirlsSkill3 = new Image("");
	}
}
