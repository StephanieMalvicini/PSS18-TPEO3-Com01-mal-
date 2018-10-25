package PowerUps;

import Assets.Configs;
import Controllers.IController;
import GameObjects.MovingObject;
import GameObjects.Vector2;
import Map.Map;

public abstract class AbstractPU extends MovingObject {

        protected IController controller;

        public abstract void trigger();

        protected void updatePosition(Map map) {
                float x = ubication.getX();
                float y = ubication.getY();



                y += dir.getY() * speed;
                if(y < -50 || y > Configs.getConfigs().getCanvasHeight() - 220)
                        destroySelf();

                x += dir.getX() * speed;
                if(x < -150)
                        x = Configs.getConfigs().getCanvasWidth() + 150;
                if (x > Configs.getConfigs().getCanvasWidth() + 150)
                        x = -150;




                ubication = new Vector2(x,y);
        }



}
