package com.capstoneproject.FoodOfCanada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.FoodOfCanada.model.Region;

public interface RegionRepository extends JpaRepository<Region,Integer>
{

}
