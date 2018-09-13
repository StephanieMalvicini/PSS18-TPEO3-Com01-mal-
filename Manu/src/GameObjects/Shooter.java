package GameObjects;

public abstract class Shooter extends Ship{//deberia ser clase abstracta para atributo da�o

	public abstract Bullet isShooting();
	
	protected int dano;
}
