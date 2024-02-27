package com.satya.travelapp.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class TravelPackage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false)
    private String name;
	
	@Column(name="passanger_capacity")
    private int passengerCapacity;
	
	@OneToMany(cascade = CascadeType.ALL)
    private List<Destination> itinerary;
    
    @ManyToMany
    @JoinTable(name = "travel_package_passenger",
               joinColumns = @JoinColumn(name = "travel_package_id"),
               inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengers;

	public TravelPackage() {
		super();
	}

	public TravelPackage(int id, String name, int passengerCapacity, List<Destination> itinerary,
			List<Passenger> passengers) {
		super();
		this.id = id;
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		this.itinerary = itinerary;
		this.passengers = passengers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public List<Destination> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Destination> itinerary) {
		this.itinerary = itinerary;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itinerary, name, passengerCapacity, passengers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelPackage other = (TravelPackage) obj;
		return id == other.id && Objects.equals(itinerary, other.itinerary) && Objects.equals(name, other.name)
				&& passengerCapacity == other.passengerCapacity && Objects.equals(passengers, other.passengers);
	}

	@Override
	public String toString() {
		return "TravelPackage [id=" + id + ", name=" + name + ", passengerCapacity=" + passengerCapacity
				+ ", itinerary=" + itinerary + ", passengers=" + passengers + "]";
	}
    
}
