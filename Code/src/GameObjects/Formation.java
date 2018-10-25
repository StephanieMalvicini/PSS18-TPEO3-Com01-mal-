package GameObjects;

import Collisions.PowerUpVisitor;
import Collisions.Visitor;
import Controllers.Behaviour;
import Controllers.EnemyBehaviour;
import Controllers.EnemyController;
import Controllers.Sinusoidal;
import Map.Map;

import java.util.Collection;
import java.util.LinkedList;

public class Formation extends Enemy {

    protected Collection<EnemyController> enemies;

   private static Formation instance;
   private Formation(){
       Behaviour b = new EnemyBehaviour(new Sinusoidal());
       EnemyController c = new EnemyController(this, b);
       Map.getInstance().add(c);
       enemies = new LinkedList<>();

   }

   public static Formation getInstance(){
       if (instance == null){
           instance = new Formation();
       }
       return instance;
   }


   public void affect(Visitor v){
       for(EnemyController c : enemies){
           c.getShip().getCollider().accept(v);
       }
   }

}
