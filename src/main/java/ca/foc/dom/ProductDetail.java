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
	
	private boolean isFavourite;
	
	
	//Constructors
	public ProductDetail() {

	}

	public ProductDetail(String coordinates, int regionId, String regionName, int productId, String name, boolean isFavourite) {
		this.coordinates = coordinates;
		this.regionId = regionId;
		this.regionName= regionName;
		this.productId = productId;
		this.name = name;
		this.isFavourite=isFavourite;

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
	public boolean getIsfavourite() {
		return isFavourite;
	}
	
	public void setIsFavourite(boolean isFavourite) {
		this.isFavourite= isFavourite;
	}

	



	
	

}
