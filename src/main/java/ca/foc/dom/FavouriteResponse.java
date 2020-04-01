package ca.foc.dom;

public class FavouriteResponse {
	
	boolean isFavourite;
	//String name;
	int productId;
	int regionId;
	String coordinate;

	//Constructors
	public FavouriteResponse() {
		
	}

	public FavouriteResponse( int productId, int regionId, String coordinate) {

	//	this.isFavourite = isFavourite;
		//this.name = name;
		this.productId = productId;
		this.regionId = regionId;
		this.coordinate = coordinate;
	}
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "FavouriteResponse productId=" + productId
				+ ", regionId=" + regionId + ", coordinate=" + coordinate + "]";
	}
	
	
	
	
}
