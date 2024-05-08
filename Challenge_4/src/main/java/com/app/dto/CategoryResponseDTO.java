package com.app.dto;

import com.app.model.Category;
import com.app.response.ResponseStatus;

public class CategoryResponseDTO {
	
	private Category category;
	private ResponseStatus responseStatus;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	

}
