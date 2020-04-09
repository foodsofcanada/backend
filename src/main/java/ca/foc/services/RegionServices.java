package ca.foc.services;

import ca.foc.dao.RegionRepository;
import ca.foc.domain.Product;
import ca.foc.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * RegionServices - ca.foc.services.RegionServices
 * This class implements methods for region entity:
 * 
 * @author Claudia Rivera, Christian Garrovillo
 */
@Service
public class RegionServices {

    @Autowired
    RegionRepository regionRepository;
    
    /**
     * Get all regions in region table 
     * @return a list of Region objects
     */
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
    /**
     * Find a Region and its attributes by an specific regionID
     * @param id
     * @return a Region object
     */
    public Optional<Region> getRegionById(int id) {
		return regionRepository.findById(id);
	}
}
