package GUI;

import Assets.Paths;
import GameObjects.Player;
import GameObjects.Vector2;

public class Controller {
	
	Player v;
	private boolean isFiring;
	
	public Controller(Player p) {
		v = p;
	}

	public void startRight() {
		v.setDirec(1,0);
		v.setSprite(Paths.NAVEDER);
	}

	public void startLeft() {

		v.setDirec(-1,0);
		v.setSprite(Paths.NAVEIZQ);
	}

	public void endMovement() {

		v.setDirec(0,0);
		v.setSprite(Paths.NAVE);
	}


	public void startDown() {
		v.setDirec(0, 1);

		v.setSprite(Paths.NAVED);

	}
	
	public void startUp() {

		v.setDirec(0, -1);
		v.setSprite(Paths.NAVEU);

	}

	public void startUpRight(){
		v.setDirec(1,-1);
		v.setSprite(Paths.NAVEDU);
	}

	public void startUpleft(){
		v.setDirec(-1,-1);
		v.setSprite(Paths.NAVEIU);
	}

	public void startDownRight(){
		v.setDirec(1,1);
		v.setSprite(Paths.NAVEDER);
	}

	public void startDownLeft(){
		v.setDirec(-1,1);
		v.setSprite(Paths.NAVEIZQ);

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
