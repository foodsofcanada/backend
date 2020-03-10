package ca.foc.controller;

import ca.foc.domain.Region;
import ca.foc.services.RegionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(path = "/region")
public class RegionController {

	@Autowired
	ca.foc.services.RegionServices regionService;
   
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/regions")
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }
}
