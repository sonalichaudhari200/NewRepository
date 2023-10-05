package com.jspiders.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagement.exception.InvalidEmailException;
import com.jspiders.studentmanagement.exception.InvalidNameException;
import com.jspiders.studentmanagement.pojo.StudentPOJO;
import com.jspiders.studentmanagement.response.StudentResponse;
import com.jspiders.studentmanagement.service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController 
{
  @Autowired
  private StudentService service;
  @PostMapping("/add")
  public ResponseEntity<?>addStudent(@RequestBody StudentPOJO pojo)
  {
	  try {
		StudentPOJO student=service.addStudent(pojo);
		if(student!=null)
		{
			return new ResponseEntity<StudentResponse>(new StudentResponse("student data added successfully", student, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not added", student, null),HttpStatus.NOT_ACCEPTABLE);
	} catch (InvalidEmailException e) 
	  {
		return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true,"Invalid Email" ),HttpStatus.NOT_ACCEPTABLE);
	} catch (InvalidNameException en) {
		return new ResponseEntity<InvalidNameException>(en,HttpStatus.NOT_ACCEPTABLE);
	}
  }
  @GetMapping("/search/{id}")
  public ResponseEntity<?> searchByID(@PathVariable int id)
  {
	  StudentPOJO student=service.searchByID(id);
	  
	  if(student!=null)
	  {
		  return new ResponseEntity<StudentResponse>(new StudentResponse("student data found successfully", student, null),HttpStatus.FOUND);
	  }
	  return new ResponseEntity<StudentResponse>(new StudentResponse("student data found successfully", null, null),HttpStatus.NOT_FOUND);

	  
  }
  @GetMapping("/searchAll")
  public ResponseEntity<?>searchAll()
  {
	  List<StudentPOJO>students=service.searchAll();
	  
	  if(students!=null)
	  {
		  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully", null, students),HttpStatus.FOUND);
	  }
	  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found",null,null),HttpStatus.NOT_FOUND);
  }
  @GetMapping("/searchByName/{name}")
  public ResponseEntity<?>searchByName(@PathVariable String name)
  {
	  List<StudentPOJO> students=service.SearchByName(name);
	  
	  if(students!=null)
	  {
		  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully", null, students),HttpStatus.FOUND);
	  }
	  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data  not found ", null, null),HttpStatus.BAD_REQUEST);

  }
  
  @GetMapping("/searchByEmail/{email}")
  public ResponseEntity<?>searchByEmail(@PathVariable String email)
  {
	  List<StudentPOJO> students=service.SearchByEmail(email);
	  
	  if(students!=null)
	  {
		  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully", null, students),HttpStatus.FOUND);
	  }
	  return new ResponseEntity<StudentResponse>(new StudentResponse("Student data  not found ", null, null),HttpStatus.BAD_REQUEST);

  }
  @GetMapping("/searchByAddress/{address}")
  public ResponseEntity<?>searchByAddress(@PathVariable String address)
  {
	  List<StudentPOJO>students=service.searchByAddress(address);
	 if(students!=null)
	 {
		 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully", null, students),HttpStatus.FOUND);
	 }
	 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found ", null, null),HttpStatus.FOUND);

  }  
  @PutMapping("/update")
  public ResponseEntity<?>updateStudent(@RequestBody StudentPOJO pojo)
  {
	  StudentPOJO student=service.updateStudent(pojo);
	  if(student!=null)
	  {
			 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data updated successfully", student, null),HttpStatus.ACCEPTED);
	  }
		 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not updated ", null, null),HttpStatus.NOT_ACCEPTABLE);

  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?>deleteStdent(@PathVariable int id)
  {
	  StudentPOJO student=service.deleteStudent(id);
	  
	  if(student!=null)
	  {
			 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data deleted successfully", student, null),HttpStatus.OK);
 
	  }
		 return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not deleted ", student, null),HttpStatus.BAD_REQUEST);

  }
  
  
		  

  }

