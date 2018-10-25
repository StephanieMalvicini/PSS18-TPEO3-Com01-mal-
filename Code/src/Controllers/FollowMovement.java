package Controllers;

import GameObjects.MovingObject;
import GameObjects.Player;

public class FollowMovement extends MovementPattern {
    protected MovingObject movingObject;

    public FollowMovement() {
        movingObject = null;
    }
    @Override
    public float getX() {
        float xShip = movingObject.getUbication().getX();
        return Player.getInstance().getUbication().getX() - xShip;
    }

    @Override
    public float getY() {
        float yShip = movingObject.getUbication().getY();
        return Player.getInstance().getUbication().getY() - yShip;
    }

    public void setMovingObject(MovingObject s){
        movingObject = s;
    }
}
