package com.projects.product_ms.dtos.product;

import lombok.Data;

import java.util.List;

@Data
public class GetProductsByIdRequestDTO {
    private List<Long> productIds;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
    
    
    
}
