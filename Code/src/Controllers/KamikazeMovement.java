package Controllers;


import GameObjects.Player;
import GameObjects.Vector2;

public class KamikazeMovement extends MovementPattern {
    protected Vector2 ubication;

    public KamikazeMovement() {
        ubication = Vector2.ORIGIN();
    }
    @Override
    public float getX() {
        return Player.getInstance().getUbication().getX() - ubication.getX();
    }

    @Override
    public float getY() {
        return Player.getInstance().getUbication().getY() - ubication.getY();
    }


    public void setUbication(Vector2 u){ubication = u;}
}
