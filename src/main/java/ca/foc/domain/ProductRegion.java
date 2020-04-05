package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * 
 * Class to represent ProductRegion Table in database
 * 
 * @author Claudia Rivera
 *
 */


@Entity
@IdClass(ProductRegion.class)
@Table(name = "foc_product_region")
public class ProductRegion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name= "prod_id")
	private int productId;
	@Id
	@Column(name= "reg_id")
	private int regionId;
	
	private String coordinate ;

	// Constructors
	public ProductRegion() {
		
	}
	
	
	public ProductRegion(int productId, int regionId, String coordinate) {
		super();
		this.productId = productId;
		this.regionId = regionId;
		this.coordinate = coordinate;
	}

	//getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	

}
