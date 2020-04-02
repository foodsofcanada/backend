package ca.foc.dom;

public class FavouriteResponse {
	
	
	//String name;
	int productId;
	int regionId;
	String coordinate;
	boolean isFavourite;

	//Constructors
	public FavouriteResponse() {
		
	}

	public FavouriteResponse( int productId, int regionId, String coordinate,boolean isFavourite) {
 
		//this.name = name;
		this.productId = productId;
		this.regionId = regionId;
		this.coordinate = coordinate;
		this.isFavourite = isFavourite;
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

	public boolean getIsFavourite() {
		return isFavourite;
	}

	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite = isFavourite;
	}

	@Override
	public String toString() {
		return "FavouriteResponse productId=" + productId
				+ ", regionId=" + regionId + ", coordinate=" + coordinate + "]";
	}
	
	
	
	
}
