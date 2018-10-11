package Collisions;

import GameObjects.GameObject;
import GameObjects.Player;

public class PlayerCollider extends Collider{

    public PlayerCollider(Player o) {
        super(o);
        v = new PlayerVisitor();
    }

    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitPlayer(this);

    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
