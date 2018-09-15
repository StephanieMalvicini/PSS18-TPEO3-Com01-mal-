package Map;

import javax.swing.*;

import GameObjects.GameObject;

public class GraphicObject {
	protected GameObject object;
	protected JLabel model;
	
	public GraphicObject(GameObject o, JLabel l) {
		object = o;
		model = l;
	}
	
	public JLabel getLabel(){
		return model;
	}

	public GameObject getObject(){
		return object;
	}
	


	
	public void update() {
		object.update();
		int x = object.getX();
		int y = object.getY();
		//model.setIcon(object.getSprite());
		model.setBounds(x, y, 182, 200);
	}


	public void destroy() {
		model.setIcon(new ImageIcon() {
		});

	}
}
