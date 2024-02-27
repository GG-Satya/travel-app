package com.satya.travelapp.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.travelapp.dao.UserDao;
import com.satya.travelapp.wrapper.AppUserWrapper;

@Service
public class UserUtilImpl implements UserUtil{
	
	@Autowired
	UserDao userDao;

	@Override
	public List<String> getAllAdminEmailId() {
		List<AppUserWrapper> adminList = userDao.getAllAdmin();
		if(adminList == null) {
			return Collections.emptyList();
		}
		return adminList.stream()
				.filter(admin -> admin != null && admin.getEmail() != null)
				.map(AppUserWrapper::getEmail)
				.collect(Collectors.toList());
	}

}
