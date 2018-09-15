package GUI;

import GameObjects.Player;
import GameObjects.Vector2;

public class Controller {
	
	private Vector2 v;
	private boolean isFiring;
	
	public Controller() {
		v = new Vector2(0,0);
	}

	public void startRight() {
		v.setDirec(1,0);
	}

	public void startLeft() {
		v.setDirec(-1,0);
	}

	public void endMovement() {
		v.setDirec(0,0);
	}


	public void startDown() {
		v.setDirec(0, 1);
	}
	
	public void startUp() {
		v.setDirec(0, -1);
	}

	public void startUpRight(){
		v.setDirec(1,-1);
	}

	public void startUpleft(){
		v.setDirec(-1,-1);
	}

	public void startDownRight(){
		v.setDirec(1,1);
	}

	public void startDownLeft(){
		v.setDirec(-1,1);
	}

	public Vector2 getDirection() {
		return v;
	}

	public boolean isFiring() {
		return isFiring;
	}
	
	public void Fire() {
		isFiring = true;
	}

	public void endFire() {
		isFiring = false;
		
	}

	
	

	

	
	

}
