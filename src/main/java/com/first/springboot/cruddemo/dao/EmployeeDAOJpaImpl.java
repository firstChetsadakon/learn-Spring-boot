package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // set up constructor injection
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findByID(int theID) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theID);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee tdbEmployee = entityManager.merge(theEmployee);//if id of theEmployee is equal 0 it will  save or insert

        // return the dbEmployee
        return tdbEmployee; // return dbEmployee it has updated id from the db mot the one was passed in.
    }

    @Override
    public void deleteById(int theId) {
        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove theEmployee
        entityManager.remove(theEmployee);
    }
}
