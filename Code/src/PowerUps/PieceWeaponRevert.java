package PowerUps;

import java.util.concurrent.Callable;

public class PieceWeaponRevert extends Revert {
    public PieceWeaponRevert(Callable<Boolean> condition, Runnable action) {
        super(condition, action);
    }
}
