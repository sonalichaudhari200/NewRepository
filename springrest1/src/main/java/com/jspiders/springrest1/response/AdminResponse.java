package com.jspiders.springrest1.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springrest1.pojo.AdminPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse 
{
   private String msg;
   private AdminPojo admin;
}
