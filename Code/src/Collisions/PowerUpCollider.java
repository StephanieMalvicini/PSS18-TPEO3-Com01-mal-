package Collisions;

import GameObjects.DestroyableObject;
import PowerUps.AbstractPU;

public class PowerUpCollider extends Collider {

    public PowerUpCollider(AbstractPU o) {
        super(o);
        v = new PowerUpVisitor();
    }

    @Override
    public void accept(Visitor v) {

    }

    public void trigger(){
        ((AbstractPU) o).trigger();
    }
}
