package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import GUI.ScoreManager;
import Map.Map;

public class EnemyFighter extends Enemy {


    protected float playerSpeed;
    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(400,00);
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;

    public EnemyFighter(){
        Behaviour b = new EnemyBehaviour(new Sinusoidal());
        EnemyController cont = new EnemyController(this,b);

        health = 200;
        playerSpeed = 20.0f;
        speed = playerSpeed;
        time=0;
        ubication = initialPosition;
        dir = Vector2.ORIGIN();
        damage = 30;
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

    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        c.destroySelf();
    }




    private void checkFire(Map map) {

        if (time < System.currentTimeMillis())
            loaded = true;
        if (loaded && isFiring){
            loaded = false;
            time = System.currentTimeMillis() + attackSpeed;


            Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
            Bullet b = new EnemyFighterBullet(damage,ubBullet);
            map.add(b);
            gunPhaseShift *= -1;

        }

    }

   public void damage(float d){
        health -= d;
       System.out.println(health);
    }


}
