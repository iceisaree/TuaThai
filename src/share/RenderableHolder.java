package share;

import java.util.List;

import skill.CowgirlSkill1;
import skill.CowgirlSkill2;
import skill.KnightSkill;

import java.util.ArrayList;
import character.*;
import character.Character;
import javafx.scene.canvas.GraphicsContext;
import share.IRenderable;

public class RenderableHolder {
	private static final RenderableHolder render = new RenderableHolder();
	private List<IRenderable> listRender;
	
	public RenderableHolder() {
		listRender = new ArrayList<>();
		
	}
	public static RenderableHolder getinstance() {
		return render;
	}
	
	public void add(IRenderable i) {
		listRender.add(i);
		System.out.println(i);
	}
	public void updatePos(String control) {
		for (IRenderable e:listRender) {
			if (e instanceof Knight) {
				((Knight)e).setControl(control);
				((Knight)e).updatePos();
			}
			if (e instanceof Cowgirls) {
				((Cowgirls)e).setControl(control);
				((Cowgirls)e).updatePos();
			}
			if (e instanceof Boss1) {
				((Boss1) e).updatePos();
			}
			if (e instanceof Boss2) {
				((Boss2) e).updatePos();
			}
			if (e instanceof Boss3) {
				((Boss3) e).updatePos();
			}
			if (e instanceof Boss) {
				((Boss) e).updatePos();
			}
			if (e instanceof CowgirlSkill1) {
				((CowgirlSkill1) e).updatePos();
			}
			if (e instanceof Monster) {
				((Monster) e).updatePos();
			}
			if (e instanceof KnightSkill) {
				((KnightSkill) e).updatePos();
			}
			
			if (e instanceof CowgirlSkill2) {
				((CowgirlSkill2) e).updatePos();
			}


			
			
			
		}
	}
	public void draw(GraphicsContext gc) {
		
		for (int i=0;i<listRender.size();i++) {
			//System.out.println("this is draw in renderableHolder");
			listRender.get(i).draw(gc);
		}
	}
	
	public void remove() {
		int n = listRender.size();
		//System.out.println(listRender.size()+" sizeeeeeeeee");
		for (int i=n-1;i>=0;i--) {
		
			//if (listRender.get(i).isVisible()) System.out.println("um");
			if (listRender.get(i).isVisible() == false) {
				listRender.remove(i);
				System.out.println("removeeeeeeeeeeeee");
			}
	}
	}
	// minion killed by knight
	public int setVisible2() {
		int exp =0;
		for (IRenderable i : listRender) {
			if (i instanceof Monster) {
				for (IRenderable j : listRender) {
					// set visible for knight skill 
					if (j instanceof KnightSkill) {
						if (((Monster)i).isDestroyed(((KnightSkill)j).getX(), ((KnightSkill)j).getY())) {
							//System.out.println("this is in setVisible");
							((Monster)i).setVisible(false);
							//System.out.println("this is in is destroy");
							((KnightSkill)j).setVisible(false);
							exp+=10;
						}
					}
			}
			
			}
			
		}
		return exp;
	}
	// minion killed by cowgirl
	public int setVisible() {
		int exp =0;
		for (IRenderable i : listRender) {
			if (i instanceof Monster) {
				for (IRenderable j : listRender) {
					if (j instanceof CowgirlSkill1) {
						if (((Monster)i).isDestroyed(((CowgirlSkill1)j).getX(), ((CowgirlSkill1)j).getY())) {
							
							((Monster)i).setVisible(false);
							//System.out.println("this is in is destroy");
							((CowgirlSkill1)j).setVisible(false);
							exp+=10;
						}
					}
					if (j instanceof CowgirlSkill2) {
						if (((Monster)i).isDestroyed(((CowgirlSkill2)j).getX(), ((CowgirlSkill2)j).getY())) {
							//System.out.println("this is in setVisible");
							((Monster)i).setVisible(false);
							//System.out.println("this is in is destroy");
							((CowgirlSkill2)j).setVisible(false);
							exp+=10;
						}
					}
			}
			
			}
			
		}
		return exp;
	}
	public boolean setVisibleBoss() {
		for (IRenderable i:listRender) {
			if (i instanceof Boss) {
				if (((Boss) i).getHP()<=0) {
					((Boss) i).setVisible(false);
					return false;
				}
				for (IRenderable j:listRender) {
					if (j instanceof CowgirlSkill1) {
						if (((Boss) i).isDestroyed(((CowgirlSkill1)j).getX(),((CowgirlSkill1)j).getY())){
							((CowgirlSkill1)j).setVisible(false);
							System.out.println("setVisible CowgirlSkill1 = false");
							((Boss) i).decreaseBossHp(40);
						}
					}
					if (j instanceof CowgirlSkill2) {
						if (((Boss) i).isDestroyed(((CowgirlSkill2)j).getX(),((CowgirlSkill2)j).getY())){
							((CowgirlSkill2)j).setVisible(false);
							System.out.println("setVisible CowgirlSkill2 = false");
							((Boss) i).decreaseBossHp(30);
						}
					}
					if (j instanceof KnightSkill) {
						int k = ((KnightSkill) j).getType();
						if (k==0) {
							if (((Boss) i).isDestroyed(((KnightSkill)j).getX(),((KnightSkill)j).getY())){
								((KnightSkill)j).setVisible(false);
								System.out.println("setVisible knightSkill1 = false;");
								((Boss) i).decreaseBossHp(20);
							}
						}else {

							if (((Boss) i).isDestroyed(((KnightSkill)j).getX(),((KnightSkill)j).getY())){
								((KnightSkill)j).setVisible(false);
								System.out.println("setVisible knightSkill2 = false");
								((Boss) i).decreaseBossHp(10);
							}
						
					}
					
				}
			}
			}
		
		}
	return true;
	}
	public boolean haveBossInList() {
		for (IRenderable e:listRender) {
			if (e instanceof Boss) {
				return true;
			}
		}
		return false;
	}
	public void clearList() {
		this.listRender = null;
		this.listRender = new ArrayList<>();
	}
	
}
