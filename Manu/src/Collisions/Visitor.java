package Collisions;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Player;

public interface Visitor {

    public void visitEnemy(EnemyCollider e);
   // public void visitBullet(BulletCollider b);
    public void visitBullet(PlayerBulletCollider b);
    public void visitBullet(EnemyBulletCollider b);
    public void visitPlayer(PlayerCollider p);
    //public void visitBarricade();


}
