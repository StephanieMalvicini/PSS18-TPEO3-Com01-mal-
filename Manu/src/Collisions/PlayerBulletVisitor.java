package Collisions;

public class PlayerBulletVisitor implements Visitor {

    int d;

    public PlayerBulletVisitor(int d){
        this.d = d;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {
            e.getO().damage(d);
            System.out.println("choco");
    }

    @Override
    public void visitBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitBullet(EnemyBulletCollider b) {

    }



    @Override
    public void visitPlayer(PlayerCollider p) {

    }
}
