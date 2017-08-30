/* by Colin Wakefield , 
 * 
 * This is an attempt at a 3D game engine 
 * 
 */
package runTime;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class Run implements Runnable
{
	private JFrame frame;
	private Screen gameScreen;
	private boolean running;
	private int frames;
	private int updates;
	public Run()
	{
		frame = new JFrame("THE FRAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);

		gameScreen = new Screen();
		frame.add(gameScreen);
		
		frame.pack();
		frame.setSize(720,480);
		frame.setResizable(false);

	}
	public void start()
	{
		Thread t = new Thread(this);
		t.start();
	}
	public void run()
	{
		init();
		
		
		long lastTime = System.nanoTime();
        double amountOfTicks = 60D;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                //tick();
                updates++;
                frames++;

                delta--;
            }
            gameScreen.draw(this.frames, this.updates);
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer+=1000;
                this.frames = frames;
                this.updates = updates;
                frames = 0;
                updates = 0;
            }
            
        }
	}
	private void init()
	{
		frame.setVisible(true);
		JRootPane rootPane = frame.getRootPane();
		rootPane.getInputMap(JRootPane.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0), "closeWindow");
		rootPane.getActionMap().put("closeWindow",new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		
		running = true;
		frames = 0;
		updates = 0;
	}
	
	public static void main(String args[])
	{
		new Run().start();
	}
}
