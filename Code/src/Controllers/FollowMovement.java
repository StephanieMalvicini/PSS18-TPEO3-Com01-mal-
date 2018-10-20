package Controllers;

import GameObjects.Player;
import GameObjects.Ship;
public class FollowMovement extends MovementPattern {
    protected Ship ship;

    public FollowMovement() {
        ship = null;
    }
    @Override
    public float getX() {
        float xShip = ship.getUbication().getX();
        return Player.getInstance().getUbication().getX() - xShip;
    }

    @Override
    public float getY() {
        float yShip = ship.getUbication().getY();
        return Player.getInstance().getUbication().getY() - yShip;
    }

    public void setShip(Ship s){
        ship = s;
    }
}
