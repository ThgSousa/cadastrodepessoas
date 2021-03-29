package com.spring.thiago.repository;

import com.spring.thiago.model.Tell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TellRepository extends JpaRepository <Tell, Long>{


    @Query(value = "select * from phoneusers where iduser = ?1", nativeQuery = true)
    List<Tell> findAllTellId(int id);
}
