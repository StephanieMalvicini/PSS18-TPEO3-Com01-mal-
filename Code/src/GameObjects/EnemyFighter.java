package GameObjects;

import Map.Map;
import PowerUps.AbstractPU;
import PowerUps.FrozePU;
import PowerUps.PierceBulletPU;

import javax.swing.*;

public abstract class EnemyFighter extends Enemy {

<<<<<<< HEAD
    protected float playerSpeed;
    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(400,00);
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;



    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        new PierceBulletPU(ubication);
        c.destroySelf();
        Map.getInstance().destroy(this);
        sprite = new ImageIcon();

    }




=======
>>>>>>> 7b9a750ec5ccfa5fb68cd5c53ebdb5193f4ecbe8
    protected void checkFire(Map map) {

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
<<<<<<< HEAD

    public void damage(float d){
        health -= d;

    }


=======
>>>>>>> 7b9a750ec5ccfa5fb68cd5c53ebdb5193f4ecbe8
}
