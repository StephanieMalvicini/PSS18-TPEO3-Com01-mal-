package Controllers;

import GameObjects.Ship;
import GameObjects.Vector2;
public class FollowBehaviour extends Behaviour {
    protected FollowMovement followm;

    public FollowBehaviour(){
        direc = Vector2.LEFT();
        followm = new FollowMovement();
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }

    @Override
    public boolean fire() {
        double r = Math.random();
        if (r<0.58 )
            return true;
        else
            return false;
    }

    private void updateDir(){
        float x = followm.getX();
        //(float) ((Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1)) ;

        float y =  followm.getY();
        //(float) ((Math.sin(t) * Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1));
        Vector2 vec = new Vector2(x,y);
        direc = (vec);
    }

    public void setShip(Ship s){
        followm.setShip(s);
    }
}
