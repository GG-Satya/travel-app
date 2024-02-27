package com.satya.travelapp.service;

import java.util.List;

import com.satya.travelapp.entity.Activity;
import com.satya.travelapp.entity.Destination;
import com.satya.travelapp.entity.Passenger;
import com.satya.travelapp.entity.TravelPackage;

public interface TravelAgencyService {
	void addDestination(Destination destination);

	void addActivity(Activity activity);

	void signUpPassenger(Passenger passenger, Activity activity);

	void printItinerary(TravelPackage travelPackage);

	void printPassengerList(TravelPackage travelPackage);

	void printPassengerDetails(Passenger passenger);

	void printAvailableActivities(List<Activity> activities);
}
