package com.jspiders.car_dekho_case_study_rest1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.car_dekho_case_study_rest1.pojo.CarPojo;
import com.jspiders.car_dekho_case_study_rest1.repository.CarRepository;

@Service
public class CarService 
{
	 @Autowired
	   CarRepository repository;
		public CarPojo addCar(CarPojo pojo)
		{
			CarPojo car=repository.addCar(pojo);
			return car;
		}
		public CarPojo searchCarById(int id) 
		{
			CarPojo car=repository.searchCarById(id);
			return car;
		}
		public List<CarPojo> searchAllCars() 
		{
			List<CarPojo> cars=repository.searchAllCars();
			return cars;
		}
		public CarPojo updateCar(CarPojo pojo)
		{
			CarPojo car=repository.updateCar(pojo);
			return car;
		}
		public CarPojo removeCar(int id) 
		{
			CarPojo car=repository.removeCar(id);
			return car;
		}
		
}
