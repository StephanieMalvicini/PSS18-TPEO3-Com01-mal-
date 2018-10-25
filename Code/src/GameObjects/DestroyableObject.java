package GameObjects;

import Collisions.Collider;

public abstract class DestroyableObject extends GameObject{
	protected int health;
	protected Collider c;
	
	public int getHealth() {
		return health;
	}



	public boolean isAlive() {
		return health > 0;
	}

	public abstract void destroySelf(); // TODO: refactorear detruccion de entidades

	public void damage(float d){
		health -= d;

	}

	public Collider getCollider(){
		return c;
	}

	
}
