package com.app.challenge3.msc;

import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
public class Mentor extends User{
	
	private String company;
	private double avgRating;

}
