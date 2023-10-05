package com.jspiders.springrest1.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springrest1.pojo.StudentPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse 

{
    private String msg;
    private  StudentPojo pojo;
    private List<StudentPojo> students;
    
}
