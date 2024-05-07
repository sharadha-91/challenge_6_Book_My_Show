package com.app.challenge3.msc;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@MappedSuperclass
public class BaseModel {
	@Id
	private long id;
	private Date createdAt;
	private Date updatedAt;

}
