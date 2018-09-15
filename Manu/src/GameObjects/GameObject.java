package GameObjects;

import javax.swing.*;
import java.net.URL;

public abstract class GameObject {
	protected int x;
    protected int y;
	protected static Icon sprite;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Icon getSprite() {
		return sprite;
	}
	
	public abstract void update();
}
