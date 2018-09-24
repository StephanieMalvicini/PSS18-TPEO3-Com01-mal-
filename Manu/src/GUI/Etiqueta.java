package GUI;

import GameObjects.Player;
import javax.swing.*;
public class Etiqueta {

    private JLabel label;
    private int contador;

    public Etiqueta(){
        contador = 0;
        label = new JLabel();
        label.setText("Score: "+contador);
    }

    public Etiqueta(int n){
        contador = n;
        label = new JLabel();
        label.setText("Vida: "+contador);
    }

    public void modificar(int n){
        contador+=n;
        label.setText("Score: "+contador);
        System.out.println("Score: "+contador);
    }


    public JLabel getJLabel(){
        return label;
    }
}
