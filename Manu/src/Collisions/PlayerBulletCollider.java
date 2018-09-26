package Collisions;

import GameObjects.PlayerBullet;

public class PlayerBulletCollider extends Collider {


    public PlayerBulletCollider(PlayerBullet o) {
        super(o);
        v = new PlayerBulletVisitor(o.getDaño());
    }

    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }

    }

    @Override
    public void accept(Visitor v) {
        v.visitPlayerBullet(this);


    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
