package com.app.challenge3.st;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;


@Entity(name="st_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_Type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value="0")
public class User extends BaseModel{
	
	private String name;
	private String email;
	private String password;

}
