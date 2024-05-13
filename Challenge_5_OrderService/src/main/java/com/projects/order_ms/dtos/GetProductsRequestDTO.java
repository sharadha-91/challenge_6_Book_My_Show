package com.projects.order_ms.dtos;

import java.util.List;

public class GetProductsRequestDTO {
    private List<Long> productIds;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
    
    
}
