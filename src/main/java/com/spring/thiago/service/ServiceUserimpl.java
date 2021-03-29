package com.spring.thiago.service;

import com.spring.thiago.model.User;
import com.spring.thiago.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUserimpl implements UserService {
    @Autowired
    UserRepository repo;

    @Override
    public List<User> findALl() {
        return repo.findAll();
    }

    @Override
    public User findById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void deleteUser(long id) {
        repo.deleteById(id);
    }
}
