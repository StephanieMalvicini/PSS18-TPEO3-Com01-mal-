package GameObjects;

import Assets.Configs;
import Map.Map;

import javax.swing.*;

public abstract class Bullet extends Ship{
	protected int daño;
	protected int offset;
	
	public abstract int getDaño();



	public void destroyMe(Map map) {
		map.destroy(this);
		sprite = new ImageIcon();
		offset = 200;
	}



	//public void update(){}

	public void destroySelf()
	{
		Map.getInstance().destroy(this);
		sprite = new ImageIcon();
		c.destroySelf();
	}


	@Override
	protected void updatePosition(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();


		y += dir.getY() * speed;
		x += dir.getX() * speed;
		if(x < 0 - offset  || x > Configs.getConfigs().canvasWidth + offset || y < 0 - offset || y > Configs.getConfigs().canvasHeight + offset) {
			destroySelf();
		}

		ubication = new Vector2(x,y);
	}
	
	
	
}
