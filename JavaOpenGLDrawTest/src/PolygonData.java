
public class PolygonData {
	private float arrX[] = new float[2];
	private float arrY[] = new float[2];
	private String ploygonType = "";
	
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
	
	public String getPolygonType() {
		return this.ploygonType;
	}
}
