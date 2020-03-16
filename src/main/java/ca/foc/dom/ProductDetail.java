package ca.foc.dom;

/*
 *
 */


public class ProductDetail {

	private int prod_id;
	private String name;
	private String season;
	private int reg_id;
	private String regionName;
	private String coordinates;
	// private String description;
	// private int age;
	// private String img_path;
	// private String shelf_life;
	// private String danger;
	// private String growth_phases;
	// private String scientific_name;
	// private String history;
	// private String cooking_use;
	// private String preservation;
	// private String fun_fact;
	// private String origin_country;
	// private int search_counter;
	

	public ProductDetail() {

	}

	public ProductDetail(String coordinates, int reg_id, String regionName, int prod_id, String name) {
		this.coordinates = coordinates;
		this.reg_id = reg_id;
		this.regionName= regionName;
		this.prod_id = prod_id;
		this.name = name;

	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int reg_id) {
		this.prod_id = reg_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductDetail [prod_id=" + prod_id + ", name=" + name + ", season=" + season + ", reg_id=" + reg_id
				+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
	}

//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getImg_path() {
//		return img_path;
//	}
//	public void setImg_path(String img_path) {
//		this.img_path = img_path;
//	}
//	public String getShelf_life() {
//		return shelf_life;
//	}
//	public void setShelf_life(String shelf_life) {
//		this.shelf_life = shelf_life;
//	}
//	public String getDanger() {
//		return danger;
//	}
//	public void setDanger(String danger) {
//		this.danger = danger;
//	}
//	public String getGrowth_phases() {
//		return growth_phases;
//	}
//	public void setGrowth_phases(String growth_phases) {
//		this.growth_phases = growth_phases;
//	}
//	public String getScientific_name() {
//		return scientific_name;
//	}
//	public void setScientific_name(String scientific_name) {
//		this.scientific_name = scientific_name;
//	}
//	public String getHistory() {
//		return history;
//	}
//	public void setHistory(String history) {
//		this.history = history;
//	}
//	public String getCooking_use() {
//		return cooking_use;
//	}
//	public void setCooking_use(String cooking_use) {
//		this.cooking_use = cooking_use;
//	}
//	public String getPreservation() {
//		return preservation;
//	}
//	public void setPreservation(String preservation) {
//		this.preservation = preservation;
//	}
//	public String getFun_fact() {
//		return fun_fact;
//	}
//	public void setFun_fact(String fun_fact) {
//		this.fun_fact = fun_fact;
//	}
//	public String getOrigin_country() {
//		return origin_country;
//	}
//	public void setOrigin_country(String origin_country) {
//		this.origin_country = origin_country;
//	}
//	public int getSearch_counter() {
//		return search_counter;
//	}
//	public void setSearch_counter(int search_counter) {
//		this.search_counter = search_counter;
//	}

	
	

}
