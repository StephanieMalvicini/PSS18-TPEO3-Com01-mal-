package PowerUps;

import GameObjects.Player;
import GameObjects.PlayerWeapon;
import GameObjects.Weapon;

public class PiercingReverter implements Runnable {
    @Override
    public void run() {
        Weapon w = new PlayerWeapon(Player.getInstance().getDamage());
        Player.getInstance().setWeapon(w);


    }
}
