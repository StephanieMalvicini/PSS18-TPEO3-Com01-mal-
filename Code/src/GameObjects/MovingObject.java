package GameObjects;

import Assets.Paths;
import GUI.ScoreManager;
import Map.Map;

import javax.swing.*;

public abstract class MovingObject extends DestroyableObject {
	protected float speed;
	protected boolean isFiring;
	protected Vector2 dir;
	
	public void update(Map map) {
		//if(isAlive()) {
			updatePosition(map);
			c.update();
		//}else destroySelf();
	}

	protected abstract void updatePosition(Map m);

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


	@Override
	public void destroySelf() {
		destroyMe(Map.getInstance());

	}

	public void die(){
		health = 0;
	}
}
