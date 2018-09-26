package GameObjects;

import Assets.Configs;
import Assets.Paths;
import Collisions.BulletCollider;
import Collisions.PlayerBulletCollider;
import Map.Map;

import javax.swing.*;

public class PlayerBullet extends Bullet {

	
	public PlayerBullet(int d,Vector2 ubication) {
		setUbication(ubication);
		daño = d;
		dir = new Vector2(0, -1);
		speed = 6.3f;
		sprite = new ImageIcon(Paths.LASER);
		health = 1;
		c = new PlayerBulletCollider(this);
	}
	
	
	public int getDaño()
	{
		return daño;
	}




}
