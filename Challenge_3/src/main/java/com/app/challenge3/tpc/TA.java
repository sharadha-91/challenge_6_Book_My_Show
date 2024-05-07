package com.app.challenge3.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="tpc_ta")
public class TA extends User{
	
	private int noOfQuestions;
	private String college;

}
