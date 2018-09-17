package Controllers;

import GameObjects.Vector2;

import java.util.Random;


public class EnemyBehaviour extends Behaviour {


    int i = 0;

    float ampx = 5;
    float ampy = 2;

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
        if (r<0.15 ) return true;
        else return false;
    }


    private void updateDir(){
        actualizaSenso();
        i++;
        float t = i/lerping;


        var x = (float) (Math.sin(t)) * ampx;
        var y = (float) (Math.cos(t) *ampy);



        direc = (new Vector2(x,y));
        direc = direc.prod(radioGral);

    }



}
