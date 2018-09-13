package GameMaster;

import java.awt.EventQueue;

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
		Controller c = new Controller();
		jugador = new Player(c);
		gui = Window.GetWindow();
		gui.addController(c);
		//gui.addListener(new MyListener(c));
		map = new Map(gui);
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
	
