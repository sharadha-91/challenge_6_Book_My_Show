package com.app.cardinality.one_to_many.option2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity(name ="opt2_product")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
   
   //id, title --> product table, no reference of other table is created
   //extra table mapping table, category_products is created with fields :  opt2_category_category_id, products_id
    // we dont want mapping table to be created on reference id should be placed in other table

    //we cannot fix this we should either convert to option1 or option3

}
