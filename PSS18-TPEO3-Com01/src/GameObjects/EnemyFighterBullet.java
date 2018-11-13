package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyBulletCollider;
import Map.Map;

import javax.swing.*;

public class EnemyFighterBullet extends EnemyBullet {

    protected float da�o;

    public EnemyFighterBullet(float d, Vector2 u) {
        setUbication(u);
        da�o = d;
        dir = new Vector2(0, 1);
        speed = 18.5f;
        sprite = SpriteDepot.ENEMYBULLET1;
        c = new EnemyBulletCollider(this);
        Map.getInstance().add(this);
    }

    @Override
    public float getDa�o() {
        return da�o;
    }

    public void update(Map map){
        super.update(map);
        updatePosition(map);
    }
}
