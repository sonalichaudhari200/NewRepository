package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPojo;

@Repository
public class StudentRepository
{
	 private static EntityManagerFactory factory;
	 private static EntityManager manager;
	 private static EntityTransaction tranjaction;
	 private static Query  query;
	 
	 private static void openConnection() {
			factory = Persistence.createEntityManagerFactory("mvc");
			manager = factory.createEntityManager();
			tranjaction = manager.getTransaction();
		}
		
		private static void closeConnection() {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
			if (tranjaction != null) {
				if (tranjaction.isActive()) {
					tranjaction.rollback();
				}
			}
		}


	public StudentPojo addStudent(String name, String email, long contact, String address) 
	{
		openConnection();
		tranjaction.begin();
		
		StudentPojo pojo=new StudentPojo();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setAddress(address);
		manager.persist(pojo);
		tranjaction.commit();
		closeConnection();
		
		return pojo;
	}

	public StudentPojo searchStudent(int id)
	{
		openConnection();
		tranjaction.begin();
		StudentPojo pojo=manager.find(StudentPojo.class, id);
		tranjaction.commit();
		closeConnection();
		return pojo;
	}

	public List<StudentPojo> findAllStudents() 
	{
		openConnection();
		tranjaction.begin();
		String jpql="from StudentPojo";
		query=manager.createQuery(jpql);
		List<StudentPojo>students=query.getResultList();
		tranjaction.commit();
		closeConnection();
		return students;
	}

	public StudentPojo removeStudent(int id) {
		openConnection();
		tranjaction.begin();
		
		StudentPojo pojo = manager.find(StudentPojo.class, id);
		if (pojo != null) {
			manager.remove(pojo);
		}
		
		tranjaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPojo updateStudent(int id, String name, String email, long contact, String address) 
	{
		openConnection();
		tranjaction.begin();
		  StudentPojo pojo=manager.find(StudentPojo.class, id);
		  pojo.setName(name);
		  pojo.setEmail(email);
		  pojo.setContact(contact);
		  pojo.setAddress(address);
		  manager.persist(pojo);
		tranjaction.commit();
		closeConnection();
		return pojo;
	}

	
	

}
