package GameObjects;

import Assets.Paths;
import Controllers.EnemyController;
import Map.Map;

import javax.swing.*;

public class EnemyFighter extends Enemy {


    protected final float playerSpeed;
    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(500,00);
    protected static int fighterDamage = 20;
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;

    public EnemyFighter(){
        health = 200;
        playerSpeed = 0.5f;
        speed = playerSpeed;
        time=0;
        ubication = initialPosition;
        dir = Vector2.ORIGIN();
        damage = fighterDamage;
        sprite = new ImageIcon(Paths.ENEMY1);
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        isFiring = false;
        gunPosition = -7;
        gunPhaseShift = 40;
    }


    public void update(Map map) {
        if (time < System.currentTimeMillis())
            loaded = true;
        if (loaded && isFiring){
            loaded = false;
            time = System.currentTimeMillis() + attackSpeed;


            Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
            Bullet b = new EnemyFighterBullet(damage,ubBullet);
            Map.getInstance().add(b);
            gunPhaseShift *= -1;

        }

        super.update(map);


    }
}
