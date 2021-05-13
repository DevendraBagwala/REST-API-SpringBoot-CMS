package com.divergentsl.springbootcms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divergentsl.springbootcms.dao.AdminDao;
import com.divergentsl.springbootcms.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	
	public boolean login(String username, String password) {
		
		Admin admin = adminDao.login(username);
		if (admin == null) return false;
			return username.equals( admin.getUsername( )) && password.equals(admin.getPassword());

	}

}
