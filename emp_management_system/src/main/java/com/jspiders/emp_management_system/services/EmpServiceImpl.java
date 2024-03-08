package com.jspiders.emp_management_system.services;

import com.jspiders.emp_management_system.exception.ResourceNotFoundException;
import com.jspiders.emp_management_system.pojo.Employee;
import com.jspiders.emp_management_system.repository.EmpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EmpServiceImpl implements EmployeeService
{

    private EmpRepository repository;

    @Override
    public Employee createEmployee(Employee employee)
    {
        Employee emp=repository.save(employee);
        return emp;
    }
    @Override
    public Employee getEmployeeById(Long empId)
    {
       Employee employee=  repository.findById(empId).orElse(null);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees=repository.findAll();
        return employees;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails)
    {
        Employee existingEmployee=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with given id:"+id));
        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setEmail(employeeDetails.getEmail());

        repository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id)
    {
       Employee employee=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with given id is not exist"));
       repository.deleteById(id);
    }
}
