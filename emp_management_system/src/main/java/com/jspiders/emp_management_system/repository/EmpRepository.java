package com.jspiders.emp_management_system.repository;

import com.jspiders.emp_management_system.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Long>
{
   //all crud database methods
}
