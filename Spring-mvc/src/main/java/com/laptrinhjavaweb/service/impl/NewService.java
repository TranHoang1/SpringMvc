package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Repository.CategoryRepository;
import com.laptrinhjavaweb.Repository.NewRepository;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.model.NewEntity;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.utils.TransferNews;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private TransferNews transferNews;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entity = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : entity) {
			models.add(transferNews.toDto(newEntity));
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(Long id) {
		NewEntity entity = newRepository.findOne(id);
		return transferNews.toDto(entity);
	}

}
