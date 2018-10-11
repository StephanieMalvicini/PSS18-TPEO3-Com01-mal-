package Collisions;

public class PlayerVisitor implements Visitor {
    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {
        b.getO().destroySelf();

    }

    @Override
    public void visitPlayer(PlayerCollider p) {

    }

    @Override
    public void visitBarricade(EnemyBarricadeCollider b) {
    }
}
