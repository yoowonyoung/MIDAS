import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditPanel extends JTabbedPane {
	
	public EditPanel() {
		initUI();
	}
	
	public void initUI() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		addTab("tap1", jp1);
		addTab("tap2", jp2);
		addTab("tap3", jp3);
		addTab("tap4", jp4);
	}
}
