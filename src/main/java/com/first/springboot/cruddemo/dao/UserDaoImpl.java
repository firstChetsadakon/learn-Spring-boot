package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager theEntityManger){
        this.entityManager = theEntityManger;
    }
    @Override
    public User findByUserName(String theUserName) {
        // retrieve/read from database using username
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName and enabled=true", User.class);
        theQuery.setParameter("uName", theUserName);

        User theUser = null;
        try{
            theUser = theQuery.getSingleResult();
        }catch (Exception e){
            theUser = null;
        }
        return theUser;
    }
}