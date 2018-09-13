package Map;

import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JLabel;

import GUI.Controller;
import GUI.Window;
import GameObjects.Bullet;
import GameObjects.GameObject;
import GameObjects.Player;
import GameObjects.Shooter;

public class Map {
	
	Collection<ObjetoGrafico> list;
	Collection<ObjetoGrafico> shooters;
	Collection<ObjetoGrafico> bullets;
	Window wind;

	public Map(Window w) {
		list = new LinkedList<ObjetoGrafico>();
		wind = w;
		shooters = new LinkedList<ObjetoGrafico>();
		bullets = new LinkedList<ObjetoGrafico>();

		
		
	}
	
	public void newShooter(int x, int y, Shooter o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		ObjetoGrafico ret =  new ObjetoGrafico(o, l);

		shooters.add(ret);
	}
	public void newBullet(int x, int y, Bullet o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		ObjetoGrafico ret =  new ObjetoGrafico(o, l);

		list.add(ret);
	}
	public void newObject(int x, int y, GameObject o) {
		JLabel l = wind.newObject(x, y, o.getSprite());
		ObjetoGrafico ret =  new ObjetoGrafico(o, l);
		list.add(ret);
	}

	  public void run() {
		   wind.Show();
	    }
	  
	  public void disparar() {
	
	  }
	
	
	

	public void update() {
		for(Object s : shooters) {
			  Bullet b = s.isShooting();
			  if (b != null) {
				  newActor(s.getX(), s.getY(), b);
			  }
		  }
		for(ObjetoGrafico o : list)
			o.update();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

}


