package Collisions;

import GameObjects.Bullet;
import GameObjects.PlayerBullet;

public class PlayerBulletCollider extends BulletCollider {


    public PlayerBulletCollider(PlayerBullet o) {
        super(o);
        v = new PlayerBulletVisitor(o.getDaño());
    }
}
