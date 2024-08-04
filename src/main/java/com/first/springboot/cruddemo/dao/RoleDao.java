package com.first.springboot.cruddemo.dao;

import com.first.springboot.cruddemo.entity.Role;

public interface RoleDao {
    public Role findByUserName(String theRoleName);
}
