package ca.foc.dom;

import java.awt.Point;

public class Favourite {
	private String email;
	private int productId;
	private int regionId;
	private String coordinates;

	public Favourite() {
		
	}

	public Favourite(String email, int productId, int regionId, String coordinates) {
		
		this.email = email;
		this.productId = productId;
		this.regionId = regionId;
		this.coordinates = coordinates;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProdId() {
		return productId;
	}

	public void setProdId(int prodId) {
		this.productId = prodId;
	}

	public int getRegiId() {
		return regionId;
	}

	public void setRegiId(int regiId) {
		this.regionId = regiId;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Favourite [email=" + email + ", prodId=" + productId + ", regiId=" + regionId + ", coordinates="
				+ coordinates + "]";
	}
	
	
}
