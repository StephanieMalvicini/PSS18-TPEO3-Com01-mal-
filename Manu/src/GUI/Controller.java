package GUI;

import Assets.Paths;
import GameObjects.Player;
import GameObjects.Vector2;

import javax.swing.*;

public class Controller implements IUpdatable{
	
	private Player player;
	private boolean isFiring;
	private Icon r,l,d,u,lu,ru, rd, ld,c;
	Icon[][] m;
	public Controller(Player p) {
		r = new ImageIcon(Paths.NAVEDER);
		l = new ImageIcon(Paths.NAVEIZQ);
		d = new ImageIcon(Paths.NAVED);
		u = new ImageIcon(Paths.NAVEU);
		lu = new ImageIcon(Paths.NAVEIU);
		ru = new ImageIcon(Paths.NAVEDU);
		rd = new ImageIcon(Paths.NAVED);
		ld = new ImageIcon(Paths.NAVED);
		c = new ImageIcon(Paths.NAVE);
		player = p;

		m = new ImageIcon[3][3];
		m[0][0]=lu;
		m[1][0]=u;
		m[2][0]=ru;
		m[0][1]=l;
		m[1][1]=c;
		m[2][1]=r;
		m[0][2]=rd;
		m[1][2]=d;
		m[2][2]=ld;
	}

	private Icon getIcon(Vector2 v){
		return m[v.getX()-1][v.getY()-1];
		//obtiene el icono asociado de la matriz en funcion del vector
	}



	private void move(Vector2 vec){
		player.setDirec(vec);
		player.setSprite(getIcon(vec));
	}

	public void update()
	{
		Vector2 vec = armarVector();

	}

	private Vector2 armarVector()
	{
		var list = MyListener.Instance();
		Vector2 vec = Vector2.Origin();
		if(list.down) vec = vec.sum(Vector2.DOWN());

		if(list.up) vec = vec.sum(Vector2.UP());

		if(list.left) vec = vec.sum(Vector2.LEFT());

		if(list.right) vec = vec.sum(Vector2.RIGHT());

		return vec;
	}



	public boolean isFiring() {
		return isFiring;
	}
	
	public void Fire() {
		player.fire();
	}

	public void endFire() {
		player.stopFiring();
		
	}

	
	

	

	
	

}
