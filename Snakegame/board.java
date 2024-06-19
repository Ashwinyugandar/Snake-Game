package Snakegame;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


 

public class board extends JPanel implements ActionListener {
    public static int dots;
    public Image apple;
    public Image dot;
    public Image head;

    private final int ALL_DOTS=900;
    private final int DOT_SIZE=10;
    private final int RANDOM_POSITION=29;

    private int apple_a;
    private int apple_b;

    private final int x[]=new int[ALL_DOTS];
    private final int y[]=new int[ALL_DOTS];

    private Timer timer;

    private boolean leftDirection=false;
    private boolean rightDirection=true;
    private boolean upDirection=false;
    private boolean downDirection=false;
    
    public boolean inGame=true;

    board(){
        addKeyListener(new Tadapter());
        setBackground(Color.black);
        setPreferredSize(new Dimension(300,300));
        setFocusable(true);
        loadImages();
        initGame();
    }
public void loadImages(){
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/apple.png"));
    apple=i1.getImage();
    ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/dot.png"));
    dot=i2.getImage();
    ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("Snakegame/icons/head.png"));
    head=i3.getImage();

}    
public void initGame(){
    dots=3;
    for(int i=0;i<dots;i++){
    y[i]=50;
    x[i]=50-i*DOT_SIZE;
    }
    locateApple();

    timer = new Timer(140,this);
    timer.start();
   
}
public void locateApple(){
   int r = (int)(Math.random()*RANDOM_POSITION);
   apple_a=r*DOT_SIZE;
   r=(int)(Math.random()*RANDOM_POSITION);
   apple_b=r*DOT_SIZE;
}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
}
public void gameOver(Graphics g){
    String msg="Game Over!";
    int score=dots-3;
    String msgScore="Score : " + score;
    Font font = new Font("SAN_SERIF",Font.BOLD,16);
    FontMetrics metrices=getFontMetrics(font);
    g.setColor(Color.WHITE);
    g.setFont(font);
    g.drawString(msg,(300-metrices.stringWidth(msg))/2 ,300/2 );
    g.drawString(msgScore,((300-metrices.stringWidth(msg))/2),(300/2)+50 );
   
}
public void draw(Graphics g){
  if (inGame) {
     g.drawImage(apple, apple_a, apple_b,this);
    for(int i=0;i<dots;i++){
        if(i==0){
            g.drawImage(head, x[i], y[i], this);
        }
        else{
            g.drawImage(dot, x[i], y[i], this);
        }
    }
    Toolkit.getDefaultToolkit().sync();
  }else{
    gameOver(g);
  }
   
}
public void checkApple(){
    if((x[0] == apple_a)&&(y[0]==apple_b)){
        dots++;
        locateApple();
    }
}
public void move(){
    for(int i=dots; i>0;i--){
        x[i]=x[i-1];
        y[i]=y[i-1];
    }

        if (leftDirection) {
            x[0]=x[0]-DOT_SIZE;
        }
        if (rightDirection) {
            x[0]=x[0]+DOT_SIZE;   
        }
        if (upDirection) {
            y[0]=y[0]-DOT_SIZE;   
        }
        if (downDirection) {
            y[0]=y[0]+DOT_SIZE;   
        }
    
}
public void checkCollision(){
     for(int i=dots;i>0;i--){
        if((x[0]==x[i])&&(y[0]==y[i])){
            inGame=false;
        }
     }
     if (y[0]>=300) {
        inGame=false;
     }
     if (x[0]>=300) {
        inGame=false;
     }
     if (y[0]<0) {
        inGame=false;
     }
     if (x[0]<0) {
        inGame=false;
     }
     if(!inGame){
        timer.stop();
     }
}
public void actionPerformed(ActionEvent a) {
  if (inGame) {
     checkApple();
  checkCollision();
    move();
  }
   repaint();
}
public class Tadapter extends KeyAdapter{
@Override 
public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();

    if(key == KeyEvent.VK_LEFT && (!rightDirection)){
        leftDirection=true;
        upDirection=false;
        downDirection=false;
    }
    
    if(key == KeyEvent.VK_UP && (!downDirection)){
        leftDirection=false;
        upDirection=true;
        rightDirection=false;
    }
    
    if(key == KeyEvent.VK_DOWN && (!upDirection)){
        leftDirection=false;
        rightDirection=false;
        downDirection=true;
    }
    
    if(key == KeyEvent.VK_RIGHT && (!leftDirection)){
        rightDirection=true;
        upDirection=false;
        downDirection=false;
    }
}
}
    }


