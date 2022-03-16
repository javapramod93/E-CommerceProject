package com.app.pamu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pamu.entity.Category;
import com.app.pamu.exception.CategoryNotFoundException;
import com.app.pamu.exception.CategoryTypeNotFoundException;
import com.app.pamu.repo.CategoryRepository;
import com.app.pamu.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public Long createCategory(Category category) {
		return repo.save(category).getId();
	}

	@Override
	public void updateCategory(Category category) {
		
		if(category.getId()!=null || !repo.existsById(category.getId())) {
		     repo.save(category);
		} else {
			throw new CategoryNotFoundException("Category not exist");	
		}
		
	}

	@Override
	public Category getOneCategory(Long id) {
		Optional<Category> opt = repo.findById(id);
		if(opt.isEmpty()) {
			throw new CategoryNotFoundException("Category not exist with Id: "+id);
		} else {
			return opt.get();
		}
		 
	}

	@Override
	public void deleteCategory(Long id) {
		
		repo.delete(getOneCategory(id));
		
	}

	@Override
	public List<Category> getAllCategorys() {
		return repo.findAll();
	}

}
