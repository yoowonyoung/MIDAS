import java.util.ArrayList;

/**
 * 다각형의 정보를 저장하는 Class
 * @author wonyoung
 *
 */
public class PolygonData {
	private ArrayList<Float> arrX = new ArrayList<Float>();
	private ArrayList<Float> arrY = new ArrayList<Float>();
	//private float arrX[] = new float[2];
	//private float arrY[] = new float[2];
	private boolean isInputted = false;
	private String ploygonType = "";
	private float[] color = {0.0f, 0.0f, 0.0f};
	
	private boolean isSelected = true;
	/**
	 * 어떤 도형의 정보를 가지고 있는지를 설정하는 메서드
	 * @param type 사각형(R), 삼각형(T), 원(C) 
	 */
	public void setPolygonType(String type) {
		this.ploygonType = type;
	}
	/**
	 * 도형의 X,Y 좌표를 저장하는 메서드
	 * @param locationX X의 좌표
	 * @param locationY Y의 좌표
	 */
	public void addLocatinXY(float locationX, float locationY) {
		arrX.add(locationX);
		arrY.add(locationY);
	}
	
	public void changeLastLocationXY(float locationX, float locationY) {
		arrX.remove(arrX.size()-1);
		arrX.add(locationX);
		arrY.remove(arrY.size()-1);
		arrY.add(locationY);
		
	}
	
	/**
	 * 도형의 X좌표들을 반환해주는 메서드
	 * @return 도형의 X좌표의 배열
	 */
	public Float[] getPolygonDataX() {
		Float returnX[] = new Float[arrX.size()];
		returnX = arrX.toArray(returnX);
		return returnX;
	}
	/**
	 * 도형의 Y좌표들을 반환해주는 메서드
	 * @return 도형의 Y좌표의 배열
	 */
	public Float[] getPolygonDataY() {
		Float returnY[] = new Float[arrY.size()];
		returnY = arrY.toArray(returnY);
		return returnY;
	}
	/**
	 * 도형이 선택되었는지를 나타내는 메서드
	 * @return 도형이 선택되었는지 아닌지를 나타내는 boolean 변수
	 */
	public boolean getSelectInfo() {
		return this.isSelected;
	}
	/**
	 * 도형이 선택되었는지를 나타내는 변수값을 바꾸는 메서드
	 */
	public void changeSelect() {
		if(this.isSelected) {
			isSelected = false;
		}else {
			isSelected = true;
		}
	}
	/**
	 * 도형의 정보(모양)을 반환해주는 메서드
	 * @return 사각형(R), 삼각형(T), 원(C)
	 */
	public String getPolygonType() {
		return this.ploygonType;
	}
	/**
	 * 현재 가지고있는 도형의 정보를 초기화 해주는 메서드
	 */
	public void clearData() {
		arrX.clear();
		arrY.clear();
		ploygonType = "";
		isSelected = false;
	}
	/**
	 * 도형의 색상을 설정하는 메서드
	 * @param color R,G,B값을 가지고있는 float 배열 
	 */
	public void changeColor(float color[]) {
		this.color = color;
	}
	/**
	 * 도형의 색상을 반환하는 메서드
	 * @return R,G,B값을 가지고있는 float 배열
	 */
	public float[] getColor() {
		return color;
	}
	
	/**
	 * 도형의 정보가 입력되었는지 판별하기 위한 정보를 가져오는 메서드
	 * @return 도형의 정보가 입력됬으면 true
	 */
	public boolean getInpputedData() {
		return isInputted;
	}
	
	/**
	 * 도형의 정보가 입력되었다고 명시하는 메서드
	 */
	public void markInpputed() {
		this.isInputted = true;
	}
}
