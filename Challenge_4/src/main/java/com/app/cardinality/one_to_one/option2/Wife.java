package com.app.cardinality.one_to_one.option2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name="opt2_wife")
public class Wife {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wifeId;
	private String wifeName;
	@OneToOne
	private Husband husband;
	
	//wife table has husbandId , if we want to delete,first delete wife table and then husband table.
	// working as expected according to the given annotation
	
	//wife_id, wife_name, husband_husband_id
}
