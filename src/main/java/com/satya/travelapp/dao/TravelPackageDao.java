package com.satya.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.travelapp.entity.TravelPackage;

public interface TravelPackageDao extends JpaRepository<TravelPackage, Integer>{

}
