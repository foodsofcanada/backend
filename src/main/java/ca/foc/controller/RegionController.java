package ca.foc.controller;

import ca.foc.domain.Region;
import ca.foc.services.RegionServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/region")
public class RegionController {

    static RegionServices regionServices;

    @GetMapping
    public List<Region> getAllRegions() {
        return regionServices.getAllRegions();
    }
}
