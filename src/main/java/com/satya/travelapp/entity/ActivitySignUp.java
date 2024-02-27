package com.satya.travelapp.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ActivitySignUp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;
    
    private double pricePaid;

	public ActivitySignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivitySignUp(Long id, Activity activity, Passenger passenger, double pricePaid) {
		super();
		this.id = id;
		this.activity = activity;
		this.passenger = passenger;
		this.pricePaid = pricePaid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public double getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activity, id, passenger, pricePaid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivitySignUp other = (ActivitySignUp) obj;
		return Objects.equals(activity, other.activity) && Objects.equals(id, other.id)
				&& Objects.equals(passenger, other.passenger)
				&& Double.doubleToLongBits(pricePaid) == Double.doubleToLongBits(other.pricePaid);
	}

	@Override
	public String toString() {
		return "ActivitySignUp [id=" + id + ", activity=" + activity + ", passenger=" + passenger + ", pricePaid="
				+ pricePaid + "]";
	}
    
    
}
