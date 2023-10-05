package com.jspiders.car_dekho_case_study_rest1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.car_dekho_case_study_rest1.pojo.CarPojo;
import com.jspiders.car_dekho_case_study_rest1.response.CarResponse;
import com.jspiders.car_dekho_case_study_rest1.service.CarService;
import com.jspiders.springmvc.pojo.StudentPojo;


@RestController
public class CarController 
{
	@Autowired
	  CarService service;
	  @PostMapping(path="/add",
			       consumes = MediaType.APPLICATION_JSON_VALUE,
			       produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<CarResponse>addCar(@RequestBody CarPojo pojo )
	 {
		 CarPojo car=service.addCar(pojo);
		 
		 //success
		 if(car!=null)
		 {
			 return new ResponseEntity<CarResponse>(new CarResponse("Data added successfully", car, null),HttpStatus.ACCEPTED);
		 }
		 //failure
		 return new ResponseEntity<CarResponse>(new CarResponse("Data not added.",null,null),HttpStatus.NOT_ACCEPTABLE);
		
}
	  @GetMapping(path="/searchById/{id}",
			            produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<CarResponse>searchCarById(@PathVariable int id)
	  {
		  CarPojo  car=service.searchCarById(id);
		  
		  //success
		  if(car!=null)
		  {
			  return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully", car, null),HttpStatus.FOUND);
		  }
		  return new ResponseEntity<CarResponse>(new CarResponse("Data  does not found", null, null),HttpStatus.NOT_FOUND);

		  
	  }
	  @GetMapping(path = "/searchAllCars",produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<CarResponse>searchAllCars()
	  {
		  List<CarPojo> cars=service.searchAllCars();
		  
		  //success
		  if(cars!=null)
		  {
			  return new ResponseEntity<CarResponse>(new CarResponse("Data found successfully", null, cars),HttpStatus.FOUND);
		  }
		  
		  //failure
		  return new ResponseEntity<CarResponse>(new CarResponse("Data  does not found ", null, null),HttpStatus.NOT_FOUND);

		 }
	  @PutMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	   public  ResponseEntity<CarResponse>updateCar(@RequestBody CarPojo pojo)
	   {
		  CarPojo car=service.updateCar(pojo);
		  
		  //success
		  if(car!=null)
		  {
			  return new ResponseEntity<CarResponse>(new CarResponse("Car data updated successfully.", pojo, null),HttpStatus.ACCEPTED);
		  }
		  return new ResponseEntity<CarResponse>(new CarResponse("Car data  not updated .", null, null),HttpStatus.NOT_ACCEPTABLE);

	   }
	  @DeleteMapping(path="/remove/{id}",produces  = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<CarResponse>removeCar(@PathVariable int id)
	  {
		  CarPojo car=service.removeCar(id);
		  
		  if(car!=null)
		  {
			  return new ResponseEntity<CarResponse>(new CarResponse("car data deleted successfully", car, null),HttpStatus.OK);
		  }
		  return new ResponseEntity<CarResponse>(new CarResponse("car data not deleted ", null, null),HttpStatus.BAD_REQUEST);

	  }
	  
	

	  
}
