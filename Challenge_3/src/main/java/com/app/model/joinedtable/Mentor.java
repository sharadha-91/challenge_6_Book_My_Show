package com.app.model.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name="joinedtable_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
	private String company;
	private double avgRating;

}
