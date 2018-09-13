package Map;

import javax.swing.JLabel;
import GUI.*;
import GameObjects.GameObject;

public class ObjetoGrafico {
	private GameObject object;
	private JLabel model;
	
	public ObjetoGrafico(GameObject o, JLabel l) {
		object = o;
		model = l;
		//gui.newObject(object.getX(), object.getY(), 1)
	}
	
	public JLabel getLabel(){
		return model;
	}
	
	
	
	public void update() {
		object.update();
		int x = object.getX();
		int y = object.getY();
		model.setBounds(x, y, 182, 200);
	}
	
	

}
