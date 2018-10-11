package Collisions;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Player;
import Map.Map;

public class EnemyVisitor implements Visitor {


    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {
        b.getO().destroyMe(Map.getInstance());


    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitPlayer(PlayerCollider p) {

    }

    @Override
    public void visitBarricade(EnemyBarricadeCollider b) {

    }


}
