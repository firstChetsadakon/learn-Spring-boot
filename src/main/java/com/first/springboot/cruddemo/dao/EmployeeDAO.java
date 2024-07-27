package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.Employee;
import java.util.List;
public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(int theID);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
