package com.app.pamu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pamu.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT id,name FROM Category WHERE status=:status")
	List<Object[]> getCategoryIdAndName(String status);
	  
	@Query("SELECT c FROM Category c JOIN c.categoryType as categoryType WHERE categoryType.id=:id")
	List<Category> getCategoryByCategoryType(Long id);
}
