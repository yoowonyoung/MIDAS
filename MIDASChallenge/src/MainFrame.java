import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 화면을 구성하게될 메인 프레임, 상단목록과 좌측 사이드바, 편집화면을 가지게됨
 * @author dnjsd
 *
 */
public class MainFrame extends JFrame{
	private int width = 1280;
	private int height = 1024;
	
	public MainFrame() {
		initUI();
	}
	
	/**
	 * UI를 초기화 하는 메서드
	 */
	public void initUI() {
		setSize(width, height);
		createMenuBar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
		setVisible(true);
	    setTitle("MIDAS_UML");
	}
	
	/**
	 * 메뉴바를 만드는 메서드
	 */
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		ImageIcon fileIcon = new ImageIcon(System.getProperty("user.dir")+"\\images\\fileIcon.png");
		file.setMnemonic(KeyEvent.VK_F);
		file.setIcon(fileIcon);
		JMenu undo = new JMenu("Undo");
		ImageIcon undoIcon = new ImageIcon(System.getProperty("user.dir")+"\\images\\undoIcon.png");
		undo.setMnemonic(KeyEvent.VK_U);
		undo.setIcon(undoIcon);
		JMenu redo = new JMenu("Redo");
		ImageIcon redoIcon = new ImageIcon(System.getProperty("user.dir")+"\\images\\redoIcon.png");
		redo.setMnemonic(KeyEvent.VK_R);
		redo.setIcon(redoIcon);
		JMenuItem newFile = new JMenuItem("New");
		newFile.setToolTipText("새로 파일을 만듭니다");
		JMenuItem openFile = new JMenuItem("Open File");
		openFile.setToolTipText("파일을 불러옵니다");
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.setToolTipText("파일을 저장합니다");
		JMenuItem saveAsFile = new JMenuItem("Save As...");
		saveAsFile.setToolTipText("파일을 다른 이름으로 저장합니다");
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(saveAsFile);
		menuBar.add(file);
		menuBar.add(undo);
		menuBar.add(redo);
		setJMenuBar(menuBar);
	}
	
}
