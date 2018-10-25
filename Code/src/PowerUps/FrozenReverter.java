package PowerUps;

import Collisions.Visitor;
import GameObjects.Formation;

public class FrozenReverter implements Runnable {

    Visitor v;

    public FrozenReverter(){
        Visitor v = new UnfrozeVisitor();
    }

    @Override
    public void run() {
        Formation.getInstance().affect(v);
    }
}
