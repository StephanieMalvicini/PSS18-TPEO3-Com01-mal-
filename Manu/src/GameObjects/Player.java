package GameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Nave {
	
	public Player() {
		speed = 2;
		x = 218;
		y = 680;
		dir = new Vector2(0,0);
	}

	//probablemente vaya mas arriba en jerarquia
	public void setDir(int i, int j) {
		dir.setDirec(i, j);
		
	}
	
	
	
	
	

}
