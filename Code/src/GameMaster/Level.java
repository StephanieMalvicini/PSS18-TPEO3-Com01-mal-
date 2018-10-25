package GameMaster;


import Assets.Configs;
import Collisions.ColliderMaster;
import Controllers.*;
import GUI.MyListener;
import GUI.ScoreManager;
import GUI.Window;
import GUI.listenerTemp;
import GameObjects.*;
import Map.Map;

import java.util.Random;

public class Level extends Thread{

	protected static Map map;
	protected long nanostowait;
	protected boolean seguir;

	public Level() {

		Controller c = new Controller(Player.getInstance());
		//Enemy e = new EnemyFighter();
		//FollowBehaviour b = new FollowBehaviour();
		//EnemyController ec = new EnemyController(e,b);
		//b.setMovingObject(ec.getShip());

		Random rand = new Random();
		int yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		int xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()-400) + 200;
		EnemyBarricade eb = new EnemyBarricade(xBarricade,yBarricade);

        Enemy ee = new EnemyFighter();
        Behaviour bb = new EnemyBehaviour(new Sinusoidal());
        EnemyController ecc = new EnemyController(ee,bb);



		MyListener l = MyListener.Instance();
		listenerTemp t = listenerTemp.getInstance();
		Window.GetWindow().addListener(t);
		Window.GetWindow().addListener(l);
		map = Map.newInstance(Window.GetWindow());
		map.addController(c);
		map.add(Player.getInstance());
		//map.addController(ec);
		//map.add(e);
		map.add(ScoreManager.getInstance());
		map.add(eb);


		seguir = true;
        map.add(ee);
        map.addController(ecc);
	}




	public void run(){

		Window.GetWindow().Show();
		long fpns = 80_000_000_000L;
		long stm = System.nanoTime();
		long latestmp = System.nanoTime();

		while(seguir) {
			stm = System.nanoTime();
			map.update();
			Window.GetWindow().update();
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