package GameObjects;

import Map.Map;

public abstract class EnemyFighter extends Enemy {

    protected void checkFire(Map map) {

        if (time < System.currentTimeMillis())
            loaded = true;
        if (loaded && isFiring){
            loaded = false;
            time = System.currentTimeMillis() + attackSpeed;


            Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
            System.out.println("Bala creada");
            Bullet b = new EnemyFighterBullet(damage,ubBullet);
            map.add(b);
            gunPhaseShift *= -1;

        }

    }
}
