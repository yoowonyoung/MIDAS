import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 * 실제 편집화면 탭 하나를 구성하게될 패널클래스
 * 
 * @author dnjsd
 *
 */
public class EditPanel extends JPanel implements MouseListener, MouseMotionListener {
	private PanelInformation info;
	private Location arrorwlocation;
	private boolean doubleClick = false;

	public EditPanel(PanelInformation info) {
		this.info = info;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		initUI();
	}

	public void initUI() {
		setBackground(Color.white);
	}

	/**
	 * 배경의 격자무늬를 생성하기 위해 PaintComponent 사용
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		removeAll();
		g.setColor(Color.GRAY);
		for (int x = 0; x < 980; x++) {
			g.drawLine(x, 0, x, 944);
			x += 24;
		}
		for (int y = 0; y < 944; y++) {
			g.drawLine(0, y, 980, y);
			y += 24;
		}

		for(int i = 0; i < info.getClassList().size(); i++){
			drawClass(info.getClassList().get(i), i);

		}

		for (RelationshipArrow arrow : info.getRelationshipArrowList()) {
			Location location = arrow.getArrowLocation();
			g.drawLine(location.getStartX(), location.getStartY(), location.getEndX(), location.getEndY());
		}

	}

	private void drawClass(ClassObject classObj, int index) {
		ClassPanel classPanel = new ClassPanel(classObj, this , index);
		
		Location location = classObj.getClassLocation();
		classPanel.setSize(classObj.getWidth()*20 + 10, classObj.getHeight()*20 + 25);
		classPanel.setLocation(location.getStartX(), location.getStartY());
		classPanel.setBackground(Color.white);
		classPanel.setBorder(new LineBorder(Color.black));
		add(classPanel);
	}

	private void drawArrow(RelationshipArrow arrow) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if (MainFrame.mode.equals("Class")) {
			info.addClassObject(new ClassObject("New Class" + (info.getClassList().size() + 1),
					new Location(e.getX(), e.getY(), e.getX() + 100, e.getY() + 200)));
			MainFrame.mode = "Normal";
			repaint();
		}
		if(MainFrame.mode.equals("Dependency") && this.doubleClick){
			this.doubleClick = false;
			MainFrame.mode = "Normal";
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
		
		
		if (MainFrame.mode.equals("Dependency")) {
			arrorwlocation = new Location(e.getX(), e.getY(), 0, 0);
			ArrayList<ClassObject> list = info.getClassList();
			int size = list.size();
			for (int i = size - 1; i >= 0; i--) {
				if (list.get(i).getClassLocation().calculateBondary(arrorwlocation)) {
					Location classLocation = list.get(i).getClassLocation();
					arrorwlocation.setStartX((classLocation.getStartX() + classLocation.getEndX()) / 2);
					arrorwlocation.setStartX(classLocation.getStartY());
					break;
				}
			}
		}
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (MainFrame.mode.equals("Dependency")) {
			arrorwlocation.setEndX(e.getX());
			arrorwlocation.setEndY(e.getY());
			info.addRelationshipArrow(new RelationshipArrow(arrorwlocation, "Dependency"));

			MainFrame.mode = "Normal";
		}
		repaint();
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (MainFrame.mode.equals("Dependency")) {
			if(info.getRelationshipArrowList().size() != 0){
				info.getRelationshipArrowList().remove(info.getRelationshipArrowList().size()-1);
			}
			
			arrorwlocation.setEndX(e.getX());
			arrorwlocation.setEndY(e.getY());
			info.addRelationshipArrow(new RelationshipArrow(arrorwlocation, "Dependency"));
			repaint();
		}
		

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub


	}
	public void changeClassInfo(ClassObject classObj, int index) {
		info.getClassList().set(index, classObj);
		System.out.println("change info => width = " + (classObj.getWidth()*20 + 10) + " , " + "height = " + classObj.getHeight()*20 + 25);
		validate();
		repaint();

	}

	public PanelInformation getInfo() {
		return info;
	}

	public void setInfo(PanelInformation info) {
		this.info = info;
	}

	public Location getArrorwlocation() {
		return arrorwlocation;
	}

	public void setArrorwlocation(Location arrorwlocation) {
		this.arrorwlocation = arrorwlocation;
	}

	public boolean isDoubleClick() {
		return doubleClick;
	}

	public void setDoubleClick(boolean doubleClick) {
		this.doubleClick = doubleClick;
	}
	
	
}
