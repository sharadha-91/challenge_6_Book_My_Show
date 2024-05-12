package com.projects.product_ms.dtos.category;

import com.projects.product_ms.dtos.ResponseStatus;
import com.projects.product_ms.models.Category;
import lombok.Data;

@Data
public class UpdateNameResponseDTO {
    private Category category;
    private String message;
    private ResponseStatus responseStatus;
    
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
    
    
    
}
