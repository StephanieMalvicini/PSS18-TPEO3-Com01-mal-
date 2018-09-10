package Map;

import java.util.LinkedList;

import GUI.Controller;
import GameObjects.GameObject;
import GameObjects.Player;

public class Mapa {
	
	LinkedList<ObjetoGrafico> l = new LinkedList<ObjetoGrafico>();
	
	public Player newPlayer() {
		Player ret = new Player();
		ObjetoGrafico player = new ObjetoGrafico(ret);
		
		l.addLast(player);
		return ret;
		
	}
	

	public void update() {
		for(ObjetoGrafico o : l)
			o.update();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}


