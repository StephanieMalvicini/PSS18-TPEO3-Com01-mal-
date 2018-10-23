package GameMaster;


import Collisions.ColliderMaster;
import Controllers.*;
import GUI.MyListener;
import GUI.ScoreManager;
import GUI.Window;
import GUI.listenerTemp;
import GameObjects.*;
import Map.Map;

public class Level extends Thread{

	static Map map;
	private static Window gui;

	public Level() {
		Controller c = new Controller(Player.getInstance());
		gui = Window.GetWindow();
		//Enemy e = new EnemyFighter();
		//FollowBehaviour b = new FollowBehaviour();
		//EnemyController ec = new EnemyController(e,b);
		//b.setShip(ec.getShip());
		EnemyBarricade eb = new EnemyBarricade();

        Enemy ee = new EnemyFighter();
        Behaviour bb = new EnemyBehaviour(new Sinusoidal());
        EnemyController ecc = new EnemyController(ee,bb);



		MyListener l = MyListener.Instance();
		listenerTemp t = listenerTemp.getInstance();
		gui.addListener(t);
		gui.addListener(l);
		map = Map.newInstance(gui);
		map.addController(c);
		map.add(Player.getInstance());
		//map.addController(ec);
		//map.add(e);
		map.add(ScoreManager.getInstance());
		map.add(eb);



        map.add(ee);
        map.addController(ecc);
	}

	protected long nanostowait;


	public void run(){

		gui.Show();
		long fpns = 80_000_000_000L;
		long stm = System.nanoTime();
		long latestmp = System.nanoTime();

		while(true) {
			stm = System.nanoTime();
			map.update();
			gui.update();
			latestmp = System.nanoTime();
			try
			{
				nanostowait = fpns-(latestmp-stm);

				if(nanostowait>0)
				{
					Thread.sleep(nanostowait/5_00_000_0000L);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}