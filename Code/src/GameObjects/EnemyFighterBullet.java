package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyBulletCollider;

import javax.swing.*;

public class EnemyFighterBullet extends EnemyBullet {

    int daño;

    public EnemyFighterBullet(int d, Vector2 u) {
        setUbication(u);
        daño = d;
        dir = new Vector2(0, 1);
        speed = 18.5f;
        sprite = SpriteDepot.ENEMYBULLET1;
        height = sprite.getIconHeight();
        width = sprite.getIconWidth();
        c = new EnemyBulletCollider(this);

    }

    @Override
    public int getDaño() {
        return daño;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }
}
