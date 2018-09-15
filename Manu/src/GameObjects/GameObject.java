package GameObjects;

import GUI.IUpdatable;

import javax.swing.*;
import java.net.URL;

public abstract class GameObject implements IUpdatable {
	protected int x;
    protected int y;
	protected Icon sprite;
	
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
