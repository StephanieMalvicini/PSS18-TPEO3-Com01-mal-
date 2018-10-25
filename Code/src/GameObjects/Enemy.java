package GameObjects;


public abstract class Enemy extends Ship {

    protected int score;
    protected float kamikazeDamage;


    public float getKamikazeDamage() {
        return kamikazeDamage;
    }
}
