package com.app.cardinality.one_to_many.option3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name="opt3_category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;
    
   @OneToMany(mappedBy="category")
    private List<Product> products;
        
   
   //category_id, category_name - this is correct
   
}
