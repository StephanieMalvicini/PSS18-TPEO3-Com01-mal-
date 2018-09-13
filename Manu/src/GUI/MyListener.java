package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener implements KeyListener {

    private Controller controller;

    public MyListener(Controller c){
        controller = c;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            controller.startRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            controller.startLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            controller.startUp();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            controller.startDown();
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.Fire();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
            controller.endMovement();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.endFire();
        }
    }


    @Override public void keyTyped(KeyEvent e) {}
}

