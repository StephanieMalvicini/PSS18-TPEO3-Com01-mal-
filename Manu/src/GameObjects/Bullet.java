package GameObjects;

import Assets.Configs;
import Map.Map;

import javax.swing.*;

public abstract class Bullet extends Ship{
	protected int daño;
	
	public abstract int getDaño();
	





	//public void update(){}

	public void destroySelf()
	{
		Map.getInstance().destroy(this);
		sprite = new ImageIcon();
		//destroyMe(Map.getInstance());//danger
	}


	@Override
	protected void updatePosition(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();

		y += dir.getY() * speed;
		x += dir.getX() * speed;
		if(x < -12 || x > 1400 || y < -310 || y > Configs.getConfigs().canvasHeight + 520) { //treshold del sprite, adecuar al sprite final
			//destroySelf();
		}

		ubication = new Vector2(x,y);
	}
	
	
	
}
