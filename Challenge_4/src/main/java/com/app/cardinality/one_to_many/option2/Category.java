package com.app.cardinality.one_to_many.option2;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name="opt2_category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;
    
    @OneToMany
    private List<Product> products;
    
    //category_id, category_name --> Category table, no reference of other table is created
    
}
