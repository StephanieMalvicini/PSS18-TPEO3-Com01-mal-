package Controllers;

import GameObjects.Ship;
import GameObjects.Vector2;

public abstract class ShooterController extends IController {

    protected Ship controlled;

    protected abstract void checkShoot();


    public void Fire() {
        controlled.fire();
    }

    public void endFire() {
        controlled.stopFiring();

    }

    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
        //controlled.setSprite(getIcon(Vector2Int.Implicit(vec.norma())));

    }


}
