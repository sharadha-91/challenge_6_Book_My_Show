package com.projects.product_ms.dtos.category;

import lombok.Data;

@Data
public class UpdateNameRequestDTO {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
    
}
