package com.app.model.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="singletable_ta")
@DiscriminatorValue(value="1")
public class TA extends User{
	private double avgRating;
	private String college;

}
