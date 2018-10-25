package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
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
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;

    public EnemyFighter(){
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
    }


    public void update(Map map) {
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
        sprite = SpriteDepot.EXPLOSION;
        c.destroySelf();
    }


    @Override
    protected void updatePosition(Map map) {
        map.onUpdate(this);
        float x = ubication.getX();
        float y = ubication.getY();


        x += dir.getX() * speed;
        if(x < -150) //treshold del sprite, adecuar al sprite final /TODO: Magic numbersssssssss
            x = Configs.getConfigs().getCanvasWidth() + 150;
        if (x > Configs.getConfigs().getCanvasWidth() + 150)
            x = -150;

        y += dir.getY() * speed;
        if(y < -50 ) //treshold del sprite, adecuar al sprite final
            y = -50;
        if (y > Configs.getConfigs().getCanvasHeight() - 220)
            y = Configs.getConfigs().getCanvasHeight() - 220;  //TODO: Arreglar para que vuelvan a su pos despues de aparecer arriba

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
        health -= d;
       System.out.println(health);
    }


}
