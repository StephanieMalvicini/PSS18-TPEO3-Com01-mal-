package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Controllers.BasicController;
import Controllers.EnemyBehaviour;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.PiercingWeapon;
import GameObjects.Player;
import GameObjects.Weapon;

public class PierceBulletPU extends AbstractPU {



    public PierceBulletPU(){
        controller = new BasicController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.FROZE;
        ubication = dir;
        speed = 1;
        revert = new PiercingReverter();
    }

    @Override
    public void trigger() {
        Weapon w = new PiercingWeapon();
        Player.getInstance().setWeapon(w);

        Timer t = new Timer(5000);
        Revert r = new PieceWeaponRevert(t, revert);
    }
}
