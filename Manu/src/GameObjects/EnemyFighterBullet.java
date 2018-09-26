package GameObjects;

import Assets.Paths;
import Collisions.EnemyBulletCollider;

import javax.swing.*;

public class EnemyFighterBullet extends EnemyBullet {

    int daño;

    public EnemyFighterBullet(int d, Vector2 u) {
        setUbication(u);
        daño = d;
        dir = new Vector2(0, 1);
        speed = 5.5f;
        sprite = new ImageIcon(Paths.ENEMYBULLET1);
        c = new EnemyBulletCollider(this);
    }

    @Override
    public int getDaño() {
        return daño;
    }
}
