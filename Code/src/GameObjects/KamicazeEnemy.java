package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import Map.Map;

public class KamicazeEnemy extends Enemy {

    public KamicazeEnemy(){
        Behaviour b = new EnemyBehaviour(new Lemniscata());
        
        KamikazeController cont = new KamikazeController(this,b);

        health = 200;
        playerSpeed = 20.0f;
        speed = playerSpeed;
        time=0;
        ubication = new Vector2(200,200);
        dir = Vector2.ORIGIN();
        damage = 0;
        kamikazeDamage = 150;
        sprite = SpriteDepot.ENEMY1;
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        isFiring = false;
        gunPosition = -7;
        gunPhaseShift = 40; //TODO actualizar valores al sprite nuevo
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150;
        Map.getInstance().add(cont);
        Map.getInstance().add(this);
    }

    public void update(Map map) {
        if (isAlive()) {
            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }
    }
}
