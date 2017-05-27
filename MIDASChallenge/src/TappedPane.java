import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * 화면 우측 탭들을 담는 Pane
 * @author dnjsd
 *
 */
public class TappedPane extends JTabbedPane {
	private ArrayList<PanelInformation> infos = new ArrayList<PanelInformation>();
	
	public TappedPane() {
		initUI();
		//this.getSelectedIndex();
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

		PanelInformation info = new PanelInformation("info1");
		info.addClassObject(new ClassObject("Test1", arrtibutes, operations, location, null, null));
		EditPanel jp1 = new EditPanel(info);

		arrtibutes.add("attr3");
		operations.add("op3");
		infos.add(info);
		PanelInformation info2 = new PanelInformation("info2");
		info2.addClassObject(new ClassObject("Test1", arrtibutes, operations, location, null, null));
		EditPanel jp2 = new EditPanel(info2);
		infos.add(info2);
		
		addTab("tap1", jp1);
		addTab("tap2", jp2);
		

	}
	
	public void addInfo(PanelInformation getInfo){
		this.infos.add(getInfo);
	}

	public ArrayList<PanelInformation> getInfos() {
		return infos;
	}

	public void setInfos(ArrayList<PanelInformation> infos) {
		this.infos = infos;
	}
	
	public PanelInformation getNowSelectedInfo(){
		return infos.get(this.getSelectedIndex());
	}
}
