import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JPanel;
/**
 * 실제 편집화면 탭 하나를 구성하게될 패널클래스
 * @author dnjsd
 *
 */
public class EditPanel extends JPanel {
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
		for(int x = 0; x < 980; x++) {
			g.drawLine(x, 0, x, 944);
			x+= 24;
		}
		for(int y = 0; y < 944; y++) {
			g.drawLine(0, y, 980, y);
			y+= 24;
		}
		//g.drawLine(x1, y1, x2, y2);
	}
}
