package logic;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import share.IRenderable;
public class PlayerDetail implements IRenderable {
	private int level;
	private int life;
	private int maxLife;
	private int exp;
	private int maxExp;
	private int cowgirlLevel;
	private int cowgirlLife;
	private int cowgirlMaxLife;
	private int cowgirlExp;
	private int cowgirlMaxExp;
	private final Font score_Font = Font.loadFont(ClassLoader.getSystemResourceAsStream("AvenueX-Regular.otf"),15);
	public Image backgroundGame = new Image("forest.png");
	public Image IconSkillKnight1;
	public Image IconSkillKnight2;
	protected int cooldownIconSkillKnight1=0;
	protected int cooldownIconSkillKnight2=0;
	protected int cooldownIconSkillCowgirl1=0;
	protected int cooldownIconSkillCowgirl2=0;
	protected int score;
	public Image IconSkillCowgirl1;
	public Image IconSkillCowgirl2;
	public Image heart = new Image("heart.png",30,30,false,false);
	public Image knight = new Image("knighticon.png");
	public Image lv = new Image("arrow.png");
	public Image cowgirl = new Image("cg.png");
	public PlayerDetail() {
	
	}
	public void setImage() {
		if (score<200) {
			backgroundGame = new Image("forest1.png");
		}else if (score<300) {
			backgroundGame = new Image("night1.png");
		}else{
			backgroundGame = new Image("desert1.png");
		}
	}
	
	public void draw(GraphicsContext gc) {
		//draw Level exp Hp for knight and cowgirls
		setImage();
		gc.drawImage(backgroundGame, 0, 0);
		gc.setFill(Color.ALICEBLUE);
		gc.fillRect(0, 0, 950, 50);
		gc.setFill(Color.BLACK);
		gc.drawImage(knight, 10, 0);
		gc.drawImage(heart, 80, 10);
		gc.fillText(": "+life+"/"+maxLife,105,30);
		gc.drawImage(lv, 180, 0);
		gc.fillText("LV : "+level,220,30);
		gc.fillText("Exp : "+exp+"/"+maxExp, 265, 30);
		gc.drawImage(IconSkillKnight1,355,0);
		gc.drawImage(IconSkillKnight2, 425, 0);
		
		
		// fix position skill pic

		gc.drawImage(cowgirl, 500, 0);
		gc.drawImage(heart, 565, 10);
		gc.fillText(": "+cowgirlLife+"/"+cowgirlMaxLife,595,30);
		gc.drawImage(lv, 653, 0);
		gc.fillText("LV : "+cowgirlLevel,695,30);
		gc.fillText("Exp : "+cowgirlExp+"/"+cowgirlMaxExp, 735, 30);
		gc.setFont(score_Font);
		gc.fillText("Score : "+score,450,590);
		gc.drawImage(IconSkillCowgirl1, 830, 0);
		gc.drawImage(IconSkillCowgirl2, 900, 0);
		
		
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isVisible() {
		return true;
	}
	public void setKnightData(int maxExp,int exp,int level,int maxLife,int life) {
		this.maxExp = maxExp;
		this.exp = exp;
		this.level = level;
		this.maxLife = maxLife;
		this.life = life;
	}
	public void setCowgirlData(int maxExp,int exp,int level,int maxLife,int life) {
		this.cowgirlMaxExp = maxExp;
		this.cowgirlExp = exp;
		this.cowgirlLevel = level;
		this.cowgirlMaxLife = maxLife;
		this.cowgirlLife = life;
	}
	public void setCooldownKnight(int cooldownKnight1,int cooldownKnight2) {
		if (cooldownKnight2==0) IconSkillKnight1 = new Image("IconSkillknight1.png",50,50,false,false);
		if (cooldownKnight1==0) IconSkillKnight2 = new Image("IconSkillknight2.png",50,50,false,false);
		if (cooldownKnight2!=0) IconSkillKnight1 = new Image("cooldownIconSkillknight1.png",50,50,false,false);
		if (cooldownKnight1!=0) IconSkillKnight2 = new Image("cooldownIconSkillknight2.png",50,50,false,false);
		
		// add cooldown depend on time
	}
	// add cooldown pic
	public void setCooldownCowgirl(int cooldownCowgirl1,int cooldownCowgirl2) {
		IconSkillCowgirl1 = new Image("IconSkillcowgirl1.png",50,50,false,false);
		IconSkillCowgirl2 = new Image("IconSkillcowgirl2.png",50,50,false,false);
		if (cooldownCowgirl1!=0) IconSkillCowgirl1 = new Image("cooldownIconSkillcowgirl1.png",50,50,false,false);
		if (cooldownCowgirl2!=0) IconSkillCowgirl2 = new Image("cooldownIconSkillcowgirl2.png",50,50,false,false);
		
	}
}
