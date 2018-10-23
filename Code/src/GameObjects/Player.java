package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.PlayerCollider;
import Map.*;
import sun.security.krb5.Config;

import javax.swing.*;

public class Player extends  Shooter{
	protected final float playerSpeed = 8.6f;
	protected int damage;
	protected int attackSpeed;
	protected boolean loaded;
	protected long time;
	protected Weapon weapon;


	protected static Vector2 initialPosition = new Vector2(218,680);
	protected int playerAttackSpeed = 500;

	private static Player instance = null;

	public static Player getInstance() {
		if (instance == null)
			instance = new Player();
		return instance;
	}

	private Player() {
		health = 200;
		speed = playerSpeed;
		time=0;
		ubication = initialPosition;
		dir = Vector2.ORIGIN();
		damage = 60;
		sprite = SpriteDepot.NAVE;
		attackSpeed = playerAttackSpeed;
		loaded = true;
		isFiring = false;
		c = new PlayerCollider(this);

		weapon = new PlayerWeapon(damage);
	}




	
	public void update(Map map) {

		if (health > 0) {
			checkFire(map);
			updatePosition(map);
			super.update(map);
		} else {
			destroySelf();
			destroyMe(map);
			sprite = new ImageIcon();
			c.destroySelf();
		}

	}

	private void checkFire(Map map) {

		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && isFiring) {
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;

			weapon.shoot();

		}


	}

	@Override
	protected void updatePosition(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();


		x += dir.getX() * speed;
		if(x < -50)
			x = -50;                      //TODO: Arreglar el choque con bordes con las longitudes de los sprites
		if (x > Configs.getConfigs().getCanvasWidth() -250)
			x = Configs.getConfigs().getCanvasWidth() -250;

		y += dir.getY() * speed;
		if(y < -50)
			y = -50;
		if (y > Configs.getConfigs().getCanvasHeight() - 180)
			y = Configs.getConfigs().getCanvasHeight() - 180;

		ubication = new Vector2(x,y);
	}
}
	
	
	
	
	
	


