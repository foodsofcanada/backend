package ca.foc.dom;

public class TopTenObject {
	private int prod_id;
	private String name;
	private int reg_id;
	private String regionName;
	private String coordinates;
	
	

	public TopTenObject() {
		
	}

	public TopTenObject(String coordinates, int reg_id, String regionName, int prod_id, String name) {
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
		return "ProductDetail [prod_id=" + prod_id + ", name=" + name +  ", reg_id=" + reg_id
				+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
	}

}
