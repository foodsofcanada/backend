package ca.foc.dom;

public class FavouriteResponse {
	
	
	private int productId;
	private String name;
	private int regionId;
	private String regionName;
	private String coordinate;
	private boolean isFavourite;

	//Constructors
	public FavouriteResponse() {
		
	}

	public FavouriteResponse(String coordinates, int regionId, String regionName, int productId, String name, boolean isFavourite) {
		this.coordinate = coordinates;
		this.regionId = regionId;
		this.regionName= regionName;
		this.productId = productId;
		this.name = name;
		this.isFavourite=isFavourite;

	}


	//Getters and setters
	public String getCoordinates() {
		return coordinate;
	}

	public void setCoordinates(String coordinates) {
		this.coordinate = coordinates;
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
	public boolean getIsFavourite() {
		return isFavourite;
	}
	
	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite= isFavourite;
	}
	@Override
	public String toString() {
		return "FavouriteResponse productId=" + productId
				+ ", regionId=" + regionId + ", coordinate=" + coordinate + "]";
	}
	
	
	
	
}
