package GameObjects;

import java.net.URL;

public abstract class GameObject {
	protected int x, y;
	protected static URL sprite;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public URL getSprite() {
		return sprite;
	}
	
	public abstract void update();
}
