package com.app.cardinality.one_to_one.option1;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name="opt1_husband")
public class Husband {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long husbandId;
	private String husbandName;

	@OneToOne
	private Wife wife;
	//Husband table has wifeId which is correct according to this.
	// we can drop husband table first but wife table we cannot drop first as wifeId(foreign key)is in husband table.
	//becoz of foreign key is refered in husband we cannot delete first wife table.
     
	//husband_id, husband_name, wife_wife_id
}
