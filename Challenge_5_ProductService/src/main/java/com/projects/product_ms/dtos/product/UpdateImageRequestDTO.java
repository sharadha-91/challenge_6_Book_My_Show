package com.projects.product_ms.dtos.product;

import lombok.Data;

@Data
public class UpdateImageRequestDTO {
    private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    
}
