package com.app.cardinality.many_to_many.option3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="mm_opt3_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	
	@ManyToMany(mappedBy="products")
	List<Tags> tags;

	//product_id, product_name
	//mapping table 1: mm_opt3_product_product_id, tags_tag_id
}
