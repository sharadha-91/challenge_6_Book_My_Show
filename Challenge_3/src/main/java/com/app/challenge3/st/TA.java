package com.app.challenge3.st;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_ta")
@DiscriminatorValue(value="1")
public class TA extends User{
	
	private int noOfQuestions;
	private String college;

}
