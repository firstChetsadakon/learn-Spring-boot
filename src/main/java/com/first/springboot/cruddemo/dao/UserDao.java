package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.User;

public interface UserDao {
    User findByUserName(String userName);
}
