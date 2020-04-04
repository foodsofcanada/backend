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
 */
@Service
public class RegionServices {

    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
    
    public Optional<Region> getRegionById(int id) {
		return regionRepository.findById(id);
	}
}
