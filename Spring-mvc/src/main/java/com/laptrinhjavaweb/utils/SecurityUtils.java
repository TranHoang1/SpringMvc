package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhjavaweb.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		MyUser user = (MyUser) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return user;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getAuthen() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities());
		for (GrantedAuthority grantedAuthority : authorities) {
			results.add(grantedAuthority.getAuthority());
		}
		return results;
	}

}
