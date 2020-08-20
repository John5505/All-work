

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class SpaceShip extends JFrame{  
    Image image;  
    private int yMove = 370;  
    private int xMove = 200;  
       
    public SpaceShip() {  
           
        image = getToolkit().getImage("SpaceShip.JPG");  
    }  
       
    public void paint(Graphics g) {  
        g.drawImage(image, xMove, yMove, this);  
    }  
       
    public void moveLeft() {  
        xMove = xMove--;  
    }  
       
    public void moveRight() {  
        xMove = xMove++;  
    }  
       
    public void moveReset(int value) {  
        xMove = value;  
    }  
}