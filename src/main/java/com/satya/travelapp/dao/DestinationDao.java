package com.satya.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.travelapp.entity.Destination;

@Repository
public interface DestinationDao extends JpaRepository<Destination, Integer>{

}
