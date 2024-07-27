package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // แค่นี้เลยสำหรับ repository
}
