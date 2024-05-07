package com.app.challenge3.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="tpc_mentor")
public class Mentor extends User {
	
	private String company;
	private String avgRating;

}
