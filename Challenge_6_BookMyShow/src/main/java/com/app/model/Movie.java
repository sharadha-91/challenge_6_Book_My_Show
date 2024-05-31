package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="movies")
public class Movie extends BaseModel{
	
	private String movieName;
	private Genere genere;
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	
	

}
