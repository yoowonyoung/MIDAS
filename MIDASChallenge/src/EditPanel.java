import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
/**
 * 실제 편집화면 탭 하나를 구성하게될 패널클래스
 * @author dnjsd
 *
 */
public class EditPanel extends JPanel implements MouseListener{
	private PanelInformation info;
	
	public EditPanel(PanelInformation info) {
		this.info = info;
		initUI();
	}
	
	public void initUI() {
		setBackground(Color.white);
	}
	/**
	 * 배경의 격자무늬를 생성하기 위해 PaintComponent 사용
	 */
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		removeAll();

		for(int x = 0; x < 980; x++) {
			g.drawLine(x, 0, x, 944);
			x+= 24;
		}
		for(int y = 0; y < 944; y++) {
			g.drawLine(0, y, 980, y);
			y+= 24;
		}
		//g.drawLine(x1, y1, x2, y2);
		for(int i = 0; i < info.getClassList().size(); i++){
			drawClass(info.getClassList().get(i));
		}
	}
	
	private void drawClass(ClassObject classObj) {
		JTextArea className = new JTextArea(classObj.getClassName());
		Location location = classObj.getClassLocation();
		className.setLocation(location.getStartX(), location.getStartY());
		className.setSize(classObj.getWidth()*25 + 10, 25);
		className.setBackground(Color.WHITE);
		className.setBorder(new LineBorder(Color.black));
		//JTextArea attributes = new JTextArea(classObj.get);
		add(className);
		JList attributes = new JList(classObj.getAttributes().toArray());
		attributes.setLocation(location.getStartX(), location.getStartY() + 25);
		attributes.setSize(classObj.getWidth()*25 + 10, classObj.getAttributes().size()*25);
		attributes.setBackground(Color.WHITE);
		attributes.setBorder(new LineBorder(Color.black));
		add(attributes);
		JList operations = new JList(classObj.getOperations().toArray());
		operations.setLocation(location.getStartX(), location.getStartY() + 25 + classObj.getOperations().size()*25);
		operations.setSize(classObj.getWidth()*25 + 10, classObj.getOperations().size()*25);
		operations.setBackground(Color.WHITE);
		operations.setBorder(new LineBorder(Color.black));
		add(operations);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		repaint();
	}
}
