package com.projects.product_ms.dtos.product;

import com.projects.product_ms.dtos.ResponseStatus;
import com.projects.product_ms.models.Product;
import lombok.Data;

@Data
public class UpdateImageResponseDTO {
    private Product product;
    private String message;
    private ResponseStatus responseStatus;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
