package Controllers;

import GameObjects.MovingObject;
import GameObjects.Vector2;
import GameObjects.Vector2Int;
import Map.Map;
import PowerUps.AbstractPU;
import PowerUps.FrozePU;

import javax.swing.*;

public class PowerUpController extends IController {

    AbstractPU controlled;

    public PowerUpController(AbstractPU o, Behaviour b){
        controlled = o;
        this.b = b;
        Map.getInstance().add(this);
    }







    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);


    }

    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }
}
