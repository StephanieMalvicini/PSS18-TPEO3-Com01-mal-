package Collisions;

import GameObjects.GameObject;
import GameObjects.Player;

public class PlayerCollider extends Collider{

    public PlayerCollider(Player o) {
        super(o);
    }

    @Override
    protected void solveCollision() {

    }

    @Override
    public void accept(Visitor v) {

    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
