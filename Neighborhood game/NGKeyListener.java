import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NGKeyListener implements KeyListener
{
	boolean up, down, left, right;
	boolean t, b, p, f;
	boolean ctrl;
	boolean tab;
	
	NGKeyListener()
	{
		
		up = down = left = right = false;
		t = b = p = f = false;
		ctrl = tab = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		
		
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
			left = true;
			break;
			
			case KeyEvent.VK_RIGHT:
			right = true;
			break;
			
			case KeyEvent.VK_UP:
			up = true;
			break;
			
			case KeyEvent.VK_DOWN: 
			down = true;
			break;
			
			case KeyEvent.VK_T:
			t = true;
			break;
			
			case KeyEvent.VK_B:
			b = true;
			break;
			
			case KeyEvent.VK_P:
			p = true;
			break;
			
			case KeyEvent.VK_F:
			f = true;
			break;
			
			case 192://~ key
			tab = true;
			break;
			
			case KeyEvent.VK_CONTROL:
			ctrl = true;
			break;
		}
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				
			left = false;
			break;
			
			case KeyEvent.VK_RIGHT:
			right = false;
			break;

			case KeyEvent.VK_UP:
			up = false;
			break;

			case KeyEvent.VK_DOWN:
			down = false;
			break;
			
			case KeyEvent.VK_T:
			t = false;
			break;
			
			case KeyEvent.VK_B:
			b = false;
			break;
			
			case KeyEvent.VK_P:
			p = false;
			break;
			
			case KeyEvent.VK_F:
			f = false;
			break;
			
			case 192://~ KEY
			tab = false;
			break;
			
			case KeyEvent.VK_CONTROL:
			ctrl = false;
			break;

		}
		
	}
	
	public void keyTyped(KeyEvent e)
	{}
}