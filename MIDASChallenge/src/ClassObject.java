import java.util.ArrayList;
/**
 * 클래스 다이어그램의 클래스 정보를 저장하는데 사용하는 클래스
 * @author dnjsd
 *
 */
public class ClassObject {
	private String className;
	private ArrayList<String> arrtibutes;
	private ArrayList<String> operations;
	private int topLeftX,topLeftY,bottomRightX,bottomRightY;
	private RelationshipArrow myRelationshipArrow;
	private ClassObject myRelationClassObject;
}
