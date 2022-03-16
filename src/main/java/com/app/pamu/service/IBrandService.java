package com.app.pamu.service;

import java.util.List;

import com.app.pamu.entity.Brand;

public interface IBrandService {

	 Long saveBrand(Brand brand);
	 void updateBrand(Brand brand);
	 Brand getOneBrand(Long id);
	 void deleteBrand(Long id);
	 List<Brand> getAllBrands();
}
