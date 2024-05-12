package com.projects.product_ms.dtos.category;

import com.projects.product_ms.dtos.ResponseStatus;
import lombok.Data;

@Data
public class DeleteCategoryResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
    
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
