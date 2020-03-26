package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@IdClass(ProductRegion.class)
@Table(name = "foc_product_region")
public class ProductRegion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name= "prod_id")
	private int prodId;
	@Id
	private int reg_id;
	
	private String coordinate ;
	
	//getters and setters
	
	
	public long getProd_id() {
		return prodId;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public void setProd_id(int prod_id) {
		this.prodId = prod_id;
	}

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	@Override
	public String toString() {
		return "ProductRegion [prod_id=" + prodId + ", reg_id=" + reg_id + ", coordinate]";
	}
	
	

}
