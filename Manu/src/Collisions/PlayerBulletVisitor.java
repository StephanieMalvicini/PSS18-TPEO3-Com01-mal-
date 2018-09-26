package Collisions;

public class PlayerBulletVisitor implements Visitor {

    int d;

    public PlayerBulletVisitor(int d){
        this.d = d;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {
            e.getO().damage(d);

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }



    @Override
    public void visitPlayer(PlayerCollider p) {

    }
}
