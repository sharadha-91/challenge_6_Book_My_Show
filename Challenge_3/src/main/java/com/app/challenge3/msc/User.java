package com.app.challenge3.msc;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@MappedSuperclass
public class User extends BaseModel{
	
	private String name;
	private String email;
	private String password;

}
