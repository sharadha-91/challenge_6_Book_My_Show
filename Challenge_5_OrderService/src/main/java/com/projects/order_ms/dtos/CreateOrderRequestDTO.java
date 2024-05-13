package com.projects.order_ms.dtos;

import java.util.List;

public class CreateOrderRequestDTO {
    private long userId;
    private List<OrderDetail> orderDetails;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
    
    
}
