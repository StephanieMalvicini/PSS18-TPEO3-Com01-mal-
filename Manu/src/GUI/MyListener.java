package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener implements KeyListener {

    private Controller controller;
    boolean up,down,left,right;

    public MyListener(Controller c){
        controller = c;
        right=false;
        down=false;
        up=false;
        left=false;
    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (down) controller.startDownRight();
            else
                if (up)
                {controller.startUpRight();
                }
                else controller.startRight();

            right=true;

        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (down) controller.startDownLeft();
            else
                if (up) controller.startUpleft();
                else controller.startLeft();

                left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if (right) controller.startUpRight();
            else
                if (left) controller.startUpleft();
                else controller.startUp();
                up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if (right)
                controller.startDownRight();
            else
                if (left)
                    controller.startDownLeft();
                else
                    controller.startDown();

                down = true;
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.Fire();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (down) controller.startDown();
            else
            if (up) controller.startUpRight();
            else controller.endMovement();

            right=false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if (down) controller.startDown();
            else
            if (up) controller.startUp();
            else controller.endMovement();

            left = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            if (right) controller.startRight();
            else
            if (left) controller.startLeft();
            else controller.endMovement();
            up = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if (right) controller.startRight();
            else
            if (left) controller.startLeft();
            else controller.endMovement();

            down = false;
        }



        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            controller.endFire();
        }
    }


    @Override public void keyTyped(KeyEvent e) {}
}

