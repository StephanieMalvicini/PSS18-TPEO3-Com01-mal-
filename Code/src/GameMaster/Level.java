package GameMaster;


import Collisions.ColliderMaster;
import Controllers.Controller;
import Controllers.EnemyBehaviour;
import Controllers.EnemyController;
import GUI.MyListener;
import GUI.ScoreManager;
import GUI.Window;
import GUI.listenerTemp;
import GameObjects.*;
import Map.Map;

public class Level extends Thread{

	static float FPS = 60;

	static Map map;
	private static Window gui;

	public Level() {
		ColliderMaster co = ColliderMaster.getInstance();
		Controller c = new Controller(Player.getInstance());
		gui = Window.GetWindow();
		Enemy e = new EnemyFighter();
		EnemyBehaviour b = new EnemyBehaviour();
		EnemyController ec = new EnemyController(e,b);
		EnemyBarricade eb = new EnemyBarricade(90, 300);


		MyListener l = MyListener.Instance();
		listenerTemp t = listenerTemp.getInstance();
		gui.addListener(t);
		gui.addListener(l);
		map = Map.newInstance(gui);
		map.addController(c);
		map.add(Player.getInstance());
		map.addController(ec);
		map.add(e);
		map.add(ScoreManager.getInstance());
		map.add(eb);
	}

	long nanostowait;


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