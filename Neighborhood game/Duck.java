import java.awt.Dimension;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import sun.applet.Main;

import java.awt.Image;

public class Duck {
	public BufferedImage dk1, dk2, dkl1, dkl2, dkl3, dk3;
	int step = 0;
	public Duck(){
	  try {
		dk1 = ImageIO.read(Main.class.getResource("/images/1 t-rex bones.png"));
		dk2 = ImageIO.read(Main.class.getResource("/images/2 t-rex bones.png"));
		dkl1 = ImageIO.read(Main.class.getResource("/images/21 t-rex bones.png"));
		dkl2 = ImageIO.read(Main.class.getResource("/images/22 t-rex bones.png"));
		dkl3 = ImageIO.read(Main.class.getResource("/images/23 t-rex bones.png"));
		dk3 = ImageIO.read(Main.class.getResource("/images/3 t-rex bones.png"));
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	}
	public BufferedImage Right() {
		step++;
		if(step%16 <=5) {
			return dk1;
		}
		else if(step%16 <=10) {
			return dk2;
		}
		else if(step%16 <=15) {
			return dk3;
		}
		return dk1;
	}
	public BufferedImage Left() {
		step++;
		if(step%16 <=5) {
			return dkl1;
		}
		else if(step%16 <=10) {
			return dkl2;
		}
		else if(step%16 <=15) {
			return dkl3;
		}
		return dkl1;
	}

}
