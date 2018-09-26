package Collisions;

import GameObjects.DestroyableObject;
import GameObjects.GameObject;

import java.util.Collection;

public  abstract class Collider implements Visitable {

    protected final ColliderMaster c;
    protected float x, y, ex, ey;
    DestroyableObject  o;
    protected Visitor v;

    Collection<Collider> collisions;


    public Collider(DestroyableObject o) {
        this.o = o;
        x = o.getX();
        y = o.getY();
        ex = x - o.getSprite().getIconWidth(); // TODO: hacer atributo
        ey = y + o.getSprite().getIconHeight(); // TODO: hacer atributo
        c = ColliderMaster.getInstance();
        c.addCollider(this);


    }

    public void update(){
        x = o.getX();
        y = o.getY();
        ex = x + o.getSprite().getIconWidth();
        ey = y + o.getSprite().getIconHeight();



    }

    protected abstract void solveCollision();



    protected void scanCollisions() {
        collisions = c.findCollisions(this);

    }

    public boolean intersects(Collider co) {

        if(x <= co.getEx() && ex >= co.getX()  && y <= co.getEy() && ey >= co.getY()) {

            return true;
        }
        return false;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getEx() {
        return ex;
    }

    public float getEy() {
        return ey;
    }

    public DestroyableObject getO() {
        return o;
    }
}
