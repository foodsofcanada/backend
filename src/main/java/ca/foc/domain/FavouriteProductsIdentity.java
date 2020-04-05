package ca.foc.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Class to implement a composite key using email, productId and regionId in table favoriteProducts
 * @author Claudia Rivera
 * Date:31-03-2020
 *
 */
@Embeddable
public class FavouriteProductsIdentity implements Serializable{
	
	private String email;
	@Column(name="prod_id")
	private int productId;
	@Column(name="reg_id")
	private int regionId;
	
	public FavouriteProductsIdentity() {
		
	}

	public FavouriteProductsIdentity(String email, int productId, int regionId) {
		this.email = email;
		this.productId = productId;
		this.regionId = regionId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "FavoriteProductIdentity [email=" + email + ", productId=" + productId + ", regionId=" + regionId + "]";
	}
	
	/*Missing the override for Serializable*/

}
