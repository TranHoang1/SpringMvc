package com.laptrinhjavaweb.utils;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.model.CategoryEntity;

@Component
public class TransferDtoAndEntity {

	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO model = new CategoryDTO();
		model.setId(categoryEntity.getId());
		model.setCode(categoryEntity.getCode());
		model.setName(categoryEntity.getName());
		return model;
	}

	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(categoryDTO.getName());
		entity.setCode(categoryDTO.getCode());
		return entity;
	}
}
