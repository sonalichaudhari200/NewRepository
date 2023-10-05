package com.jspiders.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.studentmanagement.exception.InvalidEmailException;
import com.jspiders.studentmanagement.exception.InvalidNameException;
import com.jspiders.studentmanagement.pojo.StudentPOJO;
import com.jspiders.studentmanagement.repository.StudentRepository;

@Service

public class StudentService 
{
	@Autowired
	private StudentRepository repository;
	public StudentPOJO addStudent(StudentPOJO pojo) throws InvalidEmailException, InvalidNameException 
	{
		if(pojo.getEmail().contains("@"))
		{
			if(pojo.getName().matches("[a-zA-Z]+"))
			{
				
			StudentPOJO student=repository.save(pojo);
			return student;
			
           }throw new InvalidNameException(true,"Invalid Name");
		}
		throw new InvalidEmailException (true,"Invalid email");
		
		
		
	}
	public StudentPOJO searchByID(int id) 
	{
		StudentPOJO student=repository.findById(id).orElse(null);
		return student;
	}
	public List<StudentPOJO> searchAll() 
	{
		List<StudentPOJO> students=repository.findAll();
		return students;
	}
	public List<StudentPOJO> SearchByName(String name) 
	{
		List<StudentPOJO>students=repository.findByName(name);
		return students;
	}
	public List<StudentPOJO> SearchByEmail(String email) 
	{
		List<StudentPOJO>students=repository.findByEmail(email);
		return students;
	}
	public List<StudentPOJO> searchByAddress(String address) 
	{
		List<StudentPOJO>students=repository.findByAddress(address);
		return students;
	}
	public StudentPOJO updateStudent(StudentPOJO pojo)
	{
		StudentPOJO student=repository.save(pojo);
		return student;
	}
	public StudentPOJO deleteStudent(int id) 
	
	{
		StudentPOJO student=repository.findById(id).orElse(null);
		if(student!=null)
		{
			repository.deleteById(id);

		}
		return student;
		
	}
	

}
