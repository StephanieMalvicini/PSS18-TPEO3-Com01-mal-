package Collisions;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Player;

public interface Visitor {

    public void visitEnemy(EnemyCollider e);
    public void visitPlayerBullet(PlayerBulletCollider b);
    public void visitEnemyBullet(EnemyBulletCollider b);
    public void visitPlayer(PlayerCollider p);
    //public void visitBarricade();


}
