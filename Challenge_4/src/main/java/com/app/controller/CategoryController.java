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

import com.app.dto.CategoryRequestDTO;
import com.app.dto.CategoryResponseDTO;
import com.app.dto.ProductRequestDTO;
import com.app.dto.ProductResponseDTO;
import com.app.model.Category;
import com.app.model.Product;
import com.app.response.ResponseStatus;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/Categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/save")
	public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO categoryDTO) {
	        CategoryResponseDTO response = new CategoryResponseDTO();
		       String catName=categoryDTO.getCategoryName();
	   try {
		   Category cato =categoryService.createCategory(catName);
		 response.setCategory(cato);
		response.setResponseStatus(ResponseStatus.SUCCESS);
	   }catch(Exception e) {
		   System.out.println(e.getStackTrace());
		   response.setResponseStatus(ResponseStatus.FAILURE);
	   }
		return response;		 		
	}
	
	@GetMapping("/listOfCategories")
	public List<Category> getAllCategories() {		
		return categoryService.getAllCategories();	
	}
	
	@GetMapping("/{id}")
	public CategoryResponseDTO getCategoryById(@PathVariable("id") long categoryId) {		
		CategoryResponseDTO response = new CategoryResponseDTO();		
     try {
    	 Category  cat= categoryService.getCategoryById(categoryId);
    	 response.setCategory(cat);
    	 response.setResponseStatus(ResponseStatus.SUCCESS);
    	 
     }catch(Exception e) {
    	 System.out.println(e.getStackTrace());
    	 response.setResponseStatus(ResponseStatus.FAILURE);
     }
		return response;
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseStatus deleteCategoryById(@PathVariable("id") long categoryId) {
		ResponseStatus responsestatus;
		try {
			categoryService.deleteById(categoryId);
			responsestatus = ResponseStatus.SUCCESS;
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			responsestatus = ResponseStatus.FAILURE;
		}
		return responsestatus;
	}
	
	@PutMapping("/{id}")
	public CategoryResponseDTO updateCategoryById(@PathVariable("id") long categoryId, @RequestBody CategoryRequestDTO categoryRequest) {
		CategoryResponseDTO response = new CategoryResponseDTO();
		String catName = categoryRequest.getCategoryName();
		
		try {
			Category category = categoryService.updateCategoryById(categoryId, catName);
			response.setCategory(category);
			response.setResponseStatus(ResponseStatus.SUCCESS);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			response.setResponseStatus(ResponseStatus.FAILURE);
		}
		
		return response;
				
	}
	
	
	

}
