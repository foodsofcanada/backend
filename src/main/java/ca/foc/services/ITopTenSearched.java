package ca.foc.services;

import java.util.List;

import ca.foc.dom.TopTenObject;
/**
 * Interface with one to implement in product service involving TopeTenSearched Table
 * @author Claudia Rivera
 *
 */
public interface ITopTenSearched {
	List<TopTenObject> getTopTenSearched(String email);

}
