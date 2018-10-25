package GameMaster;


import Assets.Configs;
import Controllers.*;
import GUI.MyListener;
import GUI.ScoreManager;
import GUI.Window;
import GameObjects.*;
import Map.Map;

import java.util.Random;

public class Level extends Thread{

	protected static Map map;
	protected long nanostowait;
	protected boolean seguir;

	public Level() {

		MyListener l = MyListener.Instance();
		Window.GetWindow().addListener(l);
		map = Map.newInstance(Window.GetWindow());
		map.add(Player.getInstance());
		//map.addController(ec);
		//map.add(e);
		map.add(ScoreManager.getInstance());


		//Enemy e = new EnemyFighterOnlyShoot();
		//FollowBehaviour b = new FollowBehaviour();
		//EnemyController ec = new EnemyController(e,b);
		//b.setMovingObject(ec.getShip());
		PlayerController c = new PlayerController(Player.getInstance());
		Random rand = new Random();
		int yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		int xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()-400) + 200;
		EnemyBarricade eb = new EnemyBarricade(xBarricade,yBarricade);

        Enemy ee = new EnemyFighterOnlyShoot();
        EnemyFighterHybrid hibrido = new EnemyFighterHybrid();
		KamicazeEnemy kamikaze = new KamicazeEnemy();

		seguir = true;

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