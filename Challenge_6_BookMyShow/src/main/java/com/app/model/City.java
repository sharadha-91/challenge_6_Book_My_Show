package com.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity(name="cities")
public class City extends BaseModel {
	
	private String cityName;
	@OneToMany(mappedBy="city")
	private List<Theatre> theatres ;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	

}
