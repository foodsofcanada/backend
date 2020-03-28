package ca.foc.dom;

public class ProductRegionJoin {
	
	private String coordinates;
	private int regionId;
	private int productId;
	private String name;
	
	public ProductRegionJoin() {

	}

	
	public ProductRegionJoin(String coordinates, int regionId, int productId, String name) {
		this.coordinates = coordinates;
		this.regionId = regionId;
		this.productId = productId;
		this.name = name;
	}


	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
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

	public void setProductId(int prodId) {
		this.productId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
