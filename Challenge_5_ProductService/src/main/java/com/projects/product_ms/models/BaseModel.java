package com.projects.product_ms.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
}
