package com.app.model.tableperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="tableperclass_mentor")
public class Mentor extends User{

	private double avgRating;
	private String company;
}
