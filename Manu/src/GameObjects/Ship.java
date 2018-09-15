package GameObjects;

import Assets.Configs;

public class Ship extends DestroyableObject {
	protected int speed;
	
	protected Vector2 dir;
	
	public void update() {
		x += dir.getX() * speed;
		if(x < -12) //treshold del sprite, adecuar al sprite final
			x = -12;
		if (x > 1000)
			x = 1000;
		
		y += dir.getY() * speed;
		if(y < 0) //treshold del sprite, adecuar al sprite final
			y = 0;
		if (y > Configs.getConfigs().canvasHeight - 220)
			y = Configs.getConfigs().canvasHeight - 220;
	}
	
}
