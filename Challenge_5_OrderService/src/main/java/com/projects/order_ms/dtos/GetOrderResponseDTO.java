package com.projects.order_ms.dtos;

import com.projects.order_ms.models.Order;


public class GetOrderResponseDTO {
    private Order order;
    private String message;
    private ResponseStatus responseStatus;
    
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
