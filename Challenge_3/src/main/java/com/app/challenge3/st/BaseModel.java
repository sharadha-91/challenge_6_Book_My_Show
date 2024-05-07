package com.app.challenge3.st;

import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
	@Id
	private long id;
	private Date createdAt;
	private Date updatedAt;
	

}
