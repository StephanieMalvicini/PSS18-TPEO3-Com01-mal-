package Collisions;

import GameObjects.EnemyBarricade;

public class EnemyBarricadeCollider extends Collider {

    public EnemyBarricadeCollider(EnemyBarricade c){
        super(c);
        v = new EnemyBarricadeVisitor();
    }
    @Override
    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }

    }

    @Override
    public void accept(Visitor v) {
        v.visitBarricade(this);
    }

    public void update(){
        super.update();
        scanCollisions();
        solveCollision();


    }
}
