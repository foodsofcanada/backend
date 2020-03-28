package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * Class to implement a composite key using productId and regionId in table Top_Ten_Searched.
 * @author Claudia Rivera
 * Date:27_03_2020
 *
 */

@Embeddable
public class TopTenSearchedIdentity implements Serializable{
	
	@Column(name="prod_id")
	private int productId;
	@Column(name="reg_id")
	private int regionId;
	
	public TopTenSearchedIdentity(){
		
	}

	public TopTenSearchedIdentity(int productId, int regionId) {
		
		this.productId = productId;
		this.regionId = regionId;
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
		return "TopTenSearchedIdentity [productId=" + productId + ", regionId=" + regionId + "]";
	}
	
	
	/*Missing the override for Serializable*/
	

}
