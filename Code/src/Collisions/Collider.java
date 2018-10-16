package Collisions;

import GameObjects.DestroyableObject;

import java.util.Collection;

public  abstract class Collider implements Visitable {

    protected final ColliderMaster c;
    protected float x, y, ex, ey;
    protected DestroyableObject  o;
    protected Visitor v;
    protected float dx;
    protected float dy;

    protected Collection<Collider> collisions;


    public Collider(DestroyableObject o) {
        this.o = o;
        dx = o.getWidth() / 2;
        dy = o.getHeight() / 2;
        x = o.getX() - dx;
        y = o.getY() - dy;
        ex = x + o.getWidth(); // TODO: hacer atributo
        ey = y + o.getHeight(); // TODO: hacer atributo
        c = ColliderMaster.getInstance();

        c.addCollider(this);



    }

    public void update(){
        x = o.getX() - dx;
        y = o.getY() - dy;
        ex = x + o.getWidth(); // TODO: hacer atributo
        ey = y + o.getHeight();
        scanCollisions();
        solveCollision();



    }

    protected void solveCollision() {
        for(Collider c : collisions){
            c.accept(v);
        }

    }



    protected void scanCollisions() {
        collisions = c.findCollisions(this);

    }

    public boolean intersects(Collider co) {

        if(x <= co.getEx() && ex >= co.getX()  && y < co.getEy() && ey >= co.getY()) {

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

    public void destroySelf(){
        ColliderMaster.getInstance().removeCollider(this);
    }
}
