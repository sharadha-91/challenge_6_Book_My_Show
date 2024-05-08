package com.app.cardinality.one_to_one.option2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name="opt2_husband")
public class Husband {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long husbandId;
	private String husbandName;
	
	
	//DROP TABLE `challenge4`.`opt2_husband`	Error Code: 3730. Cannot drop table 'opt2_husband' referenced by a foreign key constraint 'FK3se6cbl7ycsendiusfhp140rp' on table 'opt2_wife'.
    //we cannot delete husband table first here as husband id is present in wife table, First delete wife table and then husband table here.

	//husband_id, husband_name
}
