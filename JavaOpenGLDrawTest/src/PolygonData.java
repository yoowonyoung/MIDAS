
public class PolygonData {
	private float arrX[] = new float[2];
	private float arrY[] = new float[2];
	private String ploygonType = "";
	private float[] color = {0.0f, 0.0f, 0.0f};
	
	private boolean isSelected = true;
	
	public void setPolygonType(String type) {
		this.ploygonType = type;
	}
	
	public void setLeftXY(float leftTopX, float leftTopY) {
		arrX[0] = leftTopX;
		arrY[0] = leftTopY;
	}
	
	public void setRightXY(float rightBottomX, float rightBottomY) {
		arrX[1] = rightBottomX;
		arrY[1] = rightBottomY;
	}
	
	public float[] getPolygonDataX() {
		return arrX;
	}
	
	public float[] getPolygonDataY() {
		return arrY;
	}
	
	public boolean getSelectInfo() {
		return this.isSelected;
	}
	
	public void changeSelect() {
		if(this.isSelected) {
			isSelected = false;
		}else {
			isSelected = true;
		}
	}
	
	public String getPolygonType() {
		return this.ploygonType;
	}
	
	public void clearData() {
		arrX[0] = arrX[1] = 0;
		arrY[0] = arrY[1] = 0;
		ploygonType = "";
		isSelected = false;
	}
	
	public void changeColor(float colorR, float colorG, float colorB) {
		color[0] = colorR;
		color[1] = colorG;
		color[2] = colorB;
	}
	
	public float[] getColor() {
		return color;
	}
}
