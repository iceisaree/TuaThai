package share;

import java.util.List;
import java.util.ArrayList;

import character.Character;
import character.Knight;
import character.Monster;
import javafx.scene.canvas.GraphicsContext;

public class RenderableHolder {
	private static final RenderableHolder render = new RenderableHolder();
	private List<IRenderable> listRender;
	private String control="";
	public RenderableHolder() {
		listRender = new ArrayList<>();
		
	}
	public static RenderableHolder getinstance() {
		return render;
	}
	
	public void add(IRenderable i) {
		listRender.add(i);
	}
	public void updatePos(String control) {
		for (IRenderable e:listRender) {
			if (e instanceof Knight) {
				((Knight)e).setControl(control);
				((Knight)e).updatePos();
			}
		}
	}
	public void draw(GraphicsContext gc) {
		for (int i=0;i<listRender.size();i++) {
			listRender.get(i).draw(gc);
		}
	}
	
	public void remove() {
		int n = listRender.size();
		for (int i=n-1;i>=0;i--) {
			if (listRender.get(i).isVisible() == false) {
				listRender.remove(i);
			}
	}
	}
	public void clearList() {
		this.listRender = null;
		this.listRender = new ArrayList<>();
	}
}
