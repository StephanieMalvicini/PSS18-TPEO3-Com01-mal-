package GUI;

import GameObjects.Player;

public class Controller {
	
	Player p;
	
	public Controller(Player p) {
		this.p = p;
	}

	public void startRight() {
		p.setDir(1,0);
		
		
	}

	public void startLeft() {
		p.setDir(-1,0);
		
	}

	public void end() {
		p.setDir(0,0);
		
	}


	public void startDown() {
		p.setDir(0, 1);
		
	}
	
	public void startUp() {
		p.setDir(0, -1);
		
	}

	
	

	

	
	

}
