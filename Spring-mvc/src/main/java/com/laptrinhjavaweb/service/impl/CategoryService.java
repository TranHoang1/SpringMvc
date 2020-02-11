package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Repository.CategoryRepository;
import com.laptrinhjavaweb.model.CategoryEntity;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Map<String, String> findAll() {
		Map<String, String> codeName = new HashMap<>();
		List<CategoryEntity> list = categoryRepository.findAll();
		for (CategoryEntity categoryEntity : list) {
			codeName.put(categoryEntity.getCode(), categoryEntity.getName());
		}
		return codeName;
	}

}
