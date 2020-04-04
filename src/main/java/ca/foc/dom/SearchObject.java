package ca.foc.dom;

import java.util.ArrayList;

/**
 * Class to help with search functionality. This is the object that is received from the front end
 * @author Claudia Rivera
 *
 */


public class SearchObject {
	
	private String email; // this is the attribute to check if a member is signed on
	private ArrayList<Integer> productsSearched; // Input with products id to search
	private ArrayList<Integer> regionSearched; // Input with regions id to search
	private ArrayList<String> seasonSearched; // Input with seasons to search


	public SearchObject() {

	}

	public SearchObject(String email, ArrayList<Integer> productsSearched,ArrayList<Integer> regionSearched,  ArrayList<String> seasonSearched){
		this.email=email;
		this.productsSearched = productsSearched;	
		this.regionSearched = regionSearched;
		this.seasonSearched = seasonSearched;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	public ArrayList<Integer> getProductsSearched() {
		return productsSearched;
	}

	public void setProductsSearched(ArrayList<Integer> productsSearched) {
		this.productsSearched = productsSearched;
	}

	public ArrayList<Integer> getRegionSearched() {
		return regionSearched;
	}

	public void setRegionSearched(ArrayList<Integer> regionSearched) {
		this.regionSearched = regionSearched;
	}

	public ArrayList<String> getSeasonSearched() {
		return seasonSearched;
	}

	public void setSeasonSearched(ArrayList<String> seasonSearched) {
		this.seasonSearched = seasonSearched;
	}

	@Override
	public String toString() {
		return "SearchObject [productsSearched=" + productsSearched + ", regionSearched=" + regionSearched
				+ ", seasonSearched=" + seasonSearched + "]";
	}

	
}
