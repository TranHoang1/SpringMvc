package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;

@Component
public interface INewService {

	List<NewDTO> findAll(Pageable pageable);

	int getTotalItem();

	NewDTO findById(Long id);

}
