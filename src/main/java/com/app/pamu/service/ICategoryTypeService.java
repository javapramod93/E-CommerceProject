package com.app.pamu.service;

import java.util.List;

import com.app.pamu.entity.CategoryType;

public interface ICategoryTypeService {
	
	Long saveCategoryType(CategoryType categoryType);
	void updateCategoryType(CategoryType categoryType);
	List<CategoryType> getAllCategoryType();
	CategoryType getOneCategoryType(Long id);
	void deleteCategoryType(Long id);

}
