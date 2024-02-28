package com.satya.travelapp.service;

import java.util.List;

import com.satya.travelapp.entity.Activity;
import com.satya.travelapp.entity.Destination;
import com.satya.travelapp.entity.Passenger;
import com.satya.travelapp.entity.TravelPackage;

public interface TravelAgencyService {
	Destination addDestination(Destination destination);

	Activity addActivity(Activity activity);

	String signUpPassenger(Passenger passenger, Activity activity);

	String printItinerary(TravelPackage travelPackage);

	String printPassengerList(TravelPackage travelPackage);

	String printPassengerDetails(Passenger passenger);

	String printAvailableActivities(List<Activity> activities);

	List<Activity> addAllActivity(List<Activity> activities);

	List<Destination> addAllDestination(List<Destination> destinations);
}
