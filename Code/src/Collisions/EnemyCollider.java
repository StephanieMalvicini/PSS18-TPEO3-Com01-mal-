package Collisions;


import GameObjects.Enemy;

public class EnemyCollider extends Collider {

    public EnemyCollider(Enemy o) {
        super(o);
        v = new EnemyVisitor();
    }



    @Override
    public void accept(Visitor v) {
        v.visitEnemy(this);
    }


}
