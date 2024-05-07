package com.app.challenge3.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="tpc_learner")
public class Learner extends User{
	
	private String college;
	private String company;

}
