import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.DisplayMode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
/**
 * GL을 사용하는 Frame class
 * @author wonyoung
 *
 */
public class GLFrame extends JFrame implements GLEventListener, MouseListener, MouseMotionListener{
	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private float rquad = 0.0f;
	private GL2 gl;
	private FPSAnimator animator;
	private static GLProfile profile = GLProfile.get(GLProfile.GL2);
	private static GLCapabilities capabilities = new GLCapabilities(profile);
	private static GLCanvas canvas = new GLCanvas(capabilities);
	private static final long serialVersionUID = 1L;
	private int width = 800;
	private int height = 600;
	private boolean flag = false;
	private float datasX[] = new float[2];
	private float datasY[] = new float[2];
	private GLDrawManager manager;
	
	public GLFrame(int width, int height) {
		super("OpenGL Test");
		this.width = width;
		this.height = height;
		manager = GLDrawManager.getInstance();
		canvas.addGLEventListener(this);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		this.setName("OpenGL Test");
		this.getContentPane().add(canvas);
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		canvas.requestFocusInWindow();
		animator = new FPSAnimator(canvas,300,true);
		animator.start();
	}
	
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		/*if(flag) {
			gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
		}else {
			gl.glClearColor(0f, 0f, 0f, 0f);
		}*/
		float color[] = {0.0f, 1.0f, 0.0f};
		//manager.drawRotateCube(arg0,5.0f,1.0f,2.0f);
		manager.drawTringle(arg0, color, datasX, datasY);
		//manager.drawRectangle(arg0, color, datasX, datasY);
		//manager.drawCircle(arg0, color, datasX, datasY);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		manager.init(arg0,width,height);
		//gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		manager.reshape(arg1, arg2, arg3, arg4);
	}
	
	public void play() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(animator.isAnimating()) {
			flag = true;
			canvas.display();
			canvas.requestFocusInWindow();
			animator.stop();
		}else {
			flag = false;
			animator.start();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		datasX[0] = datasX[1] = e.getX();
		datasY[0] = datasY[1] = e.getY();
		canvas.display();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		datasX[1] = e.getX();
		datasY[1] = e.getY();
		canvas.display();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
