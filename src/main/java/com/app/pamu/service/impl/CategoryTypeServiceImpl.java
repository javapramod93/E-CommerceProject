package com.app.pamu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.pamu.entity.CategoryType;
import com.app.pamu.exception.CategoryTypeNotFoundException;
import com.app.pamu.repo.CategoryTypeRepository;
import com.app.pamu.service.ICategoryTypeService;
@Service
public class CategoryTypeServiceImpl implements ICategoryTypeService {
	
	@Autowired
	private CategoryTypeRepository repo;

	@Override
	@Transactional
	public Long saveCategoryType(CategoryType categoryType) {
		return repo.save(categoryType).getId();
	}

	@Override
	@Transactional
	public void updateCategoryType(CategoryType categoryType) {
		repo.save(categoryType);

	}

	@Override
	@Transactional(readOnly = true)
	public List<CategoryType> getAllCategoryType() {
		return repo.findAll();
	}

	@Override
//	@Transactional(readOnly = true)
	public CategoryType getOneCategoryType(Long id) {
		 Optional<CategoryType> opt = repo.findById(id);
			if (opt.isEmpty()) {
				throw new CategoryTypeNotFoundException("CategoryType '" + id + "' not exist");
			} else {
				return opt.get();
			}
	}
	@Override
//	@Transactional
	public void deleteCategoryType(Long id) {
		  repo.delete(getOneCategoryType(id));

	}
}
