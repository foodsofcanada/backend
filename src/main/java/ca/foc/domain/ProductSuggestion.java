package ca.foc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foc_product_suggestion")
public class ProductSuggestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private String name;
	private String description;
	private String type;
	
	
	public ProductSuggestion(int id, String name, String description, String type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "ProductSuggestion [id=" + id + ", name=" + name + ", description=" + description + ", type=" + type
				+ "]";
	}
	
	
	
	

}
