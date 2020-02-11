package com.laptrinhjavaweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.model.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

}
