package com.app.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="shows")
public class Show extends BaseModel{
	
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Screen screen;
	
	private Date startTime;
	private Date endTime;
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

}
