package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
/**
 * 
 * Entity to represent foc_pantry_product_region table in database
 * @author Mariia Voronina
 * 
 * Claudia: configuration to have a composite primary key: Pantry_id, Product_id, region_id
 *
 */
@Entity
@IdClass(PantryProductRegion.class)
@Table(name = "foc_pantry_product_region")
public class PantryProductRegion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name= "pantry_id")
	private int pantryId;
	@Id
	@Column(name= "reg_id")
	private int regionId;
	@Id
	@Column(name= "prod_id")
	private int productId;
	private String coordinate;
	
	public PantryProductRegion() {
		
	}
	
	public PantryProductRegion(int pantryId, int regionId, int productId, String coordinate) {
		
		this.pantryId = pantryId;
		this.regionId = regionId;
		this.productId = productId;
		this.coordinate = coordinate;
	}

	public int getPantryId() {
		return pantryId;
	}

	public void setPantryId(int pantryId) {
		this.pantryId = pantryId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	
	
	

}
