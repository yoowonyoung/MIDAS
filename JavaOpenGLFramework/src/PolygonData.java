/**
 * 다각형의 정보를 저장하는 Class
 * @author wonyoung
 *
 */
public class PolygonData {
	private float arrX[] = new float[2];
	private float arrY[] = new float[2];
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
	 * 도형의 좌 상단의 X,Y 좌표를 저장하는 메서드
	 * @param leftTopX 좌 상단 X좌표
	 * @param leftTopY 좌 상단 Y좌표
	 */
	public void setLeftXY(float leftTopX, float leftTopY) {
		arrX[0] = leftTopX;
		arrY[0] = leftTopY;
	}
	/**
	 * 도형의 우 하단의 X,Y좌표를 저장하는 메서드
	 * @param rightBottomX 우 하단 X좌표
	 * @param rightBottomY 우 하단 Y좌표
	 */
	public void setRightXY(float rightBottomX, float rightBottomY) {
		arrX[1] = rightBottomX;
		arrY[1] = rightBottomY;
	}
	/**
	 * 도형의 X좌표들을 반환해주는 메서드
	 * @return 도형의 X좌표의 배열
	 */
	public float[] getPolygonDataX() {
		return arrX;
	}
	/**
	 * 도형의 Y좌표들을 반환해주는 메서드
	 * @return 도형의 Y좌표의 배열
	 */
	public float[] getPolygonDataY() {
		return arrY;
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
		arrX[0] = arrX[1] = 0;
		arrY[0] = arrY[1] = 0;
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
}
