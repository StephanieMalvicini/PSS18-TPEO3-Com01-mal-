package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener implements KeyListener {


    private static MyListener instance;
    public static MyListener Instance()
    {
        if(instance==null)
            instance = new MyListener();
        return  instance;
    }


    public boolean up,down,left,right,fire;//TODO: encapsular

    private MyListener()
    {
        right=false;
        down=false;
        up=false;
        left=false;
        fire = false;
    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right=true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
                left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
                up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
                down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_CONTROL){
            fire=true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

            right=false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){

            left = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            up = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down = false;
        }


        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_CONTROL){
            fire = false;
        }
    }


    @Override public void keyTyped(KeyEvent e) {}
}

