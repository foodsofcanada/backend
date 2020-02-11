package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@IdClass(ProductRegion.class)
@Table(name="foc_product_region")
public class ProductRegion implements Serializable{
	@Id
//	private int prod_id;
	@ManyToOne
	@JoinColumn(name="prod_id")
	private Product product;
	@Id
//	private int reg_id;
	@ManyToOne
	@JoinColumn (name="reg_id")
	private Region region;
	

}
