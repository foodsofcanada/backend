package ca.foc.services;

import java.util.List;

import ca.foc.dom.TopTenObject;

public interface ITopTenSearched {
	//List<TopTenObject>  getTopTenSearched();

	List<TopTenObject> getTopTenSearched(String email);

}
