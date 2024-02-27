package com.satya.travelapp.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Passenger {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="name", nullable = false)
	@NotBlank(message =  "name can't be blank")
    private String name;
	
	@Column(name="passenger_number")
    private int passengerNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="passanger_type", nullable = false)
    private PassengerType type;
	
	@Column(name="balance")
    private double balance;
	
	

	public Passenger() {
		super();
	}

	public Passenger(int id, @NotBlank(message = "name can't be blank") String name, int passengerNumber,
			PassengerType type, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.type = type;
		this.balance = balance;
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

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public PassengerType getType() {
		return type;
	}

	public void setType(PassengerType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, name, passengerNumber, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& Objects.equals(name, other.name) && passengerNumber == other.passengerNumber && type == other.type;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", passengerNumber=" + passengerNumber + ", type=" + type
				+ ", balance=" + balance + "]";
	}
	
    
}
