package Controllers;

import GameObjects.Vector2;


public class EnemyBehaviour extends Behaviour {


    int i = 0;

    float ampx = 3f;
    float ampy = 2.5f;

    private float speedEnemy = 1;

    private float lastT = 0;
    private float radioGral = 0.5f;
    private float lerping = 400f;
    private boolean fire;

    public EnemyBehaviour(){
        direc = Vector2.LEFT();
        actualizaSenso();
    }

    private void actualizaSenso() {
        lastT = System.nanoTime()/1_000_000_000f - lastT;
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }

    @Override
    public boolean fire() {
        double r = Math.random();
        if (r<0.10 ) return true;
        else return false;
    }


    private void updateDir(){
        actualizaSenso();
        i++;
        float t = i/lerping;


        var x = (float) ((ampx * Math.sqrt(2)*(-Math.sin(t)*((Math.sin(t) * Math.sin(t)) + 1)- Math.sin(2*t) * Math.cos(t)))/(((Math.sin(t) * Math.sin(t)) + 1) * ((Math.sin(t) * Math.sin(t)) + 1)));
                //(float) ((Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1)) ;


        var y =  (float) ((ampy * (3 * Math.cos(2 * t) - 1))/(((Math.sqrt(2) * (( Math.sin(t) * Math.sin(t)) + 1) * (( Math.sin(t) * Math.sin(t)) + 1))))) ;
                //(float) (((ampx)* (2 * Math.cos(2 * t) * ((Math.sin(t) * Math.sin(t)) * + 1))-(Math.sin(2 *t) * Math.sin(2 * t)) ) / (Math.sqrt(2) * (((Math.sin(t) * Math.sin(t)) + 1) * ((Math.sin(t) * Math.sin(t)) + 1)))) ;
                //(float) ((Math.sin(t) * Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1));



        direc = (new Vector2(x,y));
        direc = direc.prod(radioGral);

    }



}
