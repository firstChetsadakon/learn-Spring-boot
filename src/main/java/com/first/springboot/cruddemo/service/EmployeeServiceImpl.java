package com.first.springboot.cruddemo.service;

import com.first.springboot.cruddemo.dao.EmployeeRepository;
import com.first.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    // delegate the call to DAO

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee = result.get();
        } else{
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Transactional //สามารถ remove ได้เพราะ JpaRepository provides เป็น functionality
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Transactional //สามารถ remove ได้เพราะ JpaRepository provides เป็น functionality
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
