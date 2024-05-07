package com.app.challenge3.jt;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jt_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User{
	
	private int noOfQuestions;
	private String college;

}
