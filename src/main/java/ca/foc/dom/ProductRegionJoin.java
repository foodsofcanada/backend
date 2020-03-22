package ca.foc.dom;

public class ProductRegionJoin {
	
	private String coordinates;
	private int reg_id;
	private int prod_id;
	private String name;
	
	public ProductRegionJoin() {

	}

	public ProductRegionJoin(String coordinates, int reg_id, int prod_id, String name) {
		this.coordinates = coordinates;
		this.reg_id = reg_id;
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
		return "ProductDetail [prod_id=" + prod_id + ", name=" + name + ", reg_id=" + reg_id
				 + ", coordinates=" + coordinates + "]";
	}


}
