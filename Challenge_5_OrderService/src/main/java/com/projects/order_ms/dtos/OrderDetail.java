package com.projects.order_ms.dtos;


public class OrderDetail {
    private long productId;
    private int quantity;
    
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetail [productId=" + productId + ", quantity=" + quantity + "]";
	}
    
    
    
}
