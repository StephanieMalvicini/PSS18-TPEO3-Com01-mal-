package Collisions;

import GameObjects.Bullet;
import GameObjects.EnemyBullet;

public class EnemyBulletCollider extends BulletCollider {

    public EnemyBulletCollider(EnemyBullet o) {
        super(o);
        v = new EnemyBulletVisitor(o.getDaño());
    }
}
