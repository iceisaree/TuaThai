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
	public Image IconSkillKnight1;
	public Image IconSkillKnight2;
	protected int cooldownIconSkillKnight1=0;
	protected int cooldownIconSkillKnight2=0;
	protected int cooldownIconSkillCowgirl1=0;
	protected int cooldownIconSkillCowgirl2=0;
	public Image IconSkillCowgirl1;
	public Image IconSkillCowgirl2;
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
		gc.drawImage(IconSkillKnight1,0,400);
		gc.drawImage(IconSkillKnight2, 100, 400);
		
		
		// fix position skill pic
		gc.drawImage(IconSkillCowgirl1, 200, 400);
		gc.drawImage(IconSkillCowgirl2, 300, 400);
		
		
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
	public void setCooldownKnight(int cooldownKnight1,int cooldownKnight2) {
		IconSkillKnight1 = new Image("IconSkillknight1.png",50,50,false,false);
		IconSkillKnight2 = new Image("IconSkillknight2.png",50,50,false,false);
		if (cooldownIconSkillKnight1!=0) IconSkillKnight1 = new Image("IconSkillknight1.png",50,50,false,false);
		if (cooldownIconSkillKnight2!=0) IconSkillKnight2 = new Image("IconSkillknight2.png",50,50,false,false);
		
		// add cooldown depend on time
	}
	public void setCooldownCowgirls(int cooldownCowgirls1,int cooldownCowgirls2) {
		IconSkillCowgirl1 = new Image("IconSkillcowgirl1.png",50,50,false,false);
		IconSkillCowgirl2 = new Image("IconSkillcowgirl2.png",50,50,false,false);
		if (cooldownIconSkillCowgirl1!=0) IconSkillCowgirl1 = new Image("IconSkillCowgirl1.png",50,50,false,false);
		if (cooldownIconSkillCowgirl2!=0) IconSkillCowgirl2 = new Image("IconSkillCowgirl2.png",50,50,false,false);
		
	}
}
