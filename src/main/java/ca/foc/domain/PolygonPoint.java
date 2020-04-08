package ca.foc.domain;

/**
 * ******************************************** **
 * Polygon - ca.foc.domain.Polygon
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
public class PolygonPoint {
	/**
	 *  Coordinates at geographic coordinate system
	 *  Constraints: Not Null
	 */
    private double latitude;
    /**
	 *  Coordinates at geographic coordinate system
	 *  Constraints: Not Null
	 */
    private double longitude;

    public PolygonPoint(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
