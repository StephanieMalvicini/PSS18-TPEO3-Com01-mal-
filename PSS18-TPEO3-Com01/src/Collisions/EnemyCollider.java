package Collisions;


import GameObjects.Enemy;

public class EnemyCollider extends Collider {
    float da�o;

    public EnemyCollider(Enemy o, float d) {
        super(o);
        da�o = d;
        v = new EnemyVisitor(da�o);
    }



    @Override
    public void accept(Visitor v) {
        v.visitEnemy(this);
    }


}
