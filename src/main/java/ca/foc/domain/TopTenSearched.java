package ca.foc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 *
 */


@Entity
@Table(name="foc_top_ten_searched")
public class TopTenSearched {
	
	@Id
	@Column(name="prod_id")
	private int  product_id;    
	@Column(name="search_counter")
    private int search_counter;     
    private String coordinate;   
   
    public TopTenSearched() {
    	
    }
	
    public TopTenSearched(int product_id, int search_counter) {
		this.product_id = product_id;
		this.search_counter = search_counter;
		//this.coordinate = coordinate;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int i) {
		this.product_id = i;
	}
	public int getSearch_counter() {
		return search_counter;
	}
	public void setSearch_counter(int search_counter) {
		this.search_counter = search_counter;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public String toString() {
		return "TopTenSearched [product_id=" + product_id + ", search_counter=" + search_counter + ", coordinate="
			 + coordinate+ "]";
	} 
	
    

}
