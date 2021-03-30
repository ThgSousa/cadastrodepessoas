package com.spring.thiago.repository;

import com.spring.thiago.model.Company;
import com.spring.thiago.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository <Company, Long>{


    @Query(value = "select * from company where iduser = ?1", nativeQuery = true)
    List<Mail> findAllId(int id);
}
