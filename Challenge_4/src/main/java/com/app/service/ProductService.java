package com.app.service;

import java.util.List;

import com.app.exception.ProductNotFoundException;
import com.app.model.Product;

public interface ProductService {

	  public Product createProduct(String productName, float price, int quantity);
	  public Product getProductById(long productId) throws ProductNotFoundException ;	 
	  public void deleteById(long productId);
	  public List<Product> getAllProducts();
	  public Product updateProductById(long productId, String productName,float price, int quantity) throws ProductNotFoundException;
	  
}
