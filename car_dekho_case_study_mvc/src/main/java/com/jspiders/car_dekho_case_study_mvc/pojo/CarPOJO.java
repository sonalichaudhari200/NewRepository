package com.jspiders.car_dekho_case_study_mvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;
@Data
@Entity
public class CarPOJO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int carId;
	   private String name;
	   private String brand;
	   private String fueltype;
	   private double price;
}
