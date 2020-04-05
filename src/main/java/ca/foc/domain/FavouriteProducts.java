package ca.foc.domain;



import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "foc_favourite_products")
//@IdClass(FavouriteProductsIdentity.class)
public class FavouriteProducts {
    
	
//	@Id
//    private String email;
//    @Id
//    @Column(name="prod_id")
//    private int productId;
//    @Id
//    @Column(name="reg_id")
//    private int regionId;
    @EmbeddedId
    private FavouriteProductsIdentity favouritesProductIdentity;
    @Column(name="coordinate")
    private String coordinates;
    
    public FavouriteProducts() {
    	
    }

	public FavouriteProducts(FavouriteProductsIdentity favouritesProductIdentity, String coordinates) {
		this.favouritesProductIdentity = favouritesProductIdentity;
		this.coordinates = coordinates;
	}

	public FavouriteProductsIdentity getFavouriteProductsIdentity() {
		return favouritesProductIdentity;
	}

	public void setFavouriteProductsIdentity(FavouriteProductsIdentity favouritesProductIdentity) {
		this.favouritesProductIdentity = favouritesProductIdentity;
	}

    
    
	public String getCoordinates() {
		return coordinates;
	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	public int getRegionId() {
//		return regionId;
//	}
//
//	public void setRegionId(int regionId) {
//		this.regionId = regionId;
//	}

	public void setCoordinates(String point) {
		this.coordinates = point;
	}

//	@Override
//	public String toString() {
//		return "FavouriteProducts [email=" + email + ", productId=" + productId + ", regionId=" + regionId
//				+ ", coordinates=" + coordinates + "]";
//	}

	@Override
	public String toString() {
		return "FavouriteProducts [favouritesProductIdentity=" + favouritesProductIdentity + ", coordinates="
				+ coordinates + "]";
	}

    
	
    
    
}
