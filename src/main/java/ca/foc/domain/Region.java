package ca.foc.domain;

import java.util.List;
/**
 * ******************************************** **
 * Region - ca.foc.domain.Region
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
public class Region {

    private long reg_id;
    private String type;
    private List<PolygonPoint> points;
    private List<Product> productsInRegion;

    public Region(long reg_id, String type, List<PolygonPoint> points, List<Product> productsInRegion) {
        this.reg_id = reg_id;
        this.type = type;
        this.points = points;
        this.productsInRegion = productsInRegion;
    }

    public long getReg_id() {
        return reg_id;
    }

    public void setReg_id(long reg_id) {
        this.reg_id = reg_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PolygonPoint> getPoints() {
        return points;
    }

    public void setPoints(List<PolygonPoint> points) {
        this.points = points;
    }

    public List<Product> getProductsInRegion() {
        return productsInRegion;
    }

    public void setProductsInRegion(List<Product> productsInRegion) {
        this.productsInRegion = productsInRegion;
    }
}
