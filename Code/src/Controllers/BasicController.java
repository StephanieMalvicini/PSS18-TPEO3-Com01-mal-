package Controllers;

import GameObjects.MovingObject;
import GameObjects.Vector2;
import GameObjects.Vector2Int;
import Map.Map;

import javax.swing.*;

public  class BasicController extends IController { //TODO: hacer superinterfaz de controladores

    protected MovingObject controlled;

    public BasicController(MovingObject o, Behaviour b){
        controlled = o;
        this.b = b;
        Map.getInstance().add(this);
    }



    private Icon getIcon(Vector2Int v){
        return m[v.getX()+1][v.getY()+1];
        //obtiene el icono asociado de la matriz en funcion del vector
    }



    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
        controlled.setSprite(getIcon(Vector2Int.Implicit(vec.norma())));

    }

    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }


}
