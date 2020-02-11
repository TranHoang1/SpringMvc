package com.laptrinhjavaweb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndStatus(String userName,int status);
}
