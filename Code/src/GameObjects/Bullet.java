package GameObjects;

import Assets.Configs;
import Map.Map;

import javax.swing.*;

public abstract class Bullet extends MovingObject {
	protected int daño;
	
	public int getDaño(){return daño;}



	public void destroyMe(Map map) {
		map.destroy(this);
		sprite = new ImageIcon();
	}



	//public void update(){}

	public void destroySelf()
	{
		c.destroySelf();
		Map.getInstance().destroy(this);
		sprite = new ImageIcon();
		//destroyMe(Map.getInstance());//danger
	}


	@Override
	protected void updatePosition(Map map) {
		float x = ubication.getX();
		float y = ubication.getY();

		y += dir.getY() * speed;
		x += dir.getX() * speed;
		if(x < -12 || x > 1400 || y < -310 || y > Configs.getConfigs().getCanvasHeight() + 520) { //treshold del sprite, adecuar al sprite final
			//destroySelf();  /TODO: adecuar al sprite
		}

		ubication = new Vector2(x,y);
	}
	
	
	
}
