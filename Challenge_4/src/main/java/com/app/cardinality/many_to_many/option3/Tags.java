package com.app.cardinality.many_to_many.option3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="mm_opt3_tags")
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
	private String tagName;
	
	@ManyToMany
	List<Product> products;
	

	//tag_id, tag_name
	//mapping table 2: mm_opt3_tags_tag_id, products_product_id
	
}
