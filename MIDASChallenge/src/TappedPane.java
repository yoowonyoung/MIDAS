import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * 화면 우측 탭들을 담는 Pane
 * @author dnjsd
 *
 */
public class TappedPane extends JTabbedPane {
	private PanelInformation infos[] = new PanelInformation[2];
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
		ArrayList<String> arrtibutes = new ArrayList<String>();
		arrtibutes.add("attr1");
		arrtibutes.add("attr2");
		ArrayList<String> operations = new ArrayList<String>();
		operations.add("op1");
		operations.add("op2");
		Location location = new Location(100, 100, 200, 200);
		infos[0] = new PanelInformation();
		infos[0].addClassObject(new ClassObject("Test1", arrtibutes, operations, location, null, null));
		EditPanel jp1 = new EditPanel(infos[0]);
		arrtibutes.add("attr3");
		operations.add("op3");
		infos[1] = new PanelInformation();
		infos[1].addClassObject(new ClassObject("Test1", arrtibutes, operations, location, null, null));
		EditPanel jp2 = new EditPanel(infos[1]);
		
		addTab("tap1", jp1);
		addTab("tap2", jp2);
		

	}
}
