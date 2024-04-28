package com.firstcode.cruddemo.dao;

import com.firstcode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
// Compare this snippet from src/main/java/com/firstcode/cruddemo/dao/StudentDAOImpl.java: