package com.jspiders.springrest1.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class AdminPojo 
{
	@Id
	private String username;
	private String password;

}
