package com.app.dto;

import java.util.List;

public class BookTicketRequestDTO {
	
	private int userId;
	private int showId;
	private List<Integer> showSeatId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public List<Integer> getShowSeatId() {
		return showSeatId;
	}
	public void setShowSeatId(List<Integer> showSeatId) {
		this.showSeatId = showSeatId;
	}
	
	

}
