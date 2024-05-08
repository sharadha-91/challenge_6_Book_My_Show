package com.app.cardinality.one_to_one.option3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name="opt3_wife")
public class Wife {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wifeId;
	private String wifeName;
	//@OneToOne(mappedBy="wife")
	@OneToOne
	private Husband husband;
	
	//@OneToOne - on both sides
	//wife table has husbandId and husband table has wifeId in option3, which leads to duplication of data 
	//redundancy of data is there, if we wont handle then insert,update,delete operations correctly.
	
	//we can handle by using mappedBy option
	//mapped by is used when same relationship is mapped by both sides we need to inform JPA about the primary one
	// to use as a foreign key.
	
	// we need to specify OneTOOne on both sides but need to give mappedBy in one table so that it creates foreign key
	// on one side.
	
	
	//@OneToOne(mappedBy="wife") - in husband table wifeId is created as foreign table
	//husband_id, husband_name, wife_wife_id
	//wife_id, wife_name
}
