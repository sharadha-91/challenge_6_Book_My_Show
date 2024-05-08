package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ProductNotFoundException;
import com.app.model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	@Override
	public Product getProductById(long productId) throws ProductNotFoundException {
		Optional<Product> prod= productRepository.findById(productId);
		if(prod.isEmpty()) {
			throw new ProductNotFoundException("User not exist" + productId);
		}else {
			return prod.get();
		}
		
	}
	
	@Override
	public Product updateProductById(long productId, String productName, float price, int quantity) throws ProductNotFoundException {
		Optional<Product> option =productRepository.findById(productId);
		if(option.isEmpty()) {
			throw new ProductNotFoundException("No user found");
		}
		else {
			Product pro =option.get();
			pro.setProductId(productId);
			pro.setProductName(productName);
			pro.setPrice(price);
			pro.setQuantity(quantity);
		
		return productRepository.save(pro);
		}
	}

	@Override
	public Product createProduct(String productName, float price, int quantity) {
		Product prod = new Product();
		prod.setProductName(productName);
		prod.setPrice(price);
		prod.setQuantity(quantity);
		return productRepository.save(prod);
		
	}

	//check before deleting if id is not present
	@Override
	public void deleteById(long productId) {
		this.productRepository.deleteById(productId);	
	}

	@Override
	public List<Product> getAllProducts() {
	  return productRepository.findAll();
	
	}

	

}
