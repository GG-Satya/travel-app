package com.satya.travelapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.travelapp.entity.Activity;
import com.satya.travelapp.entity.Destination;
import com.satya.travelapp.service.TravelAgencyService;

@RestController
@RequestMapping("/travel-agency")
public class TravelAgencyController {
	
	private static final Logger logger = LoggerFactory.getLogger(TravelAgencyController.class);
    

    @Autowired
    private TravelAgencyService travelAgencyService;

    @PostMapping("/destination")
    public ResponseEntity<?> addDestination(@RequestBody @Valid Destination destination) {
    	try {
    		return ResponseEntity.ok(travelAgencyService.addDestination(destination));
    	}catch (Exception e) {
    		logger.error("Error during Destination creation: {}", e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
		}
    }

    @PostMapping("/add-all-destination")
    public ResponseEntity<?> addAllDestination(@RequestBody List<Destination> destinations) {
    	try {
    		return ResponseEntity.ok(travelAgencyService.addAllDestination(destinations));
    	}catch (Exception e) {
    		logger.error("Error during Destination creation: {}", e.getMessage(),e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
    	}
    }

    @PostMapping("/add-activity")
    public ResponseEntity<?> addActivity(@RequestBody @Valid Activity activity) {
        
		try {
			return ResponseEntity.ok(travelAgencyService.addActivity(activity));
		}catch (Exception e) {
    		logger.error("Error during Activity creation: {}", e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
		}
    }

    @PostMapping("/add-all-activity")
    public ResponseEntity<?> addActivity(@RequestBody List<Activity> activities) {
    	
    	try {
    		return ResponseEntity.ok(travelAgencyService.addAllActivity(activities));
    	}catch (Exception e) {
    		logger.error("Error during Activity creation: {}", e.getMessage(),e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()); 
    	}
    }

    @PostMapping("/passenger/{passengerId}/activity/{activityId}")
    public void signUpPassengerForActivity(@PathVariable("passengerId") Long passengerId, @PathVariable("activityId") Long activityId) {
        // Fetch Passenger and Activity objects by IDs and then sign up the passenger for the activity
    }

    @GetMapping("/itinerary/{travelPackageId}")
    public void printItinerary(@PathVariable("travelPackageId") Long travelPackageId) {
        // Fetch TravelPackage object by ID and then print its itinerary
    }

    @GetMapping("/passenger-list/{travelPackageId}")
    public void printPassengerList(@PathVariable("travelPackageId") Long travelPackageId) {
        // Fetch TravelPackage object by ID and then print its passenger list
    }

    @GetMapping("/passenger/{passengerId}")
    public void printPassengerDetails(@PathVariable("passengerId") Long passengerId) {
        // Fetch Passenger object by ID and then print its details
    }

    @GetMapping("/available-activities")
    public void printAvailableActivities() {
        // Fetch all available activities and then print their details
    }
}

