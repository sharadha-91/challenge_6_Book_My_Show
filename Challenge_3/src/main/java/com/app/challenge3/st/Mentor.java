package com.app.challenge3.st;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User {
	
	private String company;
	private String avgRating;

}
