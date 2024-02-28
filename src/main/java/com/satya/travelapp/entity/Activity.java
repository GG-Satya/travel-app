package com.satya.travelapp.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false, unique = true)
	@NotBlank(message =  "name can't be blank")
    private String name;
    
	@Column(name="description")
	@Size(min =2, max = 255, message="The description should be within 2 to 255 characters")
    private String description;
    
	@Column(name="cost")
    private double cost;
    
	@Column(name="capacity")
    //@Size(min = 0, message="capacity can't be nagative")
    private int capacity;
    
 
	@ManyToOne
	@JoinColumn(name = "destination_id", nullable = false)
	private Destination destination;
    
	public Activity() {
		super();
	}


	public Activity(int id, @NotBlank(message = "name can't be blank") String name,
			@Size(min = 2, max = 255, message = "The description should be within 2 to 255 characters") String description,
			double cost, @Size(min = 0, message = "capacity can't be nagative") int capacity, Destination destination) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		this.destination = destination;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Destination getDestination() {
		return destination;
	}


	public void setDestination(Destination destination) {
		this.destination = destination;
	}


	@Override
	public int hashCode() {
		return Objects.hash(capacity, cost, description, destination, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return capacity == other.capacity && Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(description, other.description) && Objects.equals(destination, other.destination)
				&& id == other.id && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", description=" + description + ", cost=" + cost
				+ ", capacity=" + capacity + ", destination=" + destination + "]";
	}
    
    
}
