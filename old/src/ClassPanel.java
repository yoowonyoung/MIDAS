import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class ClassPanel extends JPanel implements MouseListener,MouseMotionListener{
	private JTextField className;
	private JTable attributes;
	private JTable operations;
	private Location location;
	private ClassObject classObjData;
	private EditPanel BelongToEditPanel;
	private int index;
	private boolean dubbletab = false;
	private boolean doubleClick = false;
	private Location arrorwlocation;
	
	public ClassPanel(ClassObject classObj, EditPanel editPanel, int index) {
		this.classObjData = classObj;
		this.BelongToEditPanel = editPanel;
		this.index = index;
		initUI();
	}
	
	public void initUI() {
		className = new JTextField(classObjData.getClassName());
		location = classObjData.getClassLocation();
		className.setLocation(0, 0);
		className.setSize(classObjData.getWidth()*20 + 10, 25);
		className.setBackground(Color.WHITE);
		className.setBorder(new LineBorder(Color.black));
		className.addMouseListener(this);
		className.addMouseMotionListener(this);
		className.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					classObjData.setClassName(className.getText());
				}
			}
		});
		/*
		className.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				classObjData.setClassName(className.getText());
			}
		});*/
		//JTextArea attributes = new JTextArea(classObj.get);
		add(className);
		//String[] attr = new String[]{"attributes"};
		attributes = new JTable(convertData(classObjData.getAttributes()),new Object[]{"Attributes"});
		//attributes = new JTable(classObj.getAttributes().toArray());
		attributes.setTableHeader(null);
		attributes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		attributes.setLocation(0, 25);
		attributes.getColumnModel().getColumn(0).setWidth(classObjData.getWidth()*20 + 10);
		attributes.setSize(classObjData.getWidth()*20 + 10, classObjData.getAttributes().size()*20);
		attributes.setBackground(Color.WHITE);
		attributes.setBorder(new LineBorder(Color.black));
		attributes.addMouseListener(this);
		attributes.addMouseMotionListener(this);
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
					ArrayList<String> beforeData = classObjData.getAttributes();
					beforeData.set(row, (String) attributes.getValueAt(row, column));
					classObjData.setAttributes(beforeData);
				}else if(e.getKeyCode() == KeyEvent.VK_TAB) {
					if(!dubbletab) {
						dubbletab = true;
						ArrayList<String> beforeData = classObjData.getAttributes();
						beforeData.add("new attr"+ (beforeData.size()+1));
						classObjData.setAttributes(beforeData);
						validate();
						repaint();
						BelongToEditPanel.changeClassInfo(classObjData, index);
					}else {
						ArrayList<String> beforeData = classObjData.getOperations();
						beforeData.add("new op"+ (beforeData.size()+1));
						classObjData.setOperations(beforeData);
						validate();
						repaint();
						BelongToEditPanel.changeClassInfo(classObjData, index);
					}
					
				}
			}
		});
		add(attributes);
		operations = new JTable(convertData(classObjData.getOperations()),new Object[]{"Operations"});
		operations.setTableHeader(null);
		operations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		operations.getColumnModel().getColumn(0).setWidth(classObjData.getWidth()*20 + 10);
		operations.setLocation(0, classObjData.getAttributes().size()*20 + 25);
		operations.setSize(classObjData.getWidth()*20 + 10, classObjData.getOperations().size()*20);
		operations.setBackground(Color.WHITE);
		operations.setBorder(new LineBorder(Color.black));
		operations.addMouseListener(this);
		operations.addMouseMotionListener(this);
		ListSelectionModel operationSelectionModel = operations.getSelectionModel();
		operationSelectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				attributes.clearSelection();
			}
		});
		operations.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = operations.getSelectedRow();
					int column = operations.getSelectedColumn();
					ArrayList<String> beforeData = classObjData.getOperations();
					beforeData.set(row, (String) operations.getValueAt(row, column));
					classObjData.setAttributes(beforeData);
				}else if(e.getKeyCode() == KeyEvent.VK_TAB) {
					ArrayList<String> beforeData = classObjData.getOperations();
					beforeData.add("new op"+ (beforeData.size()+1));
					classObjData.setOperations(beforeData);
					validate();
					repaint();
					BelongToEditPanel.changeClassInfo(classObjData, index);
				}
			}
		});
		add(operations);
	}
	
	private Object[][] convertData(ArrayList<String> data) {
		Object[][] returnVal = new Object[data.size()][1];
		for(int i = 0; i < data.size(); i++) {
			returnVal[i][0] = data.get(i);
		}
		return returnVal;
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawLine(location.getStartX(), location.getStartY(), location.getEndX(), location.getEndY());
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
