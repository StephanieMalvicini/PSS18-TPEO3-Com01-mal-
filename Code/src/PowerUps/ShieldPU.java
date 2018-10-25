package PowerUps;

import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Controllers.BasicController;
import Controllers.EnemyBehaviour;
import Controllers.Sinusoidal;
import GameObjects.Player;
import GameObjects.Vector2;

public class ShieldPU extends AbstractPU {
    int power;

    public ShieldPU(Vector2 dir){
        controller = new BasicController(this, new EnemyBehaviour(new Sinusoidal()));
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.FROZE;
        ubication = dir;
        speed = 1;
        power = 50;




    }

    @Override
    public void trigger() {
        Player.getInstance().getShield().add(power);

    }
}
