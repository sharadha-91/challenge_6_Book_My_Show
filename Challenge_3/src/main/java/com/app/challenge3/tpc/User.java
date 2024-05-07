package com.app.challenge3.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;


@Entity(name="tpc_user")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User extends BaseModel{
	
	private String name;
	private String email;
	private String password;

}
