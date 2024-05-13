package com.projects.order_ms.models;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;


@Entity(name = "orders")
public class Order extends BaseModel {
    private long userId;
    private double totalAmount;
    private Date orderDate;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany
    private List<OrderProduct> orderProducts;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	@Override
	public String toString() {
		return "Order [userId=" + userId + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + ", orderProducts=" + orderProducts + "]";
	}
    
    
    
}
