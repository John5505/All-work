

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;



public class Animation extends JFrame{  
       
    Image image;  
    private SpaceShip player1 = new SpaceShip();  
       
    public Animation(String title) {  
        setTitle(title);  
        setSize(400,400);  
        setLocation(100,100);  
        setBackground(Color.black);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        addKeyListener( new KeyList());  
    }  
       
    public void run() {  
           
        while (true) {  
               
            repaint();  
               
        }  
    }  
       
    public void paint(Graphics g) {  
             player1.paint(g);  
             repaint();  
    }  
       
    private class KeyList extends KeyAdapter {  
        public void keyPressed(KeyEvent k) {  
            if (k.getKeyCode() == KeyEvent.VK_LEFT){  
                player1.moveLeft();  
            }  
            if (k.getKeyCode() == KeyEvent.VK_RIGHT){  
                player1.moveRight();  
            }  
        }  
    }  
}  