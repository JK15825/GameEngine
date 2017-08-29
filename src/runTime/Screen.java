package runTime;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;
public class Screen extends JPanel
{
	private int WIDTH;
	private int HEIGHT;
	
	public Screen()
	{
		WIDTH = 720;
		HEIGHT = 480;
	}
	
	public Screen(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
	}
	
	public void paintComponent(Graphics g)
	{
		if(g != null)
			g.fillRect(0, 0, 500, 500);
	}
}
