package com.app.challenge3.jt;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jt_learner")
@PrimaryKeyJoinColumn(name="user_id")
public class Learner extends User{
	
	private String college;
	private String company;

}
