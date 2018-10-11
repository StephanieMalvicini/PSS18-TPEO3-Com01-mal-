package Collisions;

import GameObjects.*;

public interface Visitor {

    public void visitEnemy(EnemyCollider e);
    public void visitPlayerBullet(PlayerBulletCollider b);
    public void visitEnemyBullet(EnemyBulletCollider b);
    public void visitPlayer(PlayerCollider p);
    public void visitBarricade(EnemyBarricadeCollider b);


}
