package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyBarricadeCollider;
import Map.Map;

public class EnemyBarricade extends Barricade {

    public EnemyBarricade(int x, int y){
        ubication = new Vector2(x,y);
        health = 700;
        sprite = SpriteDepot.ENEMYBARRICADE;
        height = sprite.getIconHeight();
        width = sprite.getIconWidth();
        c = new EnemyBarricadeCollider(this);

    }

    @Override
    public void destroySelf() {
        destroyMe(Map.getInstance());
        sprite = null;


    }

    @Override
    public void update(Map map) {
        c.update();
        if(!isAlive()){
            destroySelf();
        }

    }

    @Override
    public void destroyMe(Map map) {
        map.destroy(this);

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
