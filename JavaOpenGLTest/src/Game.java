import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.DisplayMode;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Game extends JFrame implements GLEventListener, MouseListener{
	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private float rquad = 0.0f;
	private GL2 gl;
	private FPSAnimator animator;
	private GLCanvas canvas;
	private static final long serialVersionUID = 1L;
	private final int width = 800;
	private final int height = 600;
	private boolean flag = false;
	
	public Game() {
		super("OpenGL Test");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		
		canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		canvas.addMouseListener(this);
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
		gl = arg0.getGL().getGL2();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);
		if(flag) {
			gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
		}else {
			gl.glClearColor(0f, 0f, 0f, 0f);
		}
		gl.glLoadIdentity();
		gl.glTranslatef(0f, 0f, -5.0f);
		gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(1f, 0f, 0f);
		gl.glVertex3f(1.0f, 1.0f, -1.0f);
		gl.glVertex3f(-1.0f, 1.0f, -1.0f);
		gl.glVertex3f(-1.0f, 1.0f, 1.0f);
		gl.glVertex3f(1.0f, 1.0f, 1.0f);
		
		gl.glColor3f(0f, 1f, 0f);
		gl.glVertex3f(1.0f, -1.0f, 1.0f);
		gl.glVertex3f(-1.0f, -1.0f, 1.0f);
		gl.glVertex3f(-1.0f, -1.0f, -1.0f);
		gl.glVertex3f(1.0f, -1.0f, -1.0f);
		
		gl.glColor3f(0f, 0f, 1f);
		gl.glVertex3f(1.0f, 1.0f, 1.0f);
		gl.glVertex3f(-1.0f, 1.0f, 1.0f);
		gl.glVertex3f(-1.0f, -1.0f, 1.0f);
		gl.glVertex3f(1.0f, -1.0f, 1.0f);
		
		gl.glColor3f(1f, 1f, 0f);
		gl.glVertex3f(1.0f, -1.0f, -1.0f);
		gl.glVertex3f(-1.0f, -1.0f, -1.0f);
		gl.glVertex3f(-1.0f, 1.0f, -1.0f);
		gl.glVertex3f(1.0f, 1.0f, -1.0f);
		
		gl.glColor3f(1f, 0f, 1f);
		gl.glVertex3f(-1.0f, 1.0f, 1.0f);
		gl.glVertex3f(-1.0f, 1.0f, -1.0f);
		gl.glVertex3f(-1.0f, -1.0f, -1.0f);
		gl.glVertex3f(-1.0f, -1.0f, 1.0f);
		
		gl.glColor3f(0f, 1f, 1f);
		gl.glVertex3f(1.0f, 1.0f, -1.0f);
		gl.glVertex3f(1.0f, 1.0f, 1.0f);
		gl.glVertex3f(1.0f, -1.0f, 1.0f);
		gl.glVertex3f(1.0f, -1.0f, -1.0f);
		
		gl.glEnd();
		gl.glFlush();
		
		rquad -= 0.15f;
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		gl = arg0.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
		//gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		gl = arg0.getGL().getGL2();
		if(arg4 ==0) {
			arg4 = 1;
		}
		float h = (float)arg3/(float)arg4;
		gl.glViewport(0, 0, arg3, arg4);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		glu.gluPerspective(45.0f, h, 1.0, 22.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
