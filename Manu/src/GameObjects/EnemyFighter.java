package GameObjects;

import Assets.Configs;
import Assets.Paths;
import Collisions.EnemyCollider;
import Controllers.EnemyController;
import GUI.ScoreManager;
import Map.Map;

import javax.swing.*;

public class EnemyFighter extends Enemy {


    protected float playerSpeed;
    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(400,00);
    protected static int fighterDamage = 20;
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;

    public EnemyFighter(){
        health = 200;
        playerSpeed = 71.9f;
        speed = playerSpeed;
        time=0;
        ubication = initialPosition;
        dir = Vector2.ORIGIN();
        damage = 50;
        sprite = new ImageIcon(Paths.ENEMY1);
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        isFiring = false;
        gunPosition = -7;
        gunPhaseShift = 40;
        c = new EnemyCollider(this);
        score = 150;
    }


    public void update(Map map) {
        //System.out.println(health);
        if (health > 0) {
            checkFire(map);
            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }


    }

    public void destroySelf(){
        ScoreManager.getInstance().modificarScore(score);
        sprite = new ImageIcon(Paths.EXPLOSION);
        c.destroySelf();
    }


    @Override
    protected void updatePosition(Map map) {
        map.onUpdate(this);
        float x = ubication.getX();
        float y = ubication.getY();


        x += dir.getX() * speed;
        if(x < -12) //treshold del sprite, adecuar al sprite final /TODO: Magic numbersssssssss
            x = -12;
        if (x > 1000)
            x = 1000;

        y += dir.getY() * speed;
        if(y < 0) //treshold del sprite, adecuar al sprite final
            y = 0;
        if (y > Configs.getConfigs().canvasHeight - 220)
            y = Configs.getConfigs().canvasHeight - 220;

        ubication = new Vector2(x,y);
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
        System.out.println(d);
        //System.out.println(d);
        health -= d;
       System.out.println(health);
    }


}
