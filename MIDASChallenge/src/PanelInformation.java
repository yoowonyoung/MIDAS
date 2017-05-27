import java.io.Serializable;
import java.util.ArrayList;

/**
 * 화면을 구성하는 패널의 정보를 저장하는데 사용하는 클래스
 * 
 * @author dnjsd
 *
 */
public class PanelInformation implements Serializable{
	private ArrayList<ClassObject> classList;
	private ArrayList<RelationshipArrow> arrowList;
	
	
	
	public PanelInformation() {
		classList = new ArrayList<ClassObject>();
		arrowList= new ArrayList<RelationshipArrow>();
	}



	public void addClass(ClassObject obj){
		
	}
}
