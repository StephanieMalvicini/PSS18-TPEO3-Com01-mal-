package GameObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Assets.Paths;
import GUI.Controller;

public class Player extends  Shooter{
	Controller c;
	int dano;
	int attackSpeed;
	boolean loaded;
	long time;
	
	
	public Player(Controller cont) {
		health = 200;
		speed = 2;
		x = 218;
		y = 680;
		dir = new Vector2(0,0);
		c = cont;
		dano = 20;
		sprite = Paths.NAVE;
		attackSpeed = 500;
		boolean loaded = true;
	}

	//probablemente vaya mas arriba en jerarquia
	public void setDir(Vector2 v) {
		dir = v;
		
	}
	

	@Override
	public Bullet isShooting() {
		Bullet ret = null;
		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && c.isFiring()){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;
			ret = new PlayerBullet(dano, x, y); //Cambiar para que pueda tener efectos diferentes
		}
		return ret;
		
	}
	
	public void update() {
		dir = c.getDirection();
		super.update();
	}
	
	
	
	
	
	

}
