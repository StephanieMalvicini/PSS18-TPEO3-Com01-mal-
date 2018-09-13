package Map;

import GameObjects.*;

import javax.swing.*;

public class ShooterGraphiObject extends ObjetoGrafico {

    public ShooterGraphiObject(Shooter o, JLabel j){
        super(o,j);
    }

    public Bullet isShooting(){
        return ((Shooter) object).isShooting();
    }

}

