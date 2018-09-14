package Map;

import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JLabel;

import GUI.Window;
import GameObjects.*;

public final class Map {
	
	Collection<GraphicObject> list;
	Collection<GraphicObject> shooters;
	Collection<GraphicObject> bullets;
	Window wind;
	private static Map instance;

	public static Map newInstance(Window w){
		if (instance == null){
			instance = new Map(w);
		}
		return instance;
	}

	public static Map getInstance() throws Exception {  //TODO: crear excepciones
		if (instance == null)
			throw new Exception();
		return instance;
	}

	private Map(Window w) {
		list = new LinkedList<GraphicObject>();
		wind = w;
		shooters = new LinkedList<GraphicObject>();
		bullets = new LinkedList<GraphicObject>();

		
		
	}
	
	public void newShooter(int x, int y, Shooter o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		ShooterGraphiObject ret =  new ShooterGraphiObject(o, l);

		shooters.add(ret);
	}
	public void newBullet(int x, int y, GameObject o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		GraphicObject ret =  new GraphicObject(o, l);
		bullets.add(ret);
	}
	public void newObject(int x, int y, GameObject o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		GraphicObject ret =  new GraphicObject(o, l);
		list.add(ret);
	}

	  public void run() {
		   wind.Show();
	    }
	  

	
	
	

	public void update() {
		for(GraphicObject s : shooters) {

			  s.update();
		  }

		for(GraphicObject o : bullets) {
			o.update();
			if(o.getObject().getY() == 0)
				o.destroy();
		}

		for(GraphicObject o : list)
			o.update();

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}


