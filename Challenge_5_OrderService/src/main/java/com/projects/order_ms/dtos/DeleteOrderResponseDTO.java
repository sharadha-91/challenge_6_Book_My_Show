package com.projects.order_ms.dtos;


public class DeleteOrderResponseDTO {
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
