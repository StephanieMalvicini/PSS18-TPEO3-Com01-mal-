package Collisions;

public class EnemyBulletVisitor implements Visitor {
    int d;

    public EnemyBulletVisitor(int d){
        this.d = d;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {

        //System.out.println("choco");
    }

    @Override
    public void visitBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitBullet(EnemyBulletCollider b) {

    }



    @Override
    public void visitPlayer(PlayerCollider p) {
        p.getO().damage(d);

    }
}
