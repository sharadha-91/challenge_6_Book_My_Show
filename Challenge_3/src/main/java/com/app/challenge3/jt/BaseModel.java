package com.app.challenge3.jt;

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
