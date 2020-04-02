package ca.foc.dom;

/**
 * Class to create an object to respond when a member is signed on 
 * it includes a column to identify if a product is in the favourite list or not
 * @author 787428
 *
 */


public class ProductDetailFavourite {

		private int productId;
		private String name;
		private int regionId;
		private String regionName;
		private String coordinates;
		private boolean isFavourite;
		
		
		//Constructors
		public ProductDetailFavourite() {

		}

		public ProductDetailFavourite(String coordinates, int regionId, String regionName, int productId, String name, boolean isFavourite) {
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
		
		public void setIsFavourite() {
			this.isFavourite= isFavourite;
		}
		

		@Override
		public String toString() {
			return "ProductDetail [productId=" + productId + ", name=" + name + ", regionId=" + regionId
					+ ", regionName=" + regionName + ", coordinates=" + coordinates + "]";
		}



		
	
}
