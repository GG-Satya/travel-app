package com.satya.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.travelapp.entity.Passenger;

@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer>{

}
