package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import GUI.ScoreManager;
import Map.Map;


public abstract class Enemy extends Ship {

    protected int score;
    protected float playerSpeed;
    protected int damage;
    protected int attackSpeed;
    protected boolean loaded;
    protected long time;
    protected int gunPosition;
    protected static Vector2 initialPosition = new Vector2(400,00);
    protected static int fighterAttackSpeed = 300;
    protected float gunPhaseShift;

    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        c.destroySelf();
    }

    public void damage(float d){
        health -= d;
        System.out.println(health);
    }


}
