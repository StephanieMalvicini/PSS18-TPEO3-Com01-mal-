package Collisions;

import GameObjects.Bullet;
import GameObjects.DestroyableObject;

public class BulletCollider extends Collider{
    public BulletCollider(Bullet o) {
        super(o);



    }

    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }

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
