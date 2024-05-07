package com.app.challenge3.msc;

import jakarta.persistence.Entity;

@Entity(name="msc_ta")
public class TA extends User{
	
	private String college;
	private int noOfQuestions;

}
