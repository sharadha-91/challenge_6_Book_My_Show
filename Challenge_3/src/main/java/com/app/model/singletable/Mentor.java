package com.app.model.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="singletable_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User{
	private double avgRating;
	private String company;

}
