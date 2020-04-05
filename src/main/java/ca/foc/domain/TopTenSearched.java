package ca.foc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Top Ten most searched product table
 * 
 *@author Claudia Rivera
 */


@Entity
@Table(name="foc_top_ten_searched")
public class TopTenSearched {
	
	@EmbeddedId
	private TopTenSearchedIdentity topTenSearchedIdentity;
	@Column(name="prod_name")
	private String productName;
	@Column(name="reg_name")
	private String regionName;
	@Column(name="search_counter")
    private int searchCounter; 
    private String coordinate;   
   
    public TopTenSearched() {
    	
    }
    

	public TopTenSearched(TopTenSearchedIdentity topTenSearchedIdentity, String productName, String regionName, int searchCounter, String coordinate) {
		this.topTenSearchedIdentity = topTenSearchedIdentity;
		this.productName = productName;
		this.regionName = regionName;
		this.searchCounter = searchCounter;
		this.coordinate = coordinate;
	}


    
	public TopTenSearchedIdentity getTopTenSearchedIdentity() {
		
		return topTenSearchedIdentity;
	}


	public void setTopTenSearchedIdentity(TopTenSearchedIdentity topTenSearchedIdentity) {
		this.topTenSearchedIdentity = topTenSearchedIdentity;
	}

	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getRegionName() {
		return regionName;
	}


	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	public int getSearchCounter() {
		return searchCounter;
	}

	public void setSearchCounter(int searchCounter) {
		this.searchCounter = searchCounter;
	}


	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}


	@Override
	public String toString() {
		return "TopTenSearched [topTenSearchedIdentity=" + topTenSearchedIdentity + ", productName=" + productName
				+ ", regionName=" + regionName + ", searchCounter=" + searchCounter + ", coordinate=" + coordinate
				+ "]";
	}

}
