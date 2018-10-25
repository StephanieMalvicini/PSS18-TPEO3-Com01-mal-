package PowerUps;

import Assets.SpriteDepot;
import Collisions.*;
import Controllers.BasicController;
import Controllers.EnemyBehaviour;
import Controllers.Sinusoidal;
import GameMaster.Timer;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

import java.util.concurrent.Callable;

public class KamikazeShieldPU extends AbstractPU {


    public KamikazeShieldPU(Vector2 dir){
        controller = new BasicController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.FROZE;
        ubication = dir;
        speed = 1;
        revert = new KamikazeReverter();
        time = 5000;




    }

    @Override
    public void trigger() {
        Collider c = new KamikazeShieldCollider(Player.getInstance());
        Player.getInstance().setCollider(c);

        Timer t = new Timer(time);
        Revert r = new RevertKS(t, revert);

    }

    @Override
    public void destroySelf() {
        revert.run();
    }
}
