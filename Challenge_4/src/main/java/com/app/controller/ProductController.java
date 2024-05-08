package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductRequestDTO;
import com.app.dto.ProductResponseDTO;
import com.app.model.Product;
import com.app.response.ResponseStatus;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@PostMapping("/save")
	public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productDTO) {
		ProductResponseDTO response = new ProductResponseDTO();
		String prodName = productDTO.getProductName();
		float price = productDTO.getPrice();
		int quantity = productDTO.getQuantity();
	   try {
		Product prod =productService.createProduct(prodName, price, quantity);
		response.setProduct(prod);
		response.setResponseStatus(ResponseStatus.SUCCESS);
	   }catch(Exception e) {
		   System.out.println(e.getStackTrace());
		   response.setResponseStatus(ResponseStatus.FAILURE);
	   }
		return response;		 		
	}
	
	@GetMapping("/listOfProducts")
	public List<Product> getAllProducts() {		
		return productService.getAllProducts();		
	}
	
	@GetMapping("/{id}")
	public ProductResponseDTO getProductById(@PathVariable("id") long productId) {		
		ProductResponseDTO response = new ProductResponseDTO();		
     try {
    	Product prod = productService.getProductById(productId);
    	 response.setProduct(prod);
    	 response.setResponseStatus(ResponseStatus.SUCCESS);
    	 
     }catch(Exception e) {
    	 System.out.println(e.getStackTrace());
    	 response.setResponseStatus(ResponseStatus.FAILURE);
     }
		return response;
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseStatus deleteProductById(@PathVariable("id") long productId) {
		ResponseStatus responsestatus;
		try {
			productService.deleteById(productId);
			responsestatus = ResponseStatus.SUCCESS;
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			responsestatus = ResponseStatus.FAILURE;
		}
		return responsestatus;
	}
	
	@PutMapping("/{id}")
	public ProductResponseDTO updateProductById(@PathVariable("id") long productId, @RequestBody ProductRequestDTO productRequest) {
		ProductResponseDTO response = new ProductResponseDTO();
		
		String prodName = productRequest.getProductName();
		float price = productRequest.getPrice();
		int quantity = productRequest.getQuantity();
		
		try {
			Product prod =productService.updateProductById(productId, prodName, price, quantity);
			response.setProduct(prod);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			response.setResponseStatus(ResponseStatus.FAILURE);
		}
		
		return response;
				
	}
	

}
