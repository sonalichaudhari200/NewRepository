package com.jspiders.carddekho_case_study.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.jspiders.carddekho_case_study.entity.Car;

public class Operation 

{
	 boolean found=false;

   
	 Car car = new Car();
	 List<Car>carlist=new ArrayList<>();


     Scanner sc = new Scanner(System.in);
     public   void addCar()
 {
	   System.out.print("How many cars you want to add ...");
       int number=sc.nextInt();
      //List<Car>carl=new ArrayList<>();

       for(int i=0;i<number;i++)
       {

      System.out.println("ADD CAR...");
      System.out.print("carID is: ");
      int carid=sc.nextInt();
      System.out.print("car name is: ");
      String carName=sc.next();
      System.out.print("car model is: ");
      String model=sc.next();
      System.out.print("car brand is: ");
      String brand=sc.next();
      System.out.print("car fueltype is: ");
      String fueltype=sc.next();
      System.out.print("car price is: "); 
      double carPrice=sc.nextDouble();
       
      Car car1 = new Car();
	 car1.setCarID(carid);
	 car1.setName(carName);
	 car1.setModel(model);
	 car1.setBrand(brand);
	 car1.setFueltype(fueltype);
	 car1.setPrice(carPrice);
  
	 carlist.add(car1);
 	List<Car>carlisted=new ArrayList<>();
 	carlisted.add(car1);
 	displayCarDetails(carlisted );
    System.out.println(carName+" Car added Successfully"); 	 	
      }      
    System.out.println("Cars added Successfully ...");
	
    displayAllCarDetails();


 }
 public   void updateCar(int carid)
 {
	 //List<Car>carls=new ArrayList<>();
	 //carls = carlist.stream().filter(c -> c.getCarID() == carid).collect(Collectors.toList());
	 for (Car car2 : carlist) {
		 if( car2.getCarID() == carid) {
			 System.out.println("UPDATE CAR...");
			    System.out.println("carID is: "+carid);
			    //int carid=sc.nextInt();
			    System.out.print("car name "+car2.getName() +" update to:");
			    String carName=sc.next();
			    System.out.print("car model "+car2.getModel()+" update to:");
			    String model=sc.next();
			    System.out.print("car brand "+car2.getBrand()+" update to:");
			    String brand=sc.next();
			    System.out.print("car fueltype "+car2.getFueltype()+" update to:");
			    String fueltype=sc.next();
			    System.out.print("car price "+car2.getPrice()+" update to:"); 
			    double carPrice=sc.nextDouble();
			     
			     car.setCarID(carid);
				 car.setName(carName);
				 car.setModel(model);
				 car.setBrand(brand);
				 car.setFueltype(fueltype);
				 car.setPrice(carPrice);
				 List<Car>carlisted=new ArrayList<>();
				 carlisted.add(car);
				 displayCarDetails(carlisted );
				 				      
					System.out.println("Cars updated Successfully ...");
		 } 
         else {
			   System.out.println("Car with this id is not present");
		   }
	 }	 
}
 
 
 public void searchByName() {

     System.out.print("Enter Name to search: ");
     String name = sc.next();

     boolean found = false;
     for (Car car2 : carlist) {
         if (car2.getName().equalsIgnoreCase(name)) {
        	 List<Car>carlisted=new ArrayList<>();
        	 carlisted.add(car2);
        	 displayCarDetails(carlisted );
             found = true;
             break;
         }
     }

     if (!found) {
         System.out.println("Car not found with the given name.");
     }
 }

 public void searchByBrand() {

     System.out.print("Enter Brand to search: ");
     String brand = sc.next();

     boolean found = false;
     for (Car car2 : carlist) {
         if (car2.getBrand().equalsIgnoreCase(brand)) {
        	 List<Car>carlisted=new ArrayList<>();
        	 carlisted.add(car2);
        	 displayCarDetails(carlisted );
             found = true;
         }
     }

     if (!found) {
         System.out.println("No cars found with the given brand.");
     }
 }

   

    

   
public void searchCarByFuelType()
   {
	System.out.print("Enter fueltype to search: ");
    String fueltype = sc.next();

    boolean found = false;
    for (Car car2 : carlist) {
        if (car2.getFueltype().equalsIgnoreCase(fueltype)) {
       	 List<Car>carlisted=new ArrayList<>();
       	 carlisted.add(car2);
       	 displayCarDetails(carlisted );
            found = true;
        }
    }

    if (!found) {
        System.out.println("No cars found with the given brand.");
    }
	   
   }

 public void deleteCar(int cid)
 {
	 for (Car car2 : carlist) {
		 
		 if( car2.getCarID() == cid) {
			 carlist.remove(car2); 				
		System.out.println("Cars deleted Successfully ...");
		displayAllCarDetails();
		 break;
		 } 
         else {
			   System.out.println("Car with this id "+cid+" is not present");
		   } 
		
	 }
	 
 }
 public void displayAllCarDetails() 
 {
	  if (carlist.isEmpty()) {
	         System.out.println("No car details found.");
	     }
	  else {
	         System.out.println("Car Details:");
 }
	  System.out.println("ID\t"+"name\t"+"model\t"+"brand\t"+"fueltype\t"+"carPrice\t");
	  System.out.println("------------------------------------------------------------");
	 for(Car car:carlist)
	 {
	 
	 
	 System.out.println(car.getCarID()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFueltype()+"\t"+car.getPrice());
 }

 }
 public void displayCarDetails(List<Car> carlisted) 
 {
	  if (carlisted.isEmpty()) {
	         System.out.println("No car details found.");
	     }
	  else {
	         System.out.println("Car Details:");
 }
	  System.out.println("ID\t"+"name\t"+"model\t"+"brand\t"+"fueltype\t"+"carPrice\t");
	  System.out.println("------------------------------------------------------------");
	 for(Car car:carlisted)
	 {
	 
	 
	 System.out.println(car.getCarID()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFueltype()+"\t"+car.getPrice());
 }

 }
}
