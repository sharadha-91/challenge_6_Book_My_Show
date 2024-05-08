package com.app.dto;

import com.app.model.Product;
import com.app.response.ResponseStatus;

public class ProductResponseDTO {
	
	private Product product;
	private ResponseStatus responseStatus;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	

}
