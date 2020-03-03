package ca.foc.domain;



import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="foc_product_region")
public class ProductRegion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private long prod_id;
	@Id
	private int reg_id;
	
	
	//getters and setters
	
	
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public int getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	
	
}
