package com.jspiders.car_dekho_case_study_rest1.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.car_dekho_case_study_rest1.pojo.CarPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse 
{
	 private String msg;
	 private CarPojo pojo;
	 private List<CarPojo> cars;
}
