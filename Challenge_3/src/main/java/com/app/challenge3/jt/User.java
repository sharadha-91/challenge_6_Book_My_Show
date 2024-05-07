package com.app.challenge3.jt;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;


@Entity(name="jt_user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User extends BaseModel{
	
	private String name;
	private String email;
	private String password;

}
