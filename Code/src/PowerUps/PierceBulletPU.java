package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Controllers.BasicController;
import Controllers.EnemyBehaviour;
import Controllers.PowerUpController;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.PiercingWeapon;
import GameObjects.Player;
import GameObjects.Vector2;
import GameObjects.Weapon;
import Map.Map;

public class PierceBulletPU extends AbstractPU {



    public PierceBulletPU(Vector2 v){
        controller = new PowerUpController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        health = 1;
        sprite = SpriteDepot.PEARCE;
        ubication = v;
        speed = 1;
        c = new PowerUpCollider(this);
        revert = new PiercingReverter();
        Map.getInstance().add(this);

    }

    @Override
    public void trigger() {
        Weapon w = new PiercingWeapon();
        Player.getInstance().setWeapon(w);

        Timer t = new Timer(5000);
        Revert r = new PierceWeaponRevert(t, revert);
    }
}
