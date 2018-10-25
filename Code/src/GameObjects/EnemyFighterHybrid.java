package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.Behaviour;
import Controllers.EnemyBehaviour;
import Controllers.EnemyController;
import Controllers.Sinusoidal;
import GUI.ScoreManager;
import Map.Map;

public class EnemyFighterHybrid extends EnemyFighter{

    protected int enemyHealth;

    public EnemyFighterHybrid(){
        Behaviour b = new EnemyBehaviour(new Sinusoidal());
        EnemyController cont = new EnemyController(this,b);
        enemyHealth = 200;
        health = enemyHealth;
        playerSpeed = 0.1f;
        speed = playerSpeed;
        time=0;
        ubication = new Vector2(200,00);
        dir = Vector2.ORIGIN();
        damage = 0;
        kamikazeDamage = 80;
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
            if(health>(enemyHealth/2)) {
                checkFire(map);
            }

            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }

    }


}
