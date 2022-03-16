package com.app.pamu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pamu.entity.Brand;
import com.app.pamu.exception.BrandNotFoundException;
import com.app.pamu.repo.BrandRepository;
import com.app.pamu.service.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private BrandRepository repo;
	
	@Override
	public Long saveBrand(Brand brand) {
		return repo.save(brand).getId();
	}

	@Override
	public void updateBrand(Brand brand) {
		 repo.save(brand);

	}

	@Override
	public Brand getOneBrand(Long id) {
		 Optional<Brand> opt = repo.findById(id);
		 if(opt.isEmpty()) {
			 throw new BrandNotFoundException("Brand not exist");
		 } else {
		return opt.get();
	}
  }
	@Override
	public void deleteBrand(Long id) {
		repo.delete(getOneBrand(id));

	}

	@Override
	public List<Brand> getAllBrands() {
		return repo.findAll();
	}
}
