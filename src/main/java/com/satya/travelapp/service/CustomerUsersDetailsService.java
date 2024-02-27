package com.satya.travelapp.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.satya.travelapp.dao.UserDao;
import com.satya.travelapp.entity.AppUser;

@Service
public class CustomerUsersDetailsService implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
//	@Autowired 
//	Logger log;
	
	private AppUser appUser;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		log.info("inside loadUserByUsername()"+username);
		appUser = userDao.findByEmail(username);
		if(Objects.nonNull(appUser)) {
			return new org.springframework.security.core.userdetails.User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("user not found");
		}
	}
	
	public AppUser getUserDetail() {
//		AppUser user = appUser;
//		user.setPassword(null);
//		return user;
		return appUser;
	}

}
