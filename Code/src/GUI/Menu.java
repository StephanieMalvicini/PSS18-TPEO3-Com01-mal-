package GUI;

import Assets.Configs;
import Assets.Paths;
import GameMaster.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    protected static Menu instance;
    protected JButton bInicio;
    protected JFrame frame;
    protected Container gameContainer,UIcontainer;
    public static Menu getInstance(){
        if (instance==null)
            instance = new Menu();
        return instance;
    }

    private Menu(){

        frame = new JFrame();
        Container c = frame.getContentPane();
        Icon ic = new ImageIcon(Paths.MENUIMAGE);
        frame.setContentPane(new JLabel(ic));

        frame.setLayout(null);
        frame.setBounds(0,0, Configs.getConfigs().getCanvasWidth(),Configs.getConfigs().getCanvasHeight());
        c.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setSize(Configs.getConfigs().getWindowsSize());


        frame.setSize(Configs.getConfigs().getWindowsSize());
        frame.setResizable(false);




        bInicio = new JButton(new ImageIcon(Paths.STARTBUTTON));
        bInicio.setVisible(true);
        bInicio.setBounds(300,300,264,149);
        frame.getContentPane().add(bInicio);
        bInicio.addActionListener(new oyenteInicio());
    }

    public void update(){
        frame.repaint();
    }

    public void showFrame(){
        frame.setVisible(true);
    }

    public void addPanels(Container gameContainer,Container UIcontainer){
        this.gameContainer = gameContainer;
        this.UIcontainer = UIcontainer;
        frame.getContentPane().add(gameContainer);
        frame.getContentPane().add(UIcontainer);
        frame.requestFocus();
    }

    public JFrame getFrame(){
        return frame;
    }


    public void newLevel(){

        Thread l = new Level();
        l.start();
    }

    public void perder(){
        JOptionPane.showMessageDialog(null,"Mission Failed!","You have been defeated!",JOptionPane.INFORMATION_MESSAGE);

       // Icon ic = new ImageIcon(Paths.LOSTSCREEN); //TODO: No funciona esta parte, es poner una imagen de partida perdida. Despues habría que volver al menu
       // gameContainer = new JLabel(ic);
    }



    private class oyenteInicio implements ActionListener{
        public void actionPerformed(ActionEvent e){
            bInicio.setVisible(false);
            newLevel();
        }
    }



}
