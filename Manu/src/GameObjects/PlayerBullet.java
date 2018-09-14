package GameObjects;

import Assets.Paths;

public class PlayerBullet extends Bullet {

	
	public PlayerBullet(int d, int x, int y) {
		this.x = x;
		this.y = y;
		daño = d;
		dir = new Vector2(0, -1);
		speed = 2;
		sprite = Paths.LASER;
	}
	
	
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
