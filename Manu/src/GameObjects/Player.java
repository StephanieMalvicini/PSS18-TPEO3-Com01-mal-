package GameObjects;

import Assets.Paths;
import Map.*;

import javax.swing.*;

public class Player extends  Shooter{
	protected final float playerSpeed = 0.8f;
	protected int damage;
	protected int attackSpeed;
	protected boolean loaded;
	protected long time;
	protected int gunPosition;

	// --------- alternar balas -----
	protected float gunPhaseShift;
	//-------------------------


	protected static Vector2 initialPosition = new Vector2(218,680);
	protected static int playerDamage = 20;
	protected static int playerAttackSpeed = 300;


	public Player() {
		health = 200;
		speed = playerSpeed;
		time=0;
		ubication = initialPosition;
		dir = Vector2.ORIGIN();
		damage = playerDamage;
		sprite = new ImageIcon(Paths.NAVE);
		attackSpeed = playerAttackSpeed;
		loaded = true;
		isFiring = false;
		gunPosition = -7;
		gunPhaseShift = 40;
	}

	//probablemente vaya mas arriba en jerarquia


	
	public void update(Map map) {
		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && isFiring){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;


			Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
			Bullet b = new PlayerBullet(damage,ubBullet);
			Map.getInstance().add(b);
			gunPhaseShift *= -1;

		}

		super.update(map);


	}
	
	
	
	
	
	

}
