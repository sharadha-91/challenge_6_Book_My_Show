package com.app.cardinality.one_to_many.option1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity(name ="opt1_product")
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
   
    @ManyToOne
    private Category category;
    	
    //In one category we have mutliple products, here mulitple products for a single category(m:1)
    // so 1 side id should be placed on m side.(categoryId in product table)
    //id, title, category_category_id
    
    //this is correct according to what we have written
}
