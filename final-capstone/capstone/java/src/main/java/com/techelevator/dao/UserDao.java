package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    Map<String, String> getRoleInfoByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);
}
