package GameObjects;

import Assets.Configs;
import Map.Map;
import Map.SuperMap;

import javax.swing.*;

public class Ship extends DestroyableObject {
	protected float speed;
	protected boolean isFiring;
	protected Vector2 dir;
	
	public void update(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();

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

		ubication = new Vector2(x,y);
	}

	public void destroyMe(Map map) {
		map.destroy(this);
	}

	public void setDirec(Vector2 vect) {
		dir = (vect);

	}

	public void setSprite(Icon s){
		sprite = s;
	}

	public void fire(){
		isFiring = true;

	}

	public void stopFiring(){
		isFiring = false;
	}


}
