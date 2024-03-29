package GameMaster;


import Assets.Configs;
import Controllers.*;
import GUI.Menu;
import GUI.MyListener;
import GUI.Window;
import GameObjects.*;
import Map.Map;

import java.util.Random;

public class Level extends Thread{

	protected static Map map;
	protected long nanostowait;
	protected boolean seguir;
	protected PlayerMovementController playerMovController; 

	public Level() {
		MyListener l = MyListener.getInstance();
		Window.GetWindow().addListener(l);
		map = Map.newInstance(Window.GetWindow());
		map.add(Player.getInstance());
		new PlayerFireController();
		playerMovController = new PlayerMovementController(Player.getInstance());
		Random rand = new Random();
		int yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		int xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()/2 - 400) + 200;
		new EnemyBarricade(xBarricade,yBarricade);
		yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()/2-400) + Configs.getConfigs().getCanvasWidth()/2;
		new CommonBarricade(xBarricade,yBarricade);
		map.newLevel();
		seguir = true;
	}
	
	public void esperar() {
		seguir = false; 
	}
	
	public void resumir() {
		seguir = true; 
	}

	public void restart() {
		seguir = false;
		map.restart(); 
		map.add(Player.restart());
		new PlayerFireController();
		playerMovController.setControlled(Player.getInstance());
		Random rand = new Random();
		int yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		int xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()-400) + 200;
		new EnemyBarricade(xBarricade,yBarricade);
		yBarricade = (int) Configs.getConfigs().getCanvasHeight()/2;
		xBarricade = rand.nextInt(Configs.getConfigs().getCanvasWidth()/2-400) + Configs.getConfigs().getCanvasWidth()/2;
		new CommonBarricade(xBarricade,yBarricade);
		map.newLevel();
		seguir = true;
	}


	public void run(){

		Window.GetWindow().show();
		long fpns = 80_000_000_000L;
		long stm;
		long latestmp;
		
		while(true) {
			if(seguir) {
				stm = System.nanoTime();
				map.update();
				Window.GetWindow().update();
				latestmp = System.nanoTime();
				try{
					nanostowait = fpns-(latestmp-stm);

					if(nanostowait>0){
						Thread.sleep(nanostowait/5_00_000_0000L);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Menu.getInstance().update(); 
		}
	}
}