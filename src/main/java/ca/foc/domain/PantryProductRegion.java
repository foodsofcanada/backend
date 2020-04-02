package ca.foc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foc_pantry_product_region")
public class PantryProductRegion {
	
	@Id
	@Column(name= "pantry_id")
	private int pantryId;
	@Column(name= "reg_id")
	private int regionId;
	@Column(name= "prod_id")
	private int productId;
	//private String coordinates;
	
	public PantryProductRegion() {
		
	}
	
	public PantryProductRegion(int pantryId, int regionId, int productId) {
		
		this.pantryId = pantryId;
		this.regionId = regionId;
		this.productId = productId;
	//	this.coordinates = coordinates;
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

//	public String getCoordinates() {
//		return coordinates;
//	}
//
//	public void setCoordinates(String coordinates) {
//		this.coordinates = coordinates;
//	}
	
	
	

}
