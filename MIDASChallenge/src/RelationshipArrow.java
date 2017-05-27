/**
 * 클래스간의 관계 정보를 저장하는 클래스
 * @author dnjsd
 *
 */
public abstract class RelationshipArrow {
	private ClassObject fromObject;
	private ClassObject toObject;
	private Location arrowLocation;
	
	public RelationshipArrow(ClassObject fromObject, ClassObject toObject, int startX, int startY, int endX, int endY) {
		setFromObject(fromObject);
		setToObject(toObject);

	}
	
	public ClassObject getFromObject() {
		return fromObject;
	}
	public void setFromObject(ClassObject fromObject) {
		this.fromObject = fromObject;
	}
	public ClassObject getToObject() {
		return toObject;
	}
	public void setToObject(ClassObject toObject) {
		this.toObject = toObject;
	}

	public Location getArrowLocation() {
		return arrowLocation;
	}

	public void setArrowLocation(Location arrowLocation) {
		this.arrowLocation = arrowLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrowLocation == null) ? 0 : arrowLocation.hashCode());
		result = prime * result + ((fromObject == null) ? 0 : fromObject.hashCode());
		result = prime * result + ((toObject == null) ? 0 : toObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelationshipArrow other = (RelationshipArrow) obj;
		if (arrowLocation == null) {
			if (other.arrowLocation != null)
				return false;
		} else if (!arrowLocation.equals(other.arrowLocation))
			return false;
		if (fromObject == null) {
			if (other.fromObject != null)
				return false;
		} else if (!fromObject.equals(other.fromObject))
			return false;
		if (toObject == null) {
			if (other.toObject != null)
				return false;
		} else if (!toObject.equals(other.toObject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RelationshipArrow [fromObject=" + fromObject + ", toObject=" + toObject + ", arrowLocation="
				+ arrowLocation + "]";
	}

	
	
	
	
	
}
