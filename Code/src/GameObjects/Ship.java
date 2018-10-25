package GameObjects;

import Assets.Configs;
import Map.Map;

public abstract class Ship extends MovingObject {


    public void fire() {
        isFiring = true;

    }

    public void stopFiring() {
        isFiring = false;
    }






    @Override
    protected void updatePosition(Map map) {
        float x = ubication.getX();
        float y = ubication.getY();


        x += dir.getX() * speed;
        if(x < -150) //treshold del sprite, adecuar al sprite final /TODO: Magic numbersssssssss
            x = Configs.getConfigs().getCanvasWidth() + 150;
        if (x > Configs.getConfigs().getCanvasWidth() + 150)
            x = -150;

        y += dir.getY() * speed;
        if(y < -50 ) //treshold del sprite, adecuar al sprite final
            y = -50;
        if (y > Configs.getConfigs().getCanvasHeight() - 220)
            y = Configs.getConfigs().getCanvasHeight() - 220;  //TODO: Arreglar para que vuelvan a su pos despues de aparecer arriba

        ubication = new Vector2(x,y);
    }
}

   /** protected void updatePosition(Map map) {
        float x = ubication.getX();
        float y = ubication.getY();


        x += dir.getX() * speed;
        if(x < -12) //treshold del sprite, adecuar al sprite final /TODO: resolver el updatePosition de MovingObject (qué enemigos lo redefinen?)
            x = -12;
        if (x > 1000)
            x = 1000;

        y += dir.getY() * speed;
        if(y < 0) //treshold del sprite, adecuar al sprite final
            y = Configs.getConfigs().getCanvasHeight() - 220;
        if (y > Configs.getConfigs().getCanvasHeight() - 220)
            y = 0;

        ubication = new Vector2(x,y);
    }
**/
