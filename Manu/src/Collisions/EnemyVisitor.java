package Collisions;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Player;

public class EnemyVisitor implements Visitor {


    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitBullet(PlayerBulletCollider b) {
        b.getO().destroySelf();


    }

    @Override
    public void visitBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitPlayer(PlayerCollider p) {

    }





}
