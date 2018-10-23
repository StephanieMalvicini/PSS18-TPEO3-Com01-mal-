package Assets;

import java.awt.*;

public final class Configs {

    protected int canvasWidth = 1200;
    protected int canvasHeight = 700;
    protected int panelWidth = 300;
    protected Dimension windowsSize = new Dimension(canvasWidth+ panelWidth, canvasHeight);

    private static Configs instance;
    public static Configs getConfigs(){
        if (instance == null){
            instance = new Configs();
        }
        return instance;
    }


    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public Dimension getWindowsSize() {
        return windowsSize;
    }
}