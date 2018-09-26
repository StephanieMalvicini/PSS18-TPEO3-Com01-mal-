package Collisions;

import GameObjects.Bullet;
import GameObjects.EnemyBullet;

public class EnemyBulletCollider extends Collider {

    public EnemyBulletCollider(EnemyBullet o) {
        super(o);
        v = new EnemyBulletVisitor(o.getDa�o());
    }

    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }

    }

    @Override
    public void accept(Visitor v) {
        v.visitEnemyBullet(this);


    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
