package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyBarricadeCollider;
import Map.Map;

public class EnemyBarricade extends Barricade {

    public EnemyBarricade(int x, int y){
        ubication = new Vector2(x,y);
        health = 700;
        sprite = SpriteDepot.ENEMYBARRICADE;
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


}
