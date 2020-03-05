package ca.foc.services;

import ca.foc.dao.RegionRepository;
import ca.foc.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RegionServices - ca.foc.services.RegionServices
 */
@Service
public class RegionServices {

    @Autowired
    static RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
