package com.projects.product_ms.dtos.product;

import lombok.Data;

@Data
public class UpdateQuantityRequestDTO {
    private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
