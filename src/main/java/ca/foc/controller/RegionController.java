package ca.foc.controller;

import ca.foc.dao.RegionRepository;
import ca.foc.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }
}
