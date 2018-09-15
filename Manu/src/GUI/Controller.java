package GUI;

import Assets.Paths;
import GameObjects.Player;
import GameObjects.Vector2;

import javax.swing.*;

public class Controller {
	
	private Player v;
	private boolean isFiring;
	private ImageIcon r,l,d,u,lu,ru,n;
	
	public Controller(Player p) {
		r = new ImageIcon(Paths.NAVEDER);
		l = new ImageIcon(Paths.NAVEIZQ);
		d = new ImageIcon(Paths.NAVED);
		u = new ImageIcon(Paths.NAVEU);
		lu = new ImageIcon(Paths.NAVEIU);
		ru = new ImageIcon(Paths.NAVEDU);
		n = new ImageIcon(Paths.NAVE);
		v = p;
	}

	public void startRight() {
		v.setDirec(1,0);
		v.setSprite(r);
	}

	public void startLeft() {

		v.setDirec(-1,0);
		v.setSprite(l);
	}

	public void endMovement() {

		v.setDirec(0,0);
		v.setSprite(n);
	}


	public void startDown() {
		v.setDirec(0, 1);

		v.setSprite(d);

	}
	
	public void startUp() {

		v.setDirec(0, -1);
		v.setSprite(u);

	}

	public void startUpRight(){
		v.setDirec(1,-1);
		v.setSprite(ru);
	}

	public void startUpleft(){
		v.setDirec(-1,-1);
		v.setSprite(lu);
	}

	public void startDownRight(){
		v.setDirec(1,1);
		v.setSprite(d);
	}

	public void startDownLeft(){
		v.setDirec(-1,1);
		v.setSprite(d);

	}



	public boolean isFiring() {
		return isFiring;
	}
	
	public void Fire() {
		v.fire();
	}

	public void endFire() {
		v.stopFiring();
		
	}

	
	

	

	
	

}
