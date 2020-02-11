package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Repository.UserRepository;
import com.laptrinhjavaweb.dto.MyUser;
import com.laptrinhjavaweb.model.RoleEntity;
import com.laptrinhjavaweb.model.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findOneByUserNameAndStatus(username, 1);
		if (entity == null) {
			throw new UsernameNotFoundException("User not found !");

		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		List<RoleEntity> roles = entity.getRoles();
		for (RoleEntity roleEntity : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));

		}

		MyUser user = new MyUser(entity.getUserName(), entity.getPassword(), true, true, true, true,
				grantedAuthorities);
		user.setFullName(entity.getFullName());
		return user;
	}
}
