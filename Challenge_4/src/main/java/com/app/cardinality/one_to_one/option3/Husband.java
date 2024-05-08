package com.app.cardinality.one_to_one.option3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name="opt3_husband")
public class Husband {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long husbandId;
	private String husbandName;
	//@OneToOne
	@OneToOne(mappedBy="husband")
	private Wife wife;
	
	//husband table has wifeId and wife table has husbandId in option3, which leads to duplication of data 
	//redundancy of data is there, if we wont handle then insert,update,delete operations correctly.
	
	//we can handle by using mappedBy option
	
	//@OneToOne(mappedBy="husband")  - in wife table husbandId will be created as foreign key
	//husband_id, husband_name
	//wife_id, wife_name, husband_husband_id
}
