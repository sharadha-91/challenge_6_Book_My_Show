package com.app.cardinality.one_to_many.option3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name ="opt3_product")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
   
    @ManyToOne
    private Category category;
    
    // if not mappedBy then we get id, title, category_category_id + mapping table which is incorrect so we use
     //mappedBy to fix above one
	//id, title, category_category_id  - this is correct
    //No mapping table   
}
