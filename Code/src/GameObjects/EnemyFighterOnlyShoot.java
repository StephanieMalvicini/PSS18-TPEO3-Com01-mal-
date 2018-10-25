package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import GUI.ScoreManager;
import Map.Map;

public class EnemyFighterOnlyShoot extends EnemyFighter {

    public EnemyFighterOnlyShoot(){
        Behaviour b = new EnemyBehaviour(new Sinusoidal());
        EnemyController cont = new EnemyController(this,b);

        health = 200;
        playerSpeed = 0.1f;
        speed = playerSpeed;
        time=0;
        ubication = initialPosition;
        dir = Vector2.ORIGIN();
        damage = 0;
        sprite = SpriteDepot.ENEMY1;
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        isFiring = false;
        gunPosition = -7;
        gunPhaseShift = 40; //TODO actualizar valores al sprite nuevo
        c = new EnemyCollider(this);
        score = 150;
        Map.getInstance().add(cont);
        Map.getInstance().add(this);
    }
    public void update(Map map) {
        if (isAlive()) {
            checkFire(map);
            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }


    }
}
