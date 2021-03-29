package com.spring.thiago.service;

import com.spring.thiago.model.User;

import java.util.List;

public interface UserService {
    List<User> findALl();
    User findById(long id);
    User save(User user);
    void deleteUser(long id);
}
