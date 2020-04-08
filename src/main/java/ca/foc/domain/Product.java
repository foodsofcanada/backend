package ca.foc.domain;

import javax.persistence.*;
/**
 * ******************************************** **
 * Product - ca.foc.domain.Pantry
 * This product class represent the product in Product Table
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * 
 * Claudia Rivera: configuration of Spring Boot annotations
 * * ********************************************* **
 */
@Entity
@Table(name = "foc_products")
public class Product {
	/**
	 * Integer to identify a product: primary key
	 * Constraints: Not Null
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prod_id")
	private int productId;
	/**
	 * Name of the product.
	 * Constrainst: Not Null
	 */
	private String name;
	/**
	 * Physical description of product
	 */
	private String description;
	/**
	 * 
	 */
	private String season;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * Product picture path
	 */
	private String img_path;
	/**
	 * The length of time that product may be stored without becoming unfit for consumption
	 */
	private String shelf_life;
	/**
	 * Products additional dangers such as: toxicity,  food additives, banned ingredients etc.
	 */
	private String danger;
	/**
	 * Description of growth phases
	 */
	private String growth_phases;
	/**
	 * Scientific or biological name of product
	 */
	private String scientific_name;
	/**
	 * History of product, migration
	 */
	private String history;
	/**
	 * General cooking uses of the product
	 */
	private String cooking_use;
	/**
	 * Methods by which food is kept from spoilage after harvest or slaughter.
	 * Drying, refrigeration, and fermentation, canning, pasteurization, freezing, irradiation, and the addition of chemicals
	 */
	private String preservation;
	/**
	 * Fun and interesting facts about product
	 */
	private String fun_fact;
	/**  
     *Name of the country of origin of the product
	 */
	private String origin_country;
	private Integer search_counter;
	
	/**
	 * Default constructor
	 */
	public Product() {
	}
	/**
	 * constructor with attributtes
	 * @param name
	 * @param description
	 * @param season
	 * @param age
	 * @param img_path
	 * @param shelf_life
	 * @param danger
	 * @param growth_phases
	 * @param scientific_name
	 * @param history
	 * @param cooking_use
	 * @param preservation
	 * @param fun_fact
	 * @param origin_country
	 */
	public Product(String name, String description, String season, Integer age, String img_path, String shelf_life,
			String danger, String growth_phases, String scientific_name, String history, String cooking_use,
			String preservation, String fun_fact, String origin_country) {
		this.name = name;
		this.description = description;
		this.season = season;
		this.age = age;
		this.img_path = img_path;
		this.shelf_life = shelf_life;
		this.danger = danger;
		this.growth_phases = growth_phases;
		this.scientific_name = scientific_name;
		this.history = history;
		this.cooking_use = cooking_use;
		this.preservation = preservation;
		this.fun_fact = fun_fact;
		this.origin_country = origin_country;
	}

	// Getters and setters
	
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
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

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getShelf_life() {
		return shelf_life;
	}

	public void setShelf_life(String shelf_life) {
		this.shelf_life = shelf_life;
	}

	public String getDanger() {
		return danger;
	}

	public void setDanger(String danger) {
		this.danger = danger;
	}

	public String getGrowth_phases() {
		return growth_phases;
	}

	public void setGrowth_phases(String growth_phases) {
		this.growth_phases = growth_phases;
	}

	public String getScientific_name() {
		return scientific_name;
	}

	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCooking_use() {
		return cooking_use;
	}

	public void setCooking_use(String cooking_use) {
		this.cooking_use = cooking_use;
	}

	public String getPreservation() {
		return preservation;
	}

	public void setPreservation(String preservation) {
		this.preservation = preservation;
	}

	public String getFun_fact() {
		return fun_fact;
	}

	public void setFun_fact(String fun_fact) {
		this.fun_fact = fun_fact;
	}

	public String getOrigin_country() {
		return origin_country;
	}

	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}
	public Integer getSearch_counter() {
		return search_counter;
	}

	public void setSearch_counter(Integer search_counter) {
		this.search_counter = search_counter;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", season="
				+ season + ", age=" + age + ", img_path=" + img_path + ", shelf_life=" + shelf_life + ", danger="
				+ danger + ", growth_phases=" + growth_phases + ", scientific_name=" + scientific_name + ", history="
				+ history + ", cooking_use=" + cooking_use + ", preservation=" + preservation + ", fun_fact=" + fun_fact
				+ ", origin_country=" + origin_country + ", search_counter=" + search_counter + "]";
	}


}
