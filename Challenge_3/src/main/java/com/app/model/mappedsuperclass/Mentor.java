package com.app.model.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="mappedsuperclass_mentor")
public class Mentor extends User{
	
	private String company;
	private double avgRating;
	

}
