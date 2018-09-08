package GameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Nave extends DestroyableObject {
	protected int speed;
	
	protected Vector2 dir;
	
	public void update() {
		x += dir.getX() * speed;
		y += dir.getY() * speed;
		super.update();
	}
	
	

}
