package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.CategoryNotFoundException;
import com.app.model.Category;
import com.app.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category createCategory(String categoryName) {
		Category cate = new Category();
		cate.setCategoryName(categoryName);
		cate.setProducts(null);
		return categoryRepository.save(cate);

	}

	@Override
	public Category getCategoryById(long categoryId) throws CategoryNotFoundException {
		Optional<Category> option =categoryRepository.findById(categoryId);
		if(option.isEmpty()) {
			throw new CategoryNotFoundException("Category Id not exist");
		}else {
			return  option.get();
		}				
	}

	@Override
	public Category updateCategoryById(long categoryId, String categoryName) throws CategoryNotFoundException {
		     Optional<Category> option =  categoryRepository.findById(categoryId);
		     if(option.isEmpty()) {
		    	 throw new CategoryNotFoundException(" Category Id not exist");
		     }else {
		    	 Category cat = new Category();
		    	 cat.setCategoryId(categoryId);
		    	 cat.setCategoryName(categoryName);
		    	 cat.setProducts(null);
		    	 
		    	 return categoryRepository.save(cat);
		     }		
	}
	
	@Override
	public void deleteById(long categoryId) throws CategoryNotFoundException {
		Optional<Category> option = categoryRepository.findById(categoryId);
		if(option.isEmpty()) {
			throw new CategoryNotFoundException("Category Id not exist");
		}else {
			categoryRepository.deleteById(categoryId);;
		}
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	

}
