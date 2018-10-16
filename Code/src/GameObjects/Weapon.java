package GameObjects;

public abstract class Weapon {
    protected int gunPosition;
    protected float gunPhaseShift;
    protected int damage;

    protected abstract void shoot();
}
