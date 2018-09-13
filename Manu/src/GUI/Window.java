package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.*;

import Assets.Configs;
import Assets.Paths;

public class Window {

    private static Window instance;
    private Controller controller;
    private JFrame frame;
    private JPanel panel;
    private Container gameContainer;
    private Container UIcontainer;
    //private Collection<JLabel> objetos;

    


    
    public static Window GetWindow()  {
        if(instance ==null){
           instance = new Window();
        }
        return instance;
    }
    private Window() {
		frame = new JFrame();
		//frame.setContentPane(new JLabel(new ImageIcon(Paths.BACKGROUND)));
		Container c = frame.getContentPane();
		frame.setLayout(null);
		frame.setBounds(0,0, Configs.getConfigs().canvasWidth,Configs.getConfigs().canvasHeight);
		c.setLayout(null);

		Icon ic = new ImageIcon(Paths.BACKGROUND);
		gameContainer = new JLabel(ic);
		UIcontainer = new JLabel(new ImageIcon(Paths.OTROFONDO));



		gameContainer.setBounds(Configs.getConfigs().panelWidth,0,Configs.getConfigs().canvasWidth,Configs.getConfigs().canvasHeight);
		UIcontainer.setBounds(0,0,Configs.getConfigs().panelWidth,Configs.getConfigs().canvasHeight);

		frame.setVisible(true);
		gameContainer.setLayout(null);
		UIcontainer.setLayout(null);

		c.add(gameContainer);
		c.add(UIcontainer);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setSize(Configs.getConfigs().windowsSize);


		frame.setSize(Configs.getConfigs().windowsSize);
		frame.setResizable(false);
		frame.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    controller.startRight();
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    controller.startLeft();
                }
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    controller.startUp();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    controller.startDown();
                }

                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    controller.Fire();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
                    controller.endMovement();
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    controller.endFire();
                }
            }

            @Override public void keyTyped(KeyEvent e) {}
        });



    }
    public void update(){
       frame.repaint();
    }

    public void Show() {
        frame.setVisible(true);
    }
    
    public  JLabel newObject(int x, int y, URL s) {
		
	JLabel object = new JLabel("");
	object.setIcon(new ImageIcon(s));
	object.setBounds(x, y, 182, 200);
	gameContainer.add(object);
	//objetos.add(object);
	
	return object;
    }
    
    public void addController(Controller cont) { controller = cont; }


    //public void addListener(KeyListener k) { frame.addKeyListener(k); }

  
    
    

    
    
    
    
    
    
}