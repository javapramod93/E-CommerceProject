package com.app.pamu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pamu.entity.CategoryType;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long>{

	@Query("SELECT id,name FROM CategoryType")
	List<Object[]> getCategoryTypeIdAndName();
}
