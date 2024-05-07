package com.app.model.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="joinedtable_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends User{
	
	private double avgRating;
	private String college;
	

}
