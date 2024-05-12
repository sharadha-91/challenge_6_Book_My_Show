package com.projects.product_ms.dtos.product;

import com.projects.product_ms.dtos.ResponseStatus;
import com.projects.product_ms.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductsResponseDTO {
    List<Product> products;
    ResponseStatus responseStatus;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
    
    
}
