package com.jspiders.car_dekho_case_study_rest1.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
public class CarPojo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int carID;
	   private String name;
	   private String brand;
	   private String fueltype;
	   private double price;

}
