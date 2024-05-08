package com.app.cardinality.one_to_one.option1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="opt1_wife")
public class Wife {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long wifeId;
	private String wifeName;
	
	//DROP TABLE `challenge4`.`opt1_wife`	Error Code: 3730. Cannot drop table 'opt1_wife' referenced by a foreign key constraint 'FKpg7lb8k9kttufbfxvjlrhl5wc' on table 'opt1_husband'.	
   // we cannot drop wife table first as it has it has a reference(foreign key) in husband table.
	
	//wife_id, wife_name
}
