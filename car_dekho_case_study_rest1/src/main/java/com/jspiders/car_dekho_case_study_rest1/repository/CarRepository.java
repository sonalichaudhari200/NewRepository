package com.jspiders.car_dekho_case_study_rest1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.car_dekho_case_study_rest1.pojo.CarPojo;

@Repository
public class CarRepository 
{
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;
	private static int result;
	private static Connection connection;
	private static Query query;

	private static void openConnection()
	{
		factory=Persistence.createEntityManagerFactory("REST");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	private static void closeConnection()
	{
		if(factory!=null)
		{
			factory.close();
		}
		if(manager!=null)
		{
			manager.close();
		}
		if(transaction!=null)
		{
			if(transaction.isActive())
			{
				transaction.rollback();
			}
		}
	}

	
	public CarPojo addCar(CarPojo pojo)
	{
		
		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	   
	}
	public CarPojo searchCarById(int id) 
	{
		openConnection();
		transaction.begin();
		openConnection();
		transaction.begin();
		CarPojo car=manager.find(CarPojo.class, id);
		transaction.commit();
		closeConnection();
		return car;
	}
	public List<CarPojo> searchAllCars() 
	{
		openConnection();
		transaction.begin();
		String jpql="from CarPojo";
		query=manager.createQuery(jpql);
		List<CarPojo>cars=query.getResultList();
		transaction.commit();
		closeConnection();
		return cars;
	}
	public CarPojo updateCar(CarPojo pojo)
	{
		openConnection();
		transaction.begin();
		CarPojo car=manager.find(CarPojo.class, pojo.getCarID());
		car.setName(pojo.getName());
		car.setBrand(pojo.getBrand());
		car.setFueltype(pojo.getFueltype());
		car.setPrice(pojo.getPrice());
		transaction.commit();
		closeConnection();
		return car;
	}
	public CarPojo removeCar(int id) 
	{
		openConnection();
		transaction.begin();
		CarPojo car = manager.find(CarPojo.class, id);
		
		if(car!=null)
		{
			manager.remove(car);
			transaction.commit();
			closeConnection();
			return car;
		}
		transaction.commit();
		closeConnection();
		return null;
	}
	
	
}
