package GUI;

import java.awt.*;
import java.awt.event.KeyListener;

import javax.swing.*;

import Assets.Configs;
import Assets.Paths;
import Controllers.Controller;
import GameObjects.Vector2;
import GameObjects.Vector2Int;
import Map.Map;

public class Window {

    private static Window instance;

    private JFrame frame;
    private Container gameContainer;
    private Container UIcontainer;

    


    
    public static Window GetWindow()  {
        if(instance ==null){
           instance = new Window();
        }
        return instance;
    }
    private Window() {
		frame = new JFrame();
		Container c = frame.getContentPane();
		frame.setLayout(null);
		frame.setBounds(0,0, Configs.getConfigs().getCanvasWidth(),Configs.getConfigs().getCanvasHeight());
		c.setLayout(null);
		frame.setLocationRelativeTo(null);

		Icon ic = new ImageIcon(Paths.BACKGROUND);
		gameContainer = new JLabel(ic);
		UIcontainer = new JPanel();
		UIcontainer.setLayout(null);

		UIcontainer.add(ScoreManager.getInstance().getScore());
		UIcontainer.add(ScoreManager.getInstance().getVidaJugador());
		ScoreManager.getInstance().getScore().setBounds(20,200,100,100);

		ScoreManager.getInstance().getVidaJugador().setBounds(20,400,100,100);
		gameContainer.setBounds(Configs.getConfigs().getPanelWidth(),0,Configs.getConfigs().getCanvasWidth(),Configs.getConfigs().getCanvasHeight());
		UIcontainer.setBounds(0,0,Configs.getConfigs().getPanelWidth(),Configs.getConfigs().getCanvasHeight());

		frame.setVisible(true);
		gameContainer.setLayout(null);

		c.add(gameContainer);
		c.add(UIcontainer);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setSize(Configs.getConfigs().getWindowsSize());


		frame.setSize(Configs.getConfigs().getWindowsSize());
		frame.setResizable(false);


    }
    public void update(){
       frame.repaint();
    }

    public void Show() {
        frame.setVisible(true);
    }
    


    public  JLabel add(Vector2 ubication, Icon s) {
	    	Vector2Int	v = Vector2Int.Implicit(ubication);
		JLabel object = new JLabel(s);

		object.setBounds(v.getX(),v.getY(), s.getIconWidth(),s.getIconHeight());
		gameContainer.add(object);
		return object;
    }
    



    public void addListener(KeyListener k) { frame.addKeyListener(k); }


	public void removeComponent(JComponent model)
	{
		frame.remove(model);
	}
}