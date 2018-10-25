package GameObjects;

import Assets.SpriteDepot;
import Collisions.PiercingBulletCollider;
import Collisions.PlayerBulletCollider;

public class PiercingBullet extends Bullet {

    public PiercingBullet(float damage, Vector2 ubBullet) {
        setUbication(ubication);
        daño = damage;
        dir = new Vector2(0, -1);
        speed = 6.3f;
        sprite = SpriteDepot.LASER;
        health = 1;
        c = new PiercingBulletCollider(this);
    }
}
