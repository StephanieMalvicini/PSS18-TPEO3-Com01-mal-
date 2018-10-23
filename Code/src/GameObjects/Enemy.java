package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import Map.Map;

import javax.swing.*;


public abstract class Enemy extends Ship{

    protected int score;

    @Override
    protected void updatePosition(Map map) {
        map.onUpdate(this);
        float x = ubication.getX();
        float y = ubication.getY();


        x += dir.getX() * speed;
        if(x < -12) //treshold del sprite, adecuar al sprite final /TODO: resolver el updatePosition de Ship (qué enemigos lo redefinen?)
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
}
