package com.jspiders.emp_management_system.controller;

import com.jspiders.emp_management_system.pojo.Employee;
import com.jspiders.emp_management_system.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
public class EmpController
{
   private EmployeeService service;

    // build create employee REST API

    @PostMapping("/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        Employee employee1=service.createEmployee(employee);
        return  new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    //    // build get employee by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId){
      Employee employee = service.getEmployeeById(empId);
        return ResponseEntity.ok(employee);
    }
    //build get all employees by REST API

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees=service.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    //  // build update employee REST API

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employeeDetails)
    {
        Employee updatedEmployee=service.updateEmployee(id,employeeDetails);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.ACCEPTED);
    }

    // build delete employee REST API

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id)
    {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}
