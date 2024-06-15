package Snakegame;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*; 
public class board extends JPanel {
    public static int dots;
    board(){
        setBackground(Color.black);
        setFocusable(true);
        loadImages();
        initGame();
    }
public void loadImages(){
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/apple.png"));
    ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/dot.png"));
    ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/head.png"));

}    
public void initGame(){
    dots=3;
    for(int i=0;i<dots;i++){

    }
}
    }


