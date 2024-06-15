package Snakegame;

import javax.swing.JFrame;

public class SnakeGame extends JFrame {
    SnakeGame(){
        super("SnakeGame");
       add(new board()); 
        pack();

        setVisible(true);
        // setLocation(500,500);
        setSize(300,300);
        setLocationRelativeTo(null);
        

    }

public static void main(String[] args) {
    new SnakeGame();
    
}
}
