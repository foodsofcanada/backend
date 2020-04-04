package ca.foc.domain;



import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "foc_favourite_products")
public class FavouriteProducts {
    
	
//	@Id
//    private String email;
//    @Id
//    @Column(name="prod_id")
//    private long productId;
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

	public void setCoordinates(String point) {
		this.coordinates = point;
	}

	@Override
	public String toString() {
		return "FavouriteProducts [favouritesProductIdentity=" + favouritesProductIdentity + ", coordinates="
				+ coordinates + "]";
	}
    
	
    
    
}
