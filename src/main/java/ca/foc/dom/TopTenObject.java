package ca.foc.dom;

public class TopTenObject {
	private int productId;
	private String name;
	private int regionId;
	private String regionName;
	private String coordinates;
	
	

	public TopTenObject() {
		
	}

	
	public TopTenObject(int productId, String name, int regionId, String regionName, String coordinates) {
		
		this.productId = productId;
		this.name = name;
		this.regionId = regionId;
		this.regionName = regionName;
		this.coordinates = coordinates;
	}


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


	public String getCoordinates() {
		return coordinates;
	}


	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}


	@Override
	public String toString() {
		return "Top Ten products: [prod_id=" + productId + ", name=" + name +  ", reg_id=" + regionId
				+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
	}

}
