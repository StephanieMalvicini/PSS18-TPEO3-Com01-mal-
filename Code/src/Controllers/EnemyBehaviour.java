package Controllers;

import GameObjects.Vector2;


public class EnemyBehaviour extends Behaviour {







    private float radioGral = 0.26f;


    public EnemyBehaviour(){
        direc = Vector2.LEFT();
        m = new Sinusoidal();
    }



    public Vector2 getDir(){
        updateDir();
        return direc;
    }

    @Override
    public boolean fire() {
        double r = Math.random();
        if (r<0.58 ) return true;
        else return false;
    }


    private void updateDir(){




        float x = m.getX();
                //(float) ((Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1)) ;


        float y =  m.getY();
                //(float) ((Math.sin(t) * Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1));

        direc = (new Vector2(x,y));

        direc = direc.prod(radioGral);

    }



}
