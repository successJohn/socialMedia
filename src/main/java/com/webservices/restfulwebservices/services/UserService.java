package com.webservices.restfulwebservices.services;

import com.webservices.restfulwebservices.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long Id);

    User createUser(User user);
    void deleteUser(Long Id);
}
