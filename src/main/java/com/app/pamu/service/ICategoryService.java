package com.app.pamu.service;

import java.util.List;

import com.app.pamu.entity.Category;

public interface ICategoryService {
	
	 Long createCategory(Category category);
	 void updateCategory(Category category);
	 Category getOneCategory(Long id);
	 void deleteCategory(Long id);
	 List<Category> getAllCategorys();

}
