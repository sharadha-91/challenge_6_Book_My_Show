package com.app.challenge3.jt;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jt_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
	
	private String company;
	private String avgRating;

}
