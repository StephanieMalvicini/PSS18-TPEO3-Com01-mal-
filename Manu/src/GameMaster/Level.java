package GameMaster;

import Controllers.Controller;
import Controllers.EnemyBehaviour;
import Controllers.EnemyController;
import GUI.MyListener;
import GUI.Window;
import GameObjects.*;
import Map.Map;

public class Level {

	static float FPS = 60;

	static Map map;
	static Player jugador;
	private static Window gui;

	public Level() {
		jugador = new Player();
		Controller c = new Controller(jugador);
		gui = Window.GetWindow();
		Enemy e = new EnemyFighter();
		EnemyBehaviour b = new EnemyBehaviour();
		EnemyController ec = new EnemyController(e,b);


		MyListener m = MyListener.Instance();
		gui.addListener(m);
		map = Map.newInstance(gui);
		map.addController(c);
		map.add(jugador);
		map.addController(ec);
		map.add(e);
	}

	public void run(){
		gui.Show();


		while(true) {
			map.update();
			gui.update();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}