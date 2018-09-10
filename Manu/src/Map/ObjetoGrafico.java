package Map;

import javax.swing.JLabel;
import GUI.*;
import GameObjects.GameObject;

public class ObjetoGrafico {
	private GameObject object;
	private JLabel model;
	
	public ObjetoGrafico(GameObject o) {
		object = o;
		model = Window.newPlayer(object.getX(), object.getY());
	}
	
	
	
	public void update() {
		object.update();
		int x = object.getX();
		int y = object.getY();
		model.setBounds(x, y, 182, 200);
	}
	
	

}
