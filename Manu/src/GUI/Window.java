package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window {

    private static Window ventana;
    private Controller controller;
    private JFrame wind;
    private JPanel panel;
    private static Container container; // static wtf
    
    public static Window GetWindow()  {
        if(ventana==null){
           ventana = new Window();
        }
        return ventana;
    }
    private Window() {
        wind = new JFrame();
        wind.setSize(new Dimension(600,960));
        wind.setVisible(false);
        wind.setBackground(Color.BLACK);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setLayout(null);
        container = wind.getContentPane();
        container.setBackground(Color.BLACK);
        container.setBounds(0,0,0,0);
	 wind.addKeyListener(new KeyListener() {
	            @Override
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
	            }
	            @Override
	            public void keyReleased(KeyEvent e) {
	       	     if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT){
	       		     controller.end();
		            }
	            }
	            
	            
	            @Override public void keyTyped(KeyEvent e) {}
	        });

    }
    public void update(){
       wind.repaint(); 
    }

    public void Show() {
        wind.setVisible(true);
    }
    
    public static JLabel newPlayer(int x, int y) {
		
	JLabel player = new JLabel("");
	player.setIcon(new ImageIcon("C:\\Users\\Manu\\Desktop\\project\\nave.png"));
	player.setBounds(x, y, 182, 200);
	container.add(player);
	
	return player;
    }
    
    public void addController(Controller cont) {
	    controller = cont;
    }

    
    
    
    
    
    
}