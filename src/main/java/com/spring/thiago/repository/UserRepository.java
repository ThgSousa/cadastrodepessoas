package com.spring.thiago.repository;

import com.spring.thiago.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
