package com.projects.product_ms.dtos.product;

import lombok.Data;

@Data
public class UpdatePriceRequestDTO {
    private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
    
}
