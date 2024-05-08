package com.app.cardinality.many_to_many.option1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;

@Entity(name="mm_opt1_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	@ManyToMany
	@JoinTable(name="product_tag")
	List<Tags> tags;

	
	//product_id, product_name
	//mapping table is added - mm_opt1_product_product_id, tags_tag_id
	
	//after placing @JoinTable(name="product_tag", joinColumns = @JoinColumn(name="prod_id"),
	//inverseJoinColumns = @JoinColumn(name = "tag_id"))
	//product_id, product_name and no mapping table created
	
	//it creates product_tag table with product_id,tag_id
}
