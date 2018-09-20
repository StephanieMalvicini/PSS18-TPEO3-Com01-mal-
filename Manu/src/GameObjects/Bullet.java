package GameObjects;

import Assets.Configs;
import GUI.Window;
import Map.Map;

public abstract class Bullet extends Ship{
	protected int daño;
	
	public abstract int getDaño();
	






	public void destroy()
	{
		Map.getInstance().destroy(this);
	}


	@Override
	protected void updatePosition(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();

		y += dir.getY() * speed;
		x += dir.getX() * speed;
		if(x < -12 || x > 1400 || y < -310 || y > Configs.getConfigs().canvasHeight + 520) //treshold del sprite, adecuar al sprite final
			destroy();


		ubication = new Vector2(x,y);
	}
	
	
	
}
