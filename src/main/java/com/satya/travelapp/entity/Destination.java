package com.satya.travelapp.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Destination {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable = false, unique = true)
    private String name;
	
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	private List<Activity> activities;

	public Destination() {
		super();
	}

	public Destination(int id, String name, List<Activity> activities) {
		super();
		this.id = id;
		this.name = name;
		this.activities = activities;
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

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activities, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destination other = (Destination) obj;
		return Objects.equals(activities, other.activities) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Destination [id=" + id + ", name=" + name + ", activities=" + activities + "]";
	}
}
