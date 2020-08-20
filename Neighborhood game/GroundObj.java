import java.awt.Dimension;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import sun.applet.Main;

public class GroundObj {
	public BufferedImage ned;
	public int loc;
	int ftp = 0;
	int Type;
	public GroundObj(int type, int lc) {
		Type = type;
		loc = lc;
			try {
				switch(Type) {
					case 0:
						ned = ImageIO.read(Main.class.getResource("/images/BUSH.png"));
						break;
					case 1:
						ned = ImageIO.read(Main.class.getResource("/images/TREE.png"));
						break;
					case 2:
						ned = ImageIO.read(Main.class.getResource("/images/BENCH.png"));
						break;
					case 4:
						ned = ImageIO.read(Main.class.getResource("/images/GEM.png"));
						break;
					case 5:
						switch(ftp%3) {
							case 0:
								ned = ImageIO.read(Main.class.getResource("/images/FLOWER 1.png"));
								break;
							case 1:
								ned = ImageIO.read(Main.class.getResource("/images/FLOWER 2.png"));
								break;
							case 2:
								ned = ImageIO.read(Main.class.getResource("/images/FLOWER 3.png"));
								break;
						}
						ftp++;
						break;
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getType() {
		return Type;
	}
	
	
}
