package com.app.challenge3.st;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_learner")
@DiscriminatorValue(value="3")
public class Learner extends User{
	
	private String college;
	private String company;

}
