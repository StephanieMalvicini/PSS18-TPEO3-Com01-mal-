package GameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Assets.Paths;
import GUI.Controller;
import Map.Map;

public class Player extends  Shooter{
	Controller c;
	private int dano;
	private int attackSpeed;
	private boolean loaded;
	private long time;
	private int gunPosition;

	
	public Player(Controller cont) {
		health = 200;
		speed = 2;
		x = 218;
		y = 680;
		dir = new Vector2(0,0);
		c = cont;
		dano = 20;
		sprite = Paths.NAVE;
		attackSpeed = 300;
		boolean loaded = true;
		gunPosition = 125 ;

	}

	//probablemente vaya mas arriba en jerarquia
	public void setDir(Vector2 v) {
		dir = v;
		
	}
	

	
	public void update() {
		dir = c.getDirection();
		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && c.isFiring()){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;
			try {
				Map.getInstance().newBullet((x + gunPosition), y,new PlayerBullet(dano, x + gunPosition, y));
			} catch (Exception e) {
				e.printStackTrace();
			}
			gunPosition = ((gunPosition + 80)%160) ;

		}
		super.update();
		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && c.isFiring()){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;
			try {
				Map.getInstance().newBullet(x + gunPosition, y,new PlayerBullet(dano, x, y));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	

}
