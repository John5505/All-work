import java.awt.Dimension;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Background{
	BufferedImage bg1, bg2, bg3, bg4, bg5, bg6, bg7, bg8, bg9;
	BufferedImage bga, bgb, bgc, bgd;

	public Background() {
		BufferedImage bnet;
		
		Image gnet[] = new Image[9];
		try {
		
			bg1 = ImageIO.read(new File("C:/Users/Owner/Documents/Christine neighborhood game/src/TILED BACKGROUND/Game Print Layout (color)22.png"));
			bga = new BufferedImage(bg1.getWidth()/3, bg1.getHeight()/3, BufferedImage.TYPE_INT_ARGB);
			bga.getGraphics().drawImage(bg1.getScaledInstance(bg1.getWidth()/3,bg1.getHeight()/3, Image.SCALE_SMOOTH), 0, 0 , null);
			
			bg2 = ImageIO.read(new File("C:/Users/Owner/Documents/Christine neighborhood game/src/TILED BACKGROUND/Game Print Layout (color)23.png"));
			bg2.getScaledInstance(bg1.getWidth()/3,bg1.getHeight()/3, Image.SCALE_SMOOTH);
		//	bgb = new BufferedImage(bg1.getWidth()/3, bg1.getHeight()/3, BufferedImage.TYPE_INT_ARGB);
			bgb.getGraphics().drawImage(bg2, bg2.getWidth()/3*2, 0 , null);

			bg3 = ImageIO.read(new File("C:/Users/Owner/Documents/Christine neighborhood game/src/TILED BACKGROUND/Game Print Layout (color)24.png"));
			bg3.getScaledInstance(bg1.getWidth()/3,bg1.getHeight()/3, Image.SCALE_SMOOTH);
		//	bgc = new BufferedImage(bg1.getWidth()/3, bg1.getHeight()/3, BufferedImage.TYPE_INT_ARGB);
			bgc.getGraphics().drawImage(bg3, bg3.getWidth()/3*3, 0 , null);
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	public BufferedImage getLeft(int Loc) {
		int set = Loc/1900;

		switch(set) {
			case 0:
				return bga;
			case 1:
				return bgb;
			case 2:
				return bgc;
			case 3:
				return bg4;
			case 4:
				return bg5;
			case 5:
				return bg6;
			case 6:
				return bg7;
			case 7:
				return bg8;
			default:
				return bg1;
			
		}
	}
	
		public BufferedImage getRight(int Loc) {
		int set = Loc/bg1.getWidth();
		switch(set) {
		case 0:
			return bgb;
		case 1:
			return bgc;
		case 2:
			return bgd;
		case 3:
			return bg5;
		case 4:
			return bg6;
		case 5:
			return bg7;
		case 6:
			return bg8;
		case 7:
			return bg9;
		default:
			return bg1;
		
	}
	
	}
	public int getSpDist() {
		return bga.getWidth()/3;
	}
}
