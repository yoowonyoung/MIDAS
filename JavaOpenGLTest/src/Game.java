import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Game extends JFrame implements GLEventListener{
	private static final long serialVersionUID = 1L;
	private final int width = 800;
	private final int height = 600;
	
	public Game() {
		super("OpenGL Test");
		GLProfile profile = GLProfile.get(GLProfile.GL4);
		GLCapabilities capabilities = new GLCapabilities(profile);
		
		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		
		this.setName("OpenGL Test");
		this.getContentPane().add(canvas);
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		canvas.requestFocusInWindow();
	}
	
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL4 gl = arg0.getGL().getGL4();
		gl.glClear(GL4.GL_COLOR_BUFFER_BIT | GL4.GL_DEPTH_BUFFER_BIT);
		gl.glFlush();
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		GL4 gl = arg0.getGL().getGL4();
		gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		
	}
	
	public void play() {
		
	}
	
}
