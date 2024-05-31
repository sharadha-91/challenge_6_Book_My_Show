package com.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="screens")
public class Screen extends BaseModel{
	
	private String screenName;
	
	@OneToMany
	private List<Seat> seat;
//	@Enumerated
//	private List<Feature> feature;

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}
	
	
	
	

}
