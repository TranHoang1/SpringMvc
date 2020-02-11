package com.laptrinhjavaweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByCode(String code);
}
