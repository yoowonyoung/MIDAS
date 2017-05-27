import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * 화면 우측 탭들을 담는 Pane
 * @author dnjsd
 *
 */
public class TappedPane extends JTabbedPane {
	
	public TappedPane() {
		initUI();
	}
	
	public void initUI() {
		setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
			@Override
			protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
				return 40;
			}
		});
		//큐를 이용해서 패널 정보를 불러 와야함
		EditPanel jp1 = new EditPanel();
		EditPanel jp2 = new EditPanel();
		EditPanel jp3 = new EditPanel();
		EditPanel jp4 = new EditPanel();
		addTab("tap1", jp1);
		addTab("tap2", jp2);
		addTab("tap3", jp3);
		addTab("tap4", jp4);
	}
}
