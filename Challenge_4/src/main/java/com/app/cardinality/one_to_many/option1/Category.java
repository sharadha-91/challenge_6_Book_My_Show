package com.app.cardinality.one_to_many.option1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name="opt1_category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;
       
    //this is correct according to what we have written
    //category_id, category_name
}
