package PowerUps;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.FrozeVisitor;
import Collisions.PowerUpCollider;
import Collisions.Visitor;
import Controllers.BasicController;
import Controllers.EnemyBehaviour;
import Controllers.Sinusoidal;
import GameObjects.Formation;
import GameObjects.Vector2;
import Map.Map;

public class FrozePU extends AbstractPU {
    Visitor v;


    public FrozePU(Vector2 dir){
        controller = new BasicController(this, new EnemyBehaviour(new Sinusoidal())); //TODO: crear movimientos de los power up
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.FROZE;
        ubication = dir;
        speed = 1;
        v = new FrozeVisitor();

        

    }

    @Override
    public void trigger() {
        Formation.getInstance().affect(v); //TODO: crear nueva instancia de visitor

    }


}
