package com.spring.thiago.repository;

import com.spring.thiago.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailRepository extends JpaRepository <Mail, Long>{


    @Query(value = "select * from mail where iduser = ?1", nativeQuery = true)
    List<Mail> findAllId(int id);
}
