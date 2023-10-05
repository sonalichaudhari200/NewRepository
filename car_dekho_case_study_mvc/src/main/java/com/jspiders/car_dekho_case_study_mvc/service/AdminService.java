package com.jspiders.car_dekho_case_study_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.car_dekho_case_study_mvc.pojo.AdminPojo;
import com.jspiders.car_dekho_case_study_mvc.repository.AdminRepository;
@Service
public class AdminService 
{
	@Autowired
	AdminRepository repository;

	public AdminPojo getAdmin() {
		AdminPojo pojo = repository.getAdmin();
		return pojo;
	}

	public AdminPojo createAccount(String username, String password) {
		AdminPojo pojo = repository.createAccount(username, password);
		return pojo;
	}

	public AdminPojo login(String username, String password) {
		AdminPojo pojo = repository.login(username, password);
		return pojo;
	}
  
}
