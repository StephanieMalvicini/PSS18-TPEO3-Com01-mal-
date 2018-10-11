package Collisions;


import GameObjects.Enemy;

public class EnemyCollider extends Collider {

    public EnemyCollider(Enemy o) {
        super(o);
        v = new EnemyVisitor();
    }

    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitEnemy(this);
    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
