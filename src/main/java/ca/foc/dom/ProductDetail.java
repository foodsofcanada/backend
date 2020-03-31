package ca.foc.dom;

/**
 * Class to return object response for searching
 * @author Claudia Rivera
 */



public class ProductDetail {

	private int productId;
	private String name;
	private int regionId;
	private String regionName;
	private String coordinates;
	
	
	//Constructors
	public ProductDetail() {

	}

	public ProductDetail(String coordinates, int regionId, String regionName, int productId, String name) {
		this.coordinates = coordinates;
		this.regionId = regionId;
		this.regionName= regionName;
		this.productId = productId;
		this.name = name;

	}

	//Getters and setters
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

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int regionId) {
		this.productId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductDetail [productId=" + productId + ", name=" + name + ", regionId=" + regionId
				+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
	}



	
	

}
