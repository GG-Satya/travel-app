package com.satya.travelapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.travelapp.dao.ActivityDao;
import com.satya.travelapp.dao.DestinationDao;
import com.satya.travelapp.entity.Activity;
import com.satya.travelapp.entity.Destination;
import com.satya.travelapp.entity.Passenger;
import com.satya.travelapp.entity.TravelPackage;

@Service
public class TravelAgencyServiceImpl implements TravelAgencyService{
	
	@Autowired
	DestinationDao destinationDao;
	
	@Autowired
	ActivityDao activityDao;
	
	@Override
	public Destination addDestination(Destination destination) {
		return destinationDao.save(destination);
	}

	@Override
	public List<Destination> addAllDestination(List<Destination> destinations) {
		return destinationDao.saveAll(destinations);
	}

	@Override
	public Activity addActivity(Activity activity) {
		return activityDao.save(activity);
		
	}

	@Override
	public List<Activity> addAllActivity(List<Activity> activities) {
		
		return activityDao.saveAll(activities);
	}
	
	@Override
	public String signUpPassenger(Passenger passenger, Activity activity) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printItinerary(TravelPackage travelPackage) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printPassengerList(TravelPackage travelPackage) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printPassengerDetails(Passenger passenger) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printAvailableActivities(List<Activity> activities) {
		return null;
		// TODO Auto-generated method stub
		
	}



}
