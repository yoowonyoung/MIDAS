import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.awt.TextRenderer;

public class Game3 extends JFrame implements GLEventListener, MouseListener , KeyListener, MouseMotionListener {
	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private GL2 gl;
	private FPSAnimator animator;
	private GLCanvas canvas;
	private static final long serialVersionUID = 1L;
	private final int width = 600;
	private final int height = 600;
	private boolean flag = false;
	private TextRenderer textRenderer;
	private int textPosX;
	private int textPosY;
	private String mode = "Unclick";
	private float topLeftX,bottomRightX;
	private float topLeftY,bottomRightY;
	private float arr[][] = new float[1000][1000];
	private int index = 0;
	private float gravity = 0.0f;
	private PolygonData[] datas = new PolygonData[10];
	
	public Game3() {
		super("OpenGL Test");
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		textRenderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 14));
		canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		canvas.addKeyListener(this);
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
		textRenderer.beginRendering(arg0.getSurfaceWidth(), arg0.getSurfaceHeight());
		textRenderer.setColor(Color.WHITE);
		//textRenderer.draw("Mode: " + mode, textPosX - 80, arg0.getSurfaceHeight() - textPosY - 10);
		textRenderer.draw("Mode: " + mode, 10, 10);
		textRenderer.endRendering();
		if(flag) {
			gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);
		}else {
			gl.glClearColor(0f, 0f, 0f, 0f);
		}
		gl.glViewport(0, 0, 600, 600);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		
		glu.gluOrtho2D(0.0f, 0.0f, 600.0f, 600.0f);
		//gl.glTranslatef(0f, 0f, -10.0f);
		
		gl.glColor3f(0f, 0f, 1f);
		if(index != 0) {
			for(int i = 0; i < index; i++) {
				gl.glBegin(GL2.GL_POLYGON);
				String type = datas[i].getPolygonType();
				float datasX[] = datas[i].getPolygonDataX();
				float datasY[] = datas[i].getPolygonDataY();
				if(type.equalsIgnoreCase("R")) {
					gl.glVertex2f((datasX[0] - 300.0f)/300.0f,(300.0f - datasY[0])/300.0f);
					gl.glVertex2f((datasX[1] - 300.0f)/300.0f,(300.0f - datasY[0])/300.0f);
					gl.glVertex2f((datasX[1] - 300.0f)/300.0f,(300-.0f - datasY[1])/300.0f);
					gl.glVertex2f((datasX[0] - 300.0f)/300.0f,(300.0f - datasY[1])/300.0f);
				}else if(type.equalsIgnoreCase("T")) {
					gl.glVertex2f(((datasX[0] + datasX[1] - 600.0f)/2.0f)/300.0f,(300.0f - datasY[0])/300.0f);
					gl.glVertex2f((datasX[1] - 300.0f)/300.0f,(300-.0f - datasY[1])/300.0f);
					gl.glVertex2f((datasX[0] - 300.0f)/300.0f,(300.0f - datasY[1])/300.0f);
				}else if(type.equalsIgnoreCase("C")) {
					for(int j=0; j<360; ++j) {
						float centerX = ((datasX[0] + datasX[1] - 600.0f)/2.0f)/300.0f;
						float lengthX = ((datasX[1] - datasX[0]))/300.0f;
						float centerY = ((600.0f- datasY[0] - datasY[1])/2.0f)/300.0f;
						float lengthY = ( datasY[1] - datasY[0])/300.0f;
						float radiusX = (float)(centerX + lengthX*Math.cos(j*(3.14152/180)));
						float radiusY = (float)(centerY + lengthY*Math.sin(j*(3.14152/180)));
			            gl.glVertex3f(radiusX, radiusY, 0.0f );
			        }
				}
				gl.glEnd();

			}
			/*
			if(mode.equalsIgnoreCase("R")) {
				gl.glVertex2f((topLeftX - 300.0f)/300.0f,(300.0f - topLeftY)/300.0f);
				gl.glVertex2f((bottomRightX - 300.0f)/300.0f,(300.0f - topLeftY)/300.0f);
				gl.glVertex2f((bottomRightX - 300.0f)/300.0f,(300-.0f - bottomRightY)/300.0f);
				gl.glVertex2f((topLeftX - 300.0f)/300.0f,(300.0f - bottomRightY)/300.0f);
			}else if(mode.equalsIgnoreCase("T")) {
				gl.glVertex2f(((topLeftX + bottomRightX - 600.0f)/2.0f)/300.0f,(300.0f - topLeftY)/300.0f);
				gl.glVertex2f((bottomRightX - 300.0f)/300.0f,(300-.0f - bottomRightY)/300.0f);
				gl.glVertex2f((topLeftX - 300.0f)/300.0f,(300.0f - bottomRightY)/300.0f);
			}else if(mode.equalsIgnoreCase("C")) {
				for(int i=0; i<360; ++i) {
					float centerX = ((topLeftX + bottomRightX - 600.0f)/2.0f)/300.0f;
					float lengthX = ((bottomRightX - topLeftX))/300.0f;
					float centerY = ((600.0f- topLeftY - bottomRightY)/2.0f)/300.0f;
					float lengthY = ( bottomRightY - topLeftY)/300.0f;
					float radiusX = (float)(centerX + lengthX*Math.cos(i*(3.14152/180)));
					float radiusY = (float)(centerY + lengthY*Math.sin(i*(3.14152/180)));
		            gl.glVertex3f(radiusX, radiusY, 0.0f );
		        }
			}
			*/
			
			/*
			gl.glBegin(GL2.GL_QUADS);
			
			gl.glVertex2f((topLeftX)*(2*5.0f)/800 -5.0f,(topLeftY)*(2*5.0f)/600 -5.0f);
			gl.glVertex2f((bottomRightX)*(2*5.0f)/800 -5.0f,(topLeftY)*(2*5.0f)/600 -5.0f);
			gl.glVertex2f((bottomRightX)*(2*5.0f)/800 -5.0f,-(bottomRightY)*(2*5.0f)/600 +5.0f);
			gl.glVertex2f((topLeftX)*(2*5.0f)/800 -5.0f,-(bottomRightY)*(2*5.0f)/600 +5.0f);
			
			
			
			gl.glVertex2f(topLeftX/800 -0.5f +0.1525f,topLeftY/600 -0.5f +0.10499998f);
			gl.glVertex2f(bottomRightX/800 -0.5f +0.1525f,topLeftY/600 -0.5f +0.10499998f);
			gl.glVertex2f(bottomRightX/800 -0.5f +0.1525f,-bottomRightY/600 +0.5f +0.10499998f);
			gl.glVertex2f(topLeftX/800 -0.5f +0.1525f,-bottomRightY/600 +0.5f +0.10499998f);
			*/
			
			//gl.glFlush();
			
			
			
			//gl.glRectf(topLeftX/800, topLeftY/600, bottomRightX/800, bottomRightY/600);

		}
		
	
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		Rectangle2D bounds = textRenderer.getBounds("Mode: " + mode);
		int textWidth = (int)bounds.getWidth();
		int textHeight = (int)bounds.getHeight();
		textPosX = textWidth;
		textPosY = textHeight;
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
		System.out.println("Click");
		//topLeftX = e.getX();
		//topLeftY = e.getY();
		
		if(animator.isAnimating()) {
			flag = true;
			mode = "Click";
			canvas.display();
			canvas.requestFocusInWindow();
			animator.stop();
		}else {
			mode = "Unclick";
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
		topLeftX = e.getX();
		topLeftY = e.getY();
		datas[index] = new PolygonData();
		datas[index].setLeftXY(topLeftX, topLeftY);
		datas[index].setPolygonType(mode);
		//System.out.println("old :" + topLeftX + " , " + topLeftY);
		
		canvas.display();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		index++;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char ch = e.getKeyChar();
		if(ch == '\032') {
			index--;
		}else {
			mode = ch + "";
		}
		
		canvas.display();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		bottomRightX = e.getX();
		bottomRightY = e.getY();
		datas[index].setRightXY(bottomRightX, bottomRightY);
		//System.out.println(bottomRightX + " , " + bottomRightY);
		canvas.display();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
