package com.jspiders.carddekho_case_study.entity;

import com.jspiders.carddekho_case_study.main.CarDekhoMenu;

public class Car 
{
	   private int carID;
	   private String name;
	   private String model;
	   private String brand;
	   private String fueltype;
	   private double price;


	public static void main(String[] args)
	{
	    CarDekhoMenu.displayMenu();
	}


	public Car(int carID, String name, String model, String brand, String fueltype, double price) {
		super();
		this.carID = carID;
		this.name = name;
		this.model = model;
		this.brand = brand;
		this.fueltype = fueltype;
		this.price = price;
	}
	


	public Car() 
	{
		super();
	}


	public int getCarID() {
		return carID;
	}


	public void setCarID(int carID) {
		this.carID = carID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getFueltype() {
		return fueltype;
	}


	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Car [carID=" + carID + ", name=" + name + ", model=" + model + ", brand=" + brand + ", fueltype="
				+ fueltype + ", price=" + price + "]";
	}
	
	

}
