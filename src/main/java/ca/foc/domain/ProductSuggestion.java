package ca.foc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 787428
 *
 */


@Entity
@Table(name="foc_product_suggestion")
public class ProductSuggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String name;
	private String description;
	
	
	
	public ProductSuggestion( String name, String description) {
		super();
		
		this.name = name;
		this.description = description;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}




	@Override
	public String toString() {
		return "ProductSuggestion [id=" + id + ", name=" + name + ", description=" + description 
				+ "]";
	}
	
	
	
	

}
