import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.File;
//w  w w  .j a v  a  2  s .  c  om
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.applet.Main;

import javax.swing.JLabel;
public class Teststart {
  
  public static void main(String[] args) {
	  NGKeyListener NGKL = new NGKeyListener();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.setMaximumSize(new Dimension(1920,720));
        frame.setSize(new Dimension(1920,720));
        frame.addKeyListener(NGKL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BackgroundPane(NGKL));
  
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}

class BackgroundPane extends JPanel {
  

  NGKeyListener keys;
  int xPos, yPos;
  int score = 0;
  int xPosC, yPosC;
  int direction = 1;
  Duck duck1 = new Duck();
  GroundObj objs[] = new GroundObj[100];
  BufferedImage hold = duck1.Right();
  int num =0;

  int loc = 0;
  BufferedImage bg, bg1;
  public BackgroundPane(NGKeyListener key) {
	keys = key;
   
	try {
		  bg1 = ImageIO.read(Main.class.getResource("/images/NEWBACKGROUND200521.png"));
		  bg = new BufferedImage(bg1.getWidth()/3*2, bg1.getHeight()/3*2+200, BufferedImage.TYPE_INT_ARGB);
		  bg.getGraphics().drawImage(bg1.getScaledInstance(bg1.getWidth()/3*2-300,bg.getHeight()/3*2+100, Image.SCALE_SMOOTH), 0, 0 , null);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
    
    
    Timer timer = new Timer(40, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
 /*       yOffset -= yDelta;
        if (yOffset > getHeight()) {
          yOffset = 0;
        }*/
        repaint();
      }
    });
    timer.start();
    xPos = (getWidth() - bg.getWidth()) / 2;
    yPos = 0;
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(bg.getWidth(),bg.getHeight());
  }
  
  @Override
  protected void paintComponent(Graphics g) {
	  
	  this.setSize(new Dimension(1900,1070));
	  super.setSize(new Dimension(1920,1080));
	  super.paintComponent(g);
    
    Graphics2D g2d = (Graphics2D) g.create();
    if(num<100) {
	    if(keys.t == true) {
	    	objs[num] = new GroundObj(1,loc+xPosC);
	    	num++;
	    	score+=15;
	    	keys.t = false;
	    }
	    if(keys.b == true) {
	    	objs[num] = new GroundObj(2,loc+xPosC);
	    	num++;
	    	score+=20;
	    	keys.b = false;
	    }
	    if(keys.p == true) {
	    	objs[num] = new GroundObj(0,loc+xPosC);
	    	num++;
	    	score+=10;
	    	keys.p = false;
	    }
	    if(keys.f == true) {
	    	objs[num] = new GroundObj(5,loc+xPosC);
	    	num++;
	    	score+=2;
	    	keys.f = false;
	    }
  	}
    else {
    	System.out.println("Too many Objects Placed");
    }

    if(keys.left == true && loc>=0) {
    	direction = 2;
    	if(xPosC>=-10) {
        	System.out.println("left " +xPosC + " " + xPos  + " " + loc  + " " + num);
        	xPosC= xPosC-10;
 //       	loc-=20;

    	}
    	if(xPosC<-10 ) {
    		System.out.println("left " +xPosC + " " + xPos  + " " + loc  + " " + num);
    		xPos+=10;
    		loc-=10;
    	}
    	
    }
    if(keys.right == true) {
    	direction = 1;
    	if(xPosC<=1450) {
    		System.out.println("right " + xPosC + " " + xPos + " " + loc + " " + num);
        	xPosC = xPosC+10;
        	loc+=10;
    	}
    	if(xPosC> 1450 && loc<=16920) {
    		System.out.println("left " +xPosC + " " + xPos  + " " + loc  + " " + num);
    		xPos-=10;
    		loc+=10;
    	}
    	
    }
    if(keys.left == false && keys.right == false ) {
    	direction = 0;
    }
    g2d.drawImage(bg, xPos+bg.getWidth()/2, yPos, this);
    for(int i = 0; i<num; i++) {
    	if(objs[i].loc-loc >0 && objs[i].loc-loc <super.getWidth()) {
    		
    		if(objs[i].getType() != 2 && objs[i].getType() != 0 && objs[i].getType() != 1) {
    			g2d.drawImage(objs[i].ned, (objs[i].loc-loc), yPosC+680, this);
    		}
    		else if(objs[i].getType()==2){
    			g2d.drawImage(objs[i].ned, (objs[i].loc-loc), yPosC+805, this);
    		}
    		else if(objs[i].getType() == 0) {
    			g2d.drawImage(objs[i].ned, (objs[i].loc-loc), yPosC+760, this);
    		}
    		else if(objs[i].getType() == 1) {
    			g2d.drawImage(objs[i].ned, (objs[i].loc-loc), yPosC+640, this);
    		}
    	}
    			
    			
    }
    
    g.drawString("Score: " + score, 1600, 950);
    
    if(direction == 1) {
    	hold = duck1.Right();
    	
    }
    else if(direction == 2) {
    	hold = duck1.Left();
    }
    g2d.drawImage(hold, xPosC, yPosC+555, this);
    



    g2d.dispose();
  }
}