package GameMaster;

import GUI.Controller;
import GUI.MyListener;
import GUI.Window;
import GameObjects.*;
import Map.Map;

public class Level {
	
	static Map map;
	static Player jugador;
	private static Window gui;
	
	public Level() {
		jugador = new Player();
		Controller c = new Controller(jugador);
		gui = Window.GetWindow();
		gui.addController(c);
		MyListener m = new MyListener(c);
		gui.addListener(m);
		map = Map.newInstance(gui);
		map.newShooter(240, 800, jugador);
	}

	public void run(){
		gui.Show();

		while(true) {
			map.update();
			gui.update();
		}
	}
}