import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
/**
 * GL을 간편하게 사용하기 위한 Singleton 매니저 클래스
 * @author wonyoung
 *
 */
public class GLDrawManager {
	private GL2 gl;
	private GLU glu;
	private static GLDrawManager instance = new GLDrawManager();
	private GLAutoDrawable autoDrawable;
	private int width = 600;
	private int height = 600;
	private PolygonData data;
	
	private GLDrawManager() {
		glu = new GLU();
	}
	/**
	 * GLDrawManager를 사용하기 위해 instance를 반환해주는 메서드
	 * @return Manager instance
	 */
	public static GLDrawManager getInstance() {
		return instance;
	}
	/**
	 * GLEventListener의 init에 대응하는 DrawManager의 init
	 * @param arg0 GLEventListener의 arg0 그대로
	 * @param width 화면의 가로길이
	 * @param height 화면의 세로길이
	 */
	public void init(GLAutoDrawable arg0, int width, int height) {
		this.width = width;
		this.height = height;
		gl = arg0.getGL().getGL2();
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
	}
	/**
	 * GLEventListener의 reshape에 대응하는 DrawManager의 reshape
	 * @param arg1 GLEventListener의 arg1 그대로
	 * @param arg2 GLEventListener의 arg2 그대로
	 * @param arg3 GLEventListener의 arg3 그대로
	 * @param arg4 GLEventListener의 arg4 그대로
	 */
	public void reshape(int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
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
	/**
	 * 회전하는 정육면체를 만드는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param translatef 화면 크기를 결정하는 float 변수
	 * @param sizef 정육면체의 크기를 결정하는 float 변수
	 * @param rotateSpeed 회전 속도를 결정하는 float 변수
	 */
	public void drawRotateCube(GLAutoDrawable arg0,float translatef, float sizef, float rotateSpeed) {
		gl = arg0.getGL().getGL2();
		float rquad = 0.0f;
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0f, 0f, -translatef);
		gl.glRotatef(rquad, rotateSpeed, rotateSpeed, rotateSpeed);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3f(1f, 0f, 0f);
		gl.glVertex3f(sizef, sizef, -sizef);
		gl.glVertex3f(-sizef, sizef, -sizef);
		gl.glVertex3f(-sizef, sizef, sizef);
		gl.glVertex3f(sizef, sizef, sizef);
		
		gl.glColor3f(0f, 1f, 0f);
		gl.glVertex3f(sizef, -sizef, sizef);
		gl.glVertex3f(-sizef, -sizef, sizef);
		gl.glVertex3f(-sizef, -sizef, -sizef);
		gl.glVertex3f(sizef, -sizef, -sizef);
		
		gl.glColor3f(0f, 0f, 1f);
		gl.glVertex3f(sizef, sizef, sizef);
		gl.glVertex3f(-sizef, sizef, sizef);
		gl.glVertex3f(-sizef, -sizef, sizef);
		gl.glVertex3f(sizef, -sizef, sizef);
		
		gl.glColor3f(1f, 1f, 0f);
		gl.glVertex3f(sizef, -sizef, -sizef);
		gl.glVertex3f(-sizef, -sizef, -sizef);
		gl.glVertex3f(-sizef, sizef, -sizef);
		gl.glVertex3f(sizef, sizef, -sizef);
		
		gl.glColor3f(1f, 0f, 1f);
		gl.glVertex3f(-sizef, sizef, sizef);
		gl.glVertex3f(-sizef, sizef, -sizef);
		gl.glVertex3f(-sizef, -sizef, -sizef);
		gl.glVertex3f(-sizef, -sizef, sizef);
		
		gl.glColor3f(0f, 1f, 1f);
		gl.glVertex3f(sizef, sizef, -sizef);
		gl.glVertex3f(sizef, sizef, sizef);
		gl.glVertex3f(sizef, -sizef, sizef);
		gl.glVertex3f(sizef, -sizef, -sizef);
		
		gl.glEnd();
		gl.glFlush();
		
		rquad -= 0.15f;
	}

	/**
	 * 사각형을 그리는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 사각형의 정보를 가진 Polygondata 객체
	 */
	public void drawRectangle(GLAutoDrawable arg0, PolygonData data) {
		if(data.getInpputedData()) {
			this.drawPoint(arg0, data);
			
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glColor3f(color[0], color[1], color[2]);
			gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2f((datasX[datasX.length-2] - tempX)/tempX,(tempY - datasY[datasY.length -2])/tempY);
			gl.glVertex2f((datasX[datasX.length-1] - tempX)/tempX,(tempY - datasY[datasY.length -2])/tempY);
			gl.glVertex2f((datasX[datasX.length-1] - tempX)/tempX,(tempY - datasY[datasY.length -1])/tempY);
			gl.glVertex2f((datasX[datasX.length-2] - tempX)/tempX,(tempY - datasY[datasY.length -1])/tempY);
			/*
			gl.glVertex2f((datasX[0] - tempX)/tempX,(tempY - datasY[0])/tempY);
			gl.glVertex2f((datasX[1] - tempX)/tempX,(tempY - datasY[0])/tempY);
			gl.glVertex2f((datasX[1] - tempX)/tempX,(tempY - datasY[1])/tempY);
			gl.glVertex2f((datasX[0] - tempX)/tempX,(tempY - datasY[1])/tempY);
			*/
			gl.glEnd();
			gl.glFlush();
		}
	}
	/**
	 * 원을 그리는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 원의 정보를 가진 PolygonData 객체
	 */
	public void drawCircle(GLAutoDrawable arg0, PolygonData data) {
		if(data.getInpputedData()) {
			this.drawPoint(arg0, data);
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glColor3f(color[0], color[1], color[2]);
			gl.glBegin(GL2.GL_POLYGON);
			for(int j=0; j<360; ++j) {
				float centerX = ((datasX[datasX.length -2] + datasX[datasX.length -1] - width)/2.0f)/tempX;
				float lengthX = ((datasX[datasX.length -1] - datasX[datasX.length -2]))/tempX;
				float centerY = ((height- datasY[datasY.length -2] - datasY[datasY.length-1])/2.0f)/tempY;
				float lengthY = ( datasY[datasY.length -1] - datasY[datasY.length-2])/tempY;
				float radiusX = (float)(centerX + lengthX*Math.cos(j*(3.14152/180)));
				float radiusY = (float)(centerY + lengthY*Math.sin(j*(3.14152/180)));
	            gl.glVertex3f(radiusX, radiusY, 0.0f );
	        }
			gl.glEnd();
		}		
	}
	
	/**
	 * 선분을 그리는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 선분의 정보를 가진 PolygonData 객체
	 */
	public void drawLine(GLAutoDrawable arg0, PolygonData data) {
		if(data.getInpputedData()) {
			this.drawPoint(arg0, data);
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glColor3f(color[0], color[1], color[2]);
			gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex2f((datasX[datasX.length-2] - tempX)/tempX, (tempY - datasY[datasY.length-2])/tempY);
			gl.glVertex2f((datasX[datasX.length-1] - tempX)/tempX, (tempY - datasY[datasY.length-1])/tempY);
			gl.glEnd();
		}
		
	}
	
	/**
	 * 삼각형을 그리는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 삼각형의 정보를 가진 PolygonData 객체
	 */
	public void drawTringle(GLAutoDrawable arg0, PolygonData data) {
		if(data.getInpputedData()) {
			this.drawPoint(arg0, data);
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glColor3f(color[0], color[1], color[2]);
			gl.glBegin(GL2.GL_POLYGON);
			gl.glVertex2f(((datasX[datasX.length-2] + datasX[datasX.length-1] - width)/2.0f)/tempX,(tempY - datasY[datasY.length-2])/tempY);
			gl.glVertex2f((datasX[datasX.length-1] - tempX)/tempX,(tempY - datasY[datasY.length-1])/tempY);
			gl.glVertex2f((datasX[datasX.length-2] - tempX)/tempX,(tempY - datasY[datasY.length-1])/tempY);
			gl.glEnd();
		}
		
	}
	/**
	 * 다각형을 그리는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 다각형의 정보를 가진 PolygonData 객체
	 */
	public void drawPolygon(GLAutoDrawable arg0, PolygonData data) {
		if(data.getInpputedData()) {
			this.drawPoint(arg0, data);
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glColor3f(color[0], color[1], color[2]);
			gl.glBegin(GL2.GL_POLYGON);
			for(int i = 0; i < datasX.length; i++ ){
				gl.glVertex2f((datasX[i] - tempX)/tempX, (tempY - datasY[i])/tempY);
			}
			gl.glEnd();
		}
	}
	/**
	 * 도형을 그릴때 각 모서리의 점을 찍는 메서드
	 * @param arg0 GLEventListener에서 사용하는 GLAutoDrawable 그대로
	 * @param data 다각형의 정보를 가진 PolygonData 객체
	 */
	private void drawPoint(GLAutoDrawable arg0, PolygonData data ) {
		if(data.getInpputedData()) {
			Float datasX[] = data.getPolygonDataX();
			Float datasY[] = data.getPolygonDataY();
			float color[] = data.getColor();
			float tempX = width/2;
			float tempY = height/2;
			gl = arg0.getGL().getGL2();
			gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
			gl.glViewport(0, 0, width, height);
			gl.glMatrixMode(GL2.GL_PROJECTION);
			gl.glLoadIdentity();
			glu.gluOrtho2D(0.0f, 0.0f, width, height);
			gl.glColor3f(color[0], color[1], color[1]);
			gl.glPointSize(10.0f);
			gl.glBegin(GL2.GL_POINTS);
			gl.glVertex2f((datasX[datasX.length - 2] - tempX)/tempX - 0.05f, (tempY - datasY[datasY.length - 2])/tempY + 0.05f);
			gl.glVertex2f((datasX[datasX.length - 1] - tempX)/tempX + 0.05f, (tempY - datasY[datasY.length - 2])/tempY + 0.05f);
			gl.glVertex2f((datasX[datasX.length - 2] - tempX)/tempX - 0.05f, (tempY - datasY[datasY.length - 1])/tempY - 0.05f);
			gl.glVertex2f((datasX[datasX.length - 1] - tempX)/tempX + 0.05f, (tempY - datasY[datasY.length - 1])/tempY - 0.05f);
			gl.glEnd();
			gl.glFlush();
		}
	}
}
