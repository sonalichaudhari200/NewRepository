package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPojo;
import com.jspiders.springmvc.pojo.StudentPojo;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired
	private StudentService service;

	//Home page Controller
		@GetMapping("/home")
		public String home(@SessionAttribute(name = "login", required = false)AdminPojo admin,
							ModelMap map) {
			if (admin != null) {
				return "Home";
			}
			map.addAttribute("msg", "Session inactive. Login to proceed..!");
			return "Login";
		}
		
		//Add page Controller
		@GetMapping("/add")
		public String addPage(@SessionAttribute(name = "login", required = false)AdminPojo admin,ModelMap map) {
			if (admin != null) {
				List<StudentPojo> students = service.findAllStudents();
				if (!students.isEmpty()) {
					map.addAttribute("students", students);
					return "Add";
				}
				return "Add";
			}
			map.addAttribute("msg", "Session inactive. Login to proceed..!");
			return "Login";
		}
	
	
	@PostMapping("/add")

	public String addStudent(@RequestParam String name,
			                  @RequestParam String email,
			                  @RequestParam long contact,
			                  @RequestParam String address,
			                  ModelMap map)
	{
		StudentPojo pojo=service.addStudent(name,email,contact,address);
		if(pojo!=null)
		{
			map.addAttribute("msg", " Data inserted successfully");
			List<StudentPojo> students=service.findAllStudents();
			map.addAttribute("students", students);
			return "Add";
		}
		
			map.addAttribute("msg", "Data not inserted");
			List<StudentPojo> students=service.findAllStudents();
			return "Add";
		
	}
	
	@GetMapping("/search")
	public String searchPage()
	{
	   return "Search";	
	}
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id ,ModelMap map)
	{
		StudentPojo pojo=service.searchStudent(id);
		if(pojo!=null)
		{
			map.addAttribute("student",pojo );
			map.addAttribute("msg", "student data found...!!!");
			return "Search";
		}
		map.addAttribute("msg", "student data not found...!!");
		return "Search";
		
	}
	
	@GetMapping("/remove")
	public String removePage(ModelMap map)
	{
		List<StudentPojo> students=service.findAllStudents();
		
		//success
		if(!students.isEmpty())
		{
			map.addAttribute("students", students);
			   return "Remove";	

		}
		map.addAttribute("msg", "No data present");
	   return "Remove";	
	}
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id,
								ModelMap map) {
		StudentPojo pojo = service.removeStudent(id);
		List<StudentPojo> students = service.findAllStudents();
		
		//Success
		if (pojo != null) {
			map.addAttribute("msg", "Data removed successfully..!");
			map.addAttribute("students", students);
			return "Remove";
		}
		//Failure
		map.addAttribute("msg", "Data does not exist..!");
		map.addAttribute("students", students);
		return "Remove";
	}
	
	@GetMapping("/update")
	public String updatePage(ModelMap map)
	{
		List<StudentPojo> students=service.findAllStudents();
		map.addAttribute("students", students);
		
	   return "Update";	
	}
	@PostMapping("/update")
	public String updateForm(@RequestParam int id,ModelMap map)
	{
		StudentPojo pojo=service.searchStudent(id);
		if(pojo!=null)
		{
			map.addAttribute("student", pojo);
			return "Update";
		}
		List<StudentPojo> students=service.findAllStudents();
		map.addAttribute("students", students);
		map.addAttribute("msg", "student data not found");
		return "Update";

	}
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam int id,
			                     @RequestParam String name,
			                     @RequestParam String email,
			                     @RequestParam long contact,
			                     @RequestParam String address,
			                     ModelMap map
			                     
			                     )
	{
		StudentPojo pojo=service.updateStudent(id,name,email,contact,address);
		if(pojo!=null)
		{
			List<StudentPojo> students=service.findAllStudents();
			map.addAttribute("msg", "data updated successfully");
			map.addAttribute("students", students);
			return "Update";
		}
		List<StudentPojo> students=service.findAllStudents();
		map.addAttribute("msg", "data  not updated ");
		map.addAttribute("students", students);
		return "Update";
		
	}
	
	@GetMapping("/logout")
	public String logout()
	{
	   return "Login";	
	}
}
