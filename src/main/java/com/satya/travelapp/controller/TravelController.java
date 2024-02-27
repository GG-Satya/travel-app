package com.satya.travelapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.satya.travelapp.service.TravelAgencyService;

@RestController
public class TravelController {
	
	@Autowired
	TravelAgencyService travelAgencyService;
	
	
}
