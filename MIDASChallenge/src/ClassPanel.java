import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 * 클래스 하나를 그리기 위한 패널
 * @author dnjsd
 *
 */
public class ClassPanel extends JPanel implements MouseListener, KeyListener{
	private JTextArea className;
	private JTable attributes;
	private JTable operations;
	private Location location;
	public ClassPanel(ClassObject classObj) {
		className = new JTextArea(classObj.getClassName());
		location = classObj.getClassLocation();
		className.setLocation(0, 0);
		className.setSize(classObj.getWidth()*25 + 10, 25);
		className.setBackground(Color.WHITE);
		className.setBorder(new LineBorder(Color.black));
		className.addMouseListener(this);
		//JTextArea attributes = new JTextArea(classObj.get);
		add(className);
		//String[] attr = new String[]{"attributes"};
		attributes = new JTable(convertData(classObj.getAttributes()),new Object[]{"Attributes"});
		//attributes = new JTable(classObj.getAttributes().toArray());
		attributes.setTableHeader(null);
		attributes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		attributes.setLocation(0, 25);
		attributes.getColumnModel().getColumn(0).setWidth(classObj.getWidth()*25 + 10);
		attributes.setSize(classObj.getWidth()*25 + 10, classObj.getAttributes().size()*20);
		attributes.setBackground(Color.WHITE);
		attributes.setBorder(new LineBorder(Color.black));
		ListSelectionModel selectionModel = attributes.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				operations.clearSelection();
			}
		});
		add(attributes);
		operations = new JTable(convertData(classObj.getOperations()),new Object[]{"Operations"});
		operations.setTableHeader(null);
		operations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		operations.getColumnModel().getColumn(0).setWidth(classObj.getWidth()*25 + 10);
		operations.setLocation(0, classObj.getAttributes().size()*20 + 25);
		operations.setSize(classObj.getWidth()*25 + 10, classObj.getOperations().size()*20);
		operations.setBackground(Color.WHITE);
		operations.setBorder(new LineBorder(Color.black));
		operations.setBorder(new LineBorder(Color.black));
		ListSelectionModel selectionModel2 = operations.getSelectionModel();
		selectionModel2.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				attributes.clearSelection();
			}
		});
		add(operations);
		repaint();
	}
	private Object[][] convertData(ArrayList<String> data) {
		Object[][] returnVal = new Object[data.size()][1];
		for(int i = 0; i < data.size(); i++) {
			returnVal[i][0] = data.get(i);
		}
		return returnVal;
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
		attributes.clearSelection();
		operations.clearSelection();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
