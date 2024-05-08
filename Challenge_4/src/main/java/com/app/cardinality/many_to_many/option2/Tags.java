package com.app.cardinality.many_to_many.option2;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity(name="mm_opt2_tags")
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
	private String tagName;
	
	@ManyToMany
	@JoinTable(name="tag_product", joinColumns = @JoinColumn(name="tag_id"),
	inverseJoinColumns = @JoinColumn(name = "prod_id"))
	List<Product> products;
	
	//tag_id, tag_name
	//mapping table : mm_opt2_tags_tag_id, products_product_id
	//above fields are before using @Jointable
	
	//it creates tag_product table with tag_id, product_id
}
