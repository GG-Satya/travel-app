package com.satya.travelapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.travelapp.entity.Activity;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Integer>{

}
