import java.awt.Color;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
/**
 * 클래스 하나를 그리기 위한 패널
 * @author dnjsd
 *
 */
public class ClassPanel extends JPanel {
	public ClassPanel(ClassObject classObj) {
		JTextArea className = new JTextArea(classObj.getClassName());
		Location location = classObj.getClassLocation();
		className.setLocation(0, 0);
		className.setSize(classObj.getWidth()*25 + 10, 25);
		className.setBackground(Color.WHITE);
		className.setBorder(new LineBorder(Color.black));
		//JTextArea attributes = new JTextArea(classObj.get);
		add(className);
		JList attributes = new JList(classObj.getAttributes().toArray());
		attributes.setLocation(0, 25);
		attributes.setSize(classObj.getWidth()*25 + 10, classObj.getAttributes().size()*20);
		attributes.setBackground(Color.WHITE);
		attributes.setBorder(new LineBorder(Color.black));
		add(attributes);
		JList operations = new JList(classObj.getOperations().toArray());
		operations.setLocation(0, classObj.getAttributes().size()*20 + 25);
		operations.setSize(classObj.getWidth()*25 + 10, classObj.getOperations().size()*20);
		operations.setBackground(Color.WHITE);
		operations.setBorder(new LineBorder(Color.black));
		add(operations);
		repaint();
	}
}
