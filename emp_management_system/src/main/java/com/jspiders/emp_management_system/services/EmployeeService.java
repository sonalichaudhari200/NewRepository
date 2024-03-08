package com.jspiders.emp_management_system.services;

import com.jspiders.emp_management_system.pojo.Employee;

import java.util.List;

public interface EmployeeService
{

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long empId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployee(Long id);
}
