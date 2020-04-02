package ca.foc.dom;
/**
 * Class to sent a response to the front end. Top ten Table
 * @author Claudia Rivera
 *
 */

public class TopTenObject {
	private int productId;
	private String name;
	private int regionId;
	private String regionName;
	private String coordinates;
	private boolean isFavourite;
	
	

	public TopTenObject() {
		
	}

	
	public TopTenObject(int productId, String name, int regionId, String regionName, String coordinates, boolean isFavourite) {
		
		this.productId = productId;
		this.name = name;
		this.regionId = regionId;
		this.regionName = regionName;
		this.coordinates = coordinates;
		this.isFavourite= isFavourite;
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
	
	public boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	@Override
	public String toString() {
		return "Top Ten products: [prod_id=" + productId + ", name=" + name +  ", reg_id=" + regionId
				+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
	}

}
