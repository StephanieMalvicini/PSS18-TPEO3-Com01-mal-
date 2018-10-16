package GameObjects;

import Map.Map;

public class MissilWeapon extends Weapon {

    public MissilWeapon(int dmg){
        damage = (int)(dmg*5);
        gunPosition = -7;
        gunPhaseShift = 40;
    }

    public void shoot(){
        Vector2 ubBullet = Player.getInstance().getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
        Bullet b = new MissilBullet(damage,ubBullet);
        Map.getInstance().add(b);
        gunPhaseShift *= -1;
    }
}
