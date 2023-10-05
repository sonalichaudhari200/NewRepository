package com.jspiders.springrest1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springrest1.pojo.AdminPojo;

@Repository
public class AdminRepository
{

	

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("REST");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public AdminPojo createAccount(AdminPojo pojo) {
		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public AdminPojo login(AdminPojo pojo) {
		openConnection();
		transaction.begin();
		
		AdminPojo admin = manager.find(AdminPojo.class, pojo.getUsername());
		if (admin != null) {
			if (admin.getPassword().equals(pojo.getPassword())) {
				transaction.commit();
				closeConnection();
				return admin;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}
}
