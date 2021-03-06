package runTime;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Screen implements GLEventListener
{

	private GLU glu = new GLU();
	private static final String TITLE = "3D Thing";
	private static final int CANVAS_WIDTH = 960;
	private static final int CANVAS_HEIGHT = 720;
	private static final int FPS = 30;
	
	public Screen()
	{
		
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
	    GLCapabilities caps = new GLCapabilities(profile);
	     
	    //caps.setDepthBits(16);
	    
		GLCanvas canvas = new GLCanvas(caps);
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);
		
		final JFrame frame = new JFrame();
		frame.getContentPane().add(canvas);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				new Thread() {
                     @Override
                     public void run() {
                        if (animator.isStarted()) 
                        	animator.stop();
                        System.exit(0);
                     }
                  }.start();
			}
		});
		//bindKeys(frame);
		
		canvas.addGLEventListener(this);
		
		frame.setTitle(TITLE);
		frame.pack();
		frame.setVisible(true);
		animator.start();
	}
	
	private void bindKeys(JFrame frame)
	{
		/*JRootPane root = frame.getRootPane();
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed W"), "pressedUp");
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "releasedUp");
		
		root.getActionMap().put("pressedUp", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleThrust(true);
				//System.out.println("Pressed Up");
			}
		});
		root.getActionMap().put("releasedUp", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleThrust(false);
				//System.out.println("Released Up");
			}
		});
		
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "pressedLeft");
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "releasedLeft");
		
		root.getActionMap().put("pressedLeft", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleRotateLeft(true);
				//System.out.println("Pressed Up");
			}
		});
		root.getActionMap().put("releasedLeft", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleRotateLeft(false);
				//System.out.println("Released Up");
			}
		});
		
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed D"), "pressedRight");
		root.getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "releasedRight");
		
		root.getActionMap().put("pressedRight", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleRotateRight(true);
				//System.out.println("Pressed Up");
			}
		});
		root.getActionMap().put("releasedRight", new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
				lander.toggleRotateRight(false);
				//System.out.println("Released Up");
			}
		});*/
	}

	@Override
	public void init(GLAutoDrawable drawable) 
	{
		GL2 gl = drawable.getGL().getGL2();
		//gl.glClearColor(1f,0f,1f,0f);
		//gl.glClearDepth(1.0f);
		//gl.glEnable(GL.GL_DEPTH_TEST);
		//gl.glDepthFunc(GL.GL_LEQUAL);
		
		//gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		//gl.glShadeModel(GL2.GL_SMOOTH);
		
	}
	
	@Override
	public void display(GLAutoDrawable drawable) 
	{
		render(drawable);
		update();
	}
	
	private void render(GLAutoDrawable drawable)
	{
		final GL2 gl = drawable.getGL().getGL2();
		//gl.glLoadIdentity();
		gl.glTranslatef( 0f, 0f, -2.5f );
		gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( -0.75f,0f,0 );
		gl.glVertex3f( 0f,-0.75f, 0 );
		gl.glEnd();
		//3d line
		gl.glBegin( GL2.GL_LINES );
		gl.glVertex3f( -0.75f,0f,3f );// 3 units into the window
		gl.glVertex3f( 0f,-0.75f,3f );
		gl.glEnd();
		//System.out.println("WHAT THE FUCK");
	}
	
	private void update()
	{
 	}
	@Override
	public void dispose(GLAutoDrawable arg0) 
	{
	
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
	{
		/*GL2 gl = drawable.getGL().getGL2();
		if( height <=0 )
			height =1;
		final float h = ( float ) width / ( float ) height;
		gl.glViewport( 0, 0, width, height );
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();
		glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();*/
		
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() 
			{
				new Screen();
			}
			
		});
	}
}
