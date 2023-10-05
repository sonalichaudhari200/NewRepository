package com.jspiders.springrest1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jspiders.springrest1.pojo.StudentPojo;
import com.jspiders.springrest1.repository.StudentRepository;
@Service
public class StudentService
{
   @Autowired
   private StudentRepository repository;
	public StudentPojo addStudent(StudentPojo pojo) 
	{
		StudentPojo student=repository.addStudent( pojo);
		return student;
	}
	public StudentPojo searchStudent(int id) 
	{
		StudentPojo student=repository.searchStudent(id);
		return student;
	}
	public List<StudentPojo> searchAllStudents()
	{
		List<StudentPojo> students=repository.searchAllStudents(); 
		return students;
	}
	
	public StudentPojo removeStudent(int id) 
	{
		StudentPojo student=repository.removeStudent(id);
		return student;
	}
	public StudentPojo updateStudent(StudentPojo pojo) 
	{
		StudentPojo student=repository.updateStudent(pojo);
		return student;
	}

}
