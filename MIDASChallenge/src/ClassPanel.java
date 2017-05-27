import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * 클래스 하나를 그리기 위한 패널
 * @author dnjsd
 *
 */
public class ClassPanel extends JPanel implements MouseListener{
	private JTextField className;
	private JTable attributes;
	private JTable operations;
	private Location location;
	private ClassObject classObjData;
	public ClassPanel(ClassObject classObj) {
		this.classObjData = classObj;
		className = new JTextField(classObjData.getClassName());
		location = classObj.getClassLocation();
		className.setLocation(0, 0);
		className.setSize(classObj.getWidth()*25 + 10, 25);
		className.setBackground(Color.WHITE);
		className.setBorder(new LineBorder(Color.black));
		className.addMouseListener(this);
		className.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				classObjData.setClassName(className.getText());
			}
		});
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
		ListSelectionModel attributeSelectionModel = attributes.getSelectionModel();
		attributeSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				operations.clearSelection();
			}
		});
		attributes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = attributes.getSelectedRow();
					int column = attributes.getSelectedColumn();
					ArrayList<String> beforeData = classObj.getAttributes();
					beforeData.set(row, (String) attributes.getValueAt(row, column));
					classObjData.setAttributes(beforeData);
				}
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
		ListSelectionModel operationSelectionModel = operations.getSelectionModel();
		operationSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
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

}
