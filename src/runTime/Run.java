/* by Colin Wakefield , 
 * 
 * This is an attempt at a 3D game engine 
 * 
 */
package runTime;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class Run implements Runnable
{
	private JFrame frame;
	private Screen gameScreen;
	public Run()
	{
		frame = new JFrame("THE FRAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	}
	private void init()
	{
		frame.setVisible(true);
		JRootPane rootPane = frame.getRootPane();
		rootPane.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed ESC"), "closeWindow");
		rootPane.getActionMap().put("closeWindow",new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[])
	{
		new Run().start();
	}
}
