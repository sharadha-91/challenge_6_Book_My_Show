package com.app.service;

import java.util.List;

import com.app.exception.CategoryNotFoundException;
import com.app.exception.ProductNotFoundException;
import com.app.model.Category;

public interface CategoryService {
	  public Category createCategory(String categoryName);
	  public Category getCategoryById(long categoryId) throws CategoryNotFoundException ;	 
	  public void deleteById(long categoryId) throws CategoryNotFoundException;
	  public List<Category> getAllCategories();
	  public Category updateCategoryById(long categoryId, String categoryName) throws CategoryNotFoundException;
	  
}
