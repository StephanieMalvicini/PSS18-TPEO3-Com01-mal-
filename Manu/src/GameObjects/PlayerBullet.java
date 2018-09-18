package GameObjects;

import Assets.Paths;

import javax.swing.*;

public class PlayerBullet extends Bullet {

	
	public PlayerBullet(int d,Vector2 ubication) {
		setUbication(ubication);
		daño = d;
		dir = new Vector2(0, -1);
		speed = 0.3f;
		sprite = new ImageIcon(Paths.LASER);
	}
	
	
	public int getDaño()
	{
		return 0;
	}

}
