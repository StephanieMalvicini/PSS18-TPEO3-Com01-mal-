package Collisions;

import GameObjects.PiercingBullet;

public class PiercingBulletCollider extends Collider {
    public PiercingBulletCollider(PiercingBullet o) {
        super(o);
        v = new PiercingBulletVisitor(o.getDaño());
    }

    @Override
    public void accept(Visitor v) {
        v.visitPiercingBulet(this);
    }
}
