package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.AdminPojo;
import com.jspiders.springmvc.service.AdminService;
@Controller
public class AdminController
{
   @Autowired
   private AdminService service;
   @GetMapping("/createAccount")
   public String createAccountPage(ModelMap map)
   {
	   AdminPojo pojo=service.getAdmin();
	   if(pojo!=null)
	   {
		   map.addAttribute("msg", "Account already exists...");
		   return "Login";   
	   }
	return "CreateAccount";
	   
   }
   @PostMapping("/createAccount")
   public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map )
   {
	   AdminPojo pojo=service.createAccount(username,password);
	   //Success
	   if(pojo!=null)
	   {
		   map.addAttribute("msg", "Account created successfully....");
		   return "Login";
	   }
	   //Failure
	   map.addAttribute("msg", "Account not created");
	   return "Login";
	   
   }
   //Login Controller
   @PostMapping("/login")
   public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession session)
   {
	   AdminPojo pojo=service.login(username,password);
	   //success
	   if(pojo!=null)
	   {
		   session.setAttribute("login", pojo);
		   session.setMaxInactiveInterval(100);
		   return "Home";
	   }
	   map.addAttribute("msg", "Invalid userName and password");
	   return "Login";
	   
   }
   //Logout controller
   public String logout(ModelMap map,HttpSession session)
   {
	   session.invalidate();
	   map.addAttribute("map", "Logged out successfully");
	return "Login";
	   
   }
}
