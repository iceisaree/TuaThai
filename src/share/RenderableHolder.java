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
			if (e instanceof Minion2) {
				//System.out.println("This is in minion2");
				((Minion2) e).updatePos();
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
			System.out.println("This is in remove");
			if (listRender.get(i).isVisible()) System.out.println("um");
			if (listRender.get(i).isVisible() == false) {
				listRender.remove(i);
				//System.out.println("removeeeeeeeeeeeee");
			}
	}
	}
	public int setVisible() {
		int exp =0;
		for (IRenderable i : listRender) {
			if (i instanceof Monster) {
				for (IRenderable j : listRender) {
					if (j instanceof CowgirlSkill1) {
						if (((Monster)i).isDestroyed(((CowgirlSkill1)j).getX(), ((CowgirlSkill1)j).getY())) {
							System.out.println("this is in setVisible");
							((Monster)i).setVisible(false);
							System.out.println("this is in is destroy");
							((CowgirlSkill1)j).setVisible(false);
							exp+=10;
						}
					}
					if (j instanceof CowgirlSkill2) {
						if (((Monster)i).isDestroyed(((CowgirlSkill2)j).getX(), ((CowgirlSkill2)j).getY())) {
							System.out.println("this is in setVisible");
							((Monster)i).setVisible(false);
							System.out.println("this is in is destroy");
							((CowgirlSkill2)j).setVisible(false);
							exp+=10;
						}
					}
					// set visible for knight skill 
					if (j instanceof KnightSkill) {
						if (((Monster)i).isDestroyed(((KnightSkill)j).getX(), ((KnightSkill)j).getY())) {
							System.out.println("this is in setVisible");
							((Monster)i).setVisible(false);
							System.out.println("this is in is destroy");
							((KnightSkill)j).setVisible(false);
							exp+=10;
						}
					}
			}
			
			}
			
		}
		return exp;
	}
	public void clearList() {
		this.listRender = null;
		this.listRender = new ArrayList<>();
	}
}
