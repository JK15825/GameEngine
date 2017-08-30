package runTime;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen extends JPanel
{
	private int WIDTH;
	private int HEIGHT;
	private BufferedImage[] CHARACTERS;
	private BufferedImage buff;
	private Graphics2D buffGraphics;
	public Screen()
	{
		WIDTH = 720;
		HEIGHT = 480;
		init();
	}
	
	public Screen(int width, int height)
	{
		WIDTH = width;
		HEIGHT = height;
		init();
	}
	
	private void init()
	{
		getCharacters();
		buff = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		buffGraphics = null;
	}
	private void getCharacters()
	{
		BufferedImage temp = null;
		try {
			temp = ImageIO.read(new File("res/alphabet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        CHARACTERS = new BufferedImage[41];
        int count = 0;
        for(int y = 0; y < 24; y +=8)
        {
            for(int x = 0; x < 96; x += 6)
            {
                if(count < 41)
                {
                    CHARACTERS[count] = temp.getSubimage(x,y,6,8);
                    count++;
                }
            }
            //BufferedImage temp2 = temp;
        }
	}
	public void draw(int frames, int updates)
	{
		Graphics2D g = (Graphics2D)this.getGraphics();
		if(g != null)
		{
			g.clearRect(0,0,WIDTH,HEIGHT);
			if(buffGraphics == null)
				buffGraphics = (Graphics2D)buff.createGraphics();
			
			 drawText("FPS: " + frames, 0, 0); 
	         drawText("TICKS: " + updates, 0, 8);
	         
	         g.drawImage(buff, 0, 0, null);
		}
	}
	public void drawText(String textToDraw, int x, int y)
	{
		textToDraw = textToDraw.toLowerCase();
        for(char character: textToDraw.toCharArray())
        {
             switch(character)
             {
                 case 'a': buffGraphics.drawImage(CHARACTERS[0],x,y,null); x +=6; break;
                 case 'b': buffGraphics.drawImage(CHARACTERS[1],x,y,null); x +=6; break;
                 case 'c': buffGraphics.drawImage(CHARACTERS[2],x,y,null); x +=6; break;
                 case 'd': buffGraphics.drawImage(CHARACTERS[3],x,y,null); x +=6; break;
                 case 'e': buffGraphics.drawImage(CHARACTERS[4],x,y,null); x +=6; break;
                 case 'f': buffGraphics.drawImage(CHARACTERS[5],x,y,null); x +=6; break;
                 case 'g': buffGraphics.drawImage(CHARACTERS[6],x,y,null); x +=6; break;
                 case 'h': buffGraphics.drawImage(CHARACTERS[7],x,y,null); x +=6; break;
                 case 'i': buffGraphics.drawImage(CHARACTERS[8],x,y,null); x +=6; break;
                 case 'j': buffGraphics.drawImage(CHARACTERS[9],x,y,null); x +=6; break;
                 case 'k': buffGraphics.drawImage(CHARACTERS[10],x,y,null); x +=6; break;
                 case 'l': buffGraphics.drawImage(CHARACTERS[11],x,y,null); x +=6; break;
                 case 'm': buffGraphics.drawImage(CHARACTERS[12],x,y,null); x +=6; break;
                 case 'n': buffGraphics.drawImage(CHARACTERS[13],x,y,null); x +=6; break;
                 case 'o': buffGraphics.drawImage(CHARACTERS[14],x,y,null); x +=6; break;
                 case 'p': buffGraphics.drawImage(CHARACTERS[15],x,y,null); x +=6; break;
                 case 'q': buffGraphics.drawImage(CHARACTERS[16],x,y,null); x +=6; break;
                 case 'r': buffGraphics.drawImage(CHARACTERS[17],x,y,null); x +=6; break;
                 case 's': buffGraphics.drawImage(CHARACTERS[18],x,y,null); x +=6; break;
                 case 't': buffGraphics.drawImage(CHARACTERS[19],x,y,null); x +=6; break;
                 case 'u': buffGraphics.drawImage(CHARACTERS[20],x,y,null); x +=6; break;
                 case 'v': buffGraphics.drawImage(CHARACTERS[21],x,y,null); x +=6; break;
                 case 'w': buffGraphics.drawImage(CHARACTERS[22],x,y,null); x +=6; break;
                 case 'x': buffGraphics.drawImage(CHARACTERS[23],x,y,null); x +=6; break;
                 case 'y': buffGraphics.drawImage(CHARACTERS[24],x,y,null); x +=6; break;
                 case 'z': buffGraphics.drawImage(CHARACTERS[25],x,y,null); x +=6; break;
                 case ' ': buffGraphics.drawImage(CHARACTERS[39],x,y,null); x +=6; break;
                 case ':': buffGraphics.drawImage(CHARACTERS[36],x,y,null); x +=6; break;
                 case '0': buffGraphics.drawImage(CHARACTERS[26],x,y,null); x +=6; break;
                 case '1': buffGraphics.drawImage(CHARACTERS[27],x,y,null); x +=6; break;
                 case '2': buffGraphics.drawImage(CHARACTERS[28],x,y,null); x +=6; break;
                 case '3': buffGraphics.drawImage(CHARACTERS[29],x,y,null); x +=6; break;
                 case '4': buffGraphics.drawImage(CHARACTERS[30],x,y,null); x +=6; break;
                 case '5': buffGraphics.drawImage(CHARACTERS[31],x,y,null); x +=6; break;
                 case '6': buffGraphics.drawImage(CHARACTERS[32],x,y,null); x +=6; break;
                 case '7': buffGraphics.drawImage(CHARACTERS[33],x,y,null); x +=6; break;
                 case '8': buffGraphics.drawImage(CHARACTERS[34],x,y,null); x +=6; break;
                 case '9': buffGraphics.drawImage(CHARACTERS[35],x,y,null); x +=6; break;
                 case '-': buffGraphics.drawImage(CHARACTERS[37],x,y,null); x +=6; break;
             }
        }
	}
}
