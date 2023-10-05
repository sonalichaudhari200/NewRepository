package com.jspiders.springrest1.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest1.pojo.StudentPojo;
import com.jspiders.springrest1.response.StudentResponse;
import com.jspiders.springrest1.service.StudentService;
@RestController
public class StudentController 
{
   @Autowired
   private StudentService service;
   
   @PostMapping(path = "/add",
		              consumes = MediaType.APPLICATION_JSON_VALUE,
		              produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPojo pojo)
   {
	   StudentPojo student=service.addStudent(pojo);
	   
	   //success
	   if(student!=null)
	   {
		   return new ResponseEntity<StudentResponse>(new StudentResponse("Data added successfully.", student, null),HttpStatus.ACCEPTED);

	   }
	   
	   //failure
	   return new ResponseEntity<StudentResponse>(new StudentResponse("Data not added.", null, null),HttpStatus.NOT_ACCEPTABLE);
   }
   @GetMapping(path = "/search/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id)
   {
	   StudentPojo student=service.searchStudent(id);
	   //success
	   if(student!=null)
	   {
	    return  new ResponseEntity<StudentResponse>(new StudentResponse("Data found successfully",student,null),HttpStatus.FOUND);
	   }
	   //failure
	   return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found.",student,null),HttpStatus.NOT_FOUND);
	   
   }
   @GetMapping(path="/searchAll",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentResponse> searchAllStudents()
   {
	   List<StudentPojo> students=service.searchAllStudents();
       
			   
			   //success
		if(students.isEmpty()==false)
		{
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data found successfully",null,students),HttpStatus.FOUND);
		  
		}
	   //failure
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found ",null,null),HttpStatus.NOT_FOUND);
 
	   
   }
   @DeleteMapping(path="/remove/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<StudentResponse> removeStudent(@PathVariable int id)
   {
	   StudentPojo student=service.removeStudent(id);
	   
	   //success
	   if(student!=null)
	   {
		   return new ResponseEntity<StudentResponse>(new StudentResponse("Data removed successfully",student,null),HttpStatus.OK);
	   }
	   return new ResponseEntity<StudentResponse>(new StudentResponse("Data  not removed ",null,null),HttpStatus.BAD_REQUEST);

   }
  @PutMapping(path = "/update",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StudentResponse>updateStudent(@RequestBody StudentPojo pojo)
  {
	  StudentPojo student=service.updateStudent(pojo);
	  
	  //success
	  if(student!=null)
	  {
		 return new ResponseEntity<StudentResponse>(new StudentResponse("Data updated successfully",student,null),HttpStatus.ACCEPTED); 
	  }
	  
	  //Failure
	  return new ResponseEntity<StudentResponse> (new StudentResponse("Data not updated", null, null),HttpStatus.NOT_ACCEPTABLE);
  }
   
}
