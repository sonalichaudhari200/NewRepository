package com.jspiders.springrest1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest1.pojo.AdminPojo;
import com.jspiders.springrest1.repository.AdminRepository;
@Service
public class AdminServise
{
	@Autowired
	private AdminRepository repository;

	public AdminPojo createAccount(AdminPojo pojo) {
		AdminPojo admin = repository.createAccount(pojo);
		return admin;
	}

	public AdminPojo login(AdminPojo pojo) {
		AdminPojo admin = repository.login(pojo);
		return admin;
	}
	
}
