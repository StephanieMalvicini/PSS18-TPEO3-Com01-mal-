package GameObjects;

import Assets.Paths;

import javax.swing.*;

public class EnemyFighterBullet extends EnemyBullet {

    int damage;

    public EnemyFighterBullet(int d, Vector2 u) {
        setUbication(u);
        da�o = d;
        dir = new Vector2(0, 1);
        speed = 6f;
        sprite = new ImageIcon(Paths.ENEMYBULLET1);
    }

    @Override
    public int getDa�o() {
        return damage;
    }
}