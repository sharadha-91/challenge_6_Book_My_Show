package com.app.challenge3.msc;

import jakarta.persistence.Entity;

@Entity(name="msc_learner")
public class Learner extends User {
	
	private String college;
	private String company;

}
