package GameMaster;

import java.awt.EventQueue;

import GUI.Controller;
import GUI.Window;
import GameObjects.*;
import Map.Mapa;

public class Level {
	
	static Window gui;
	static Mapa map;
	static Player jugador;
	
	public Level() {
		gui = Window.GetWindow();
		map = new Mapa();
		jugador = map.newPlayer();
		gui.addController(new Controller(jugador));
	}
	
	public static void main(String[] args) {
		Level l = new Level();
		gui.Show();
		
		while(true) {
			map.update();
			gui.update();
		}
	}
	
}
	
