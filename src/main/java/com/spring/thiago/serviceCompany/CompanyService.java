package com.spring.thiago.serviceCompany;

import com.spring.thiago.model.Company;
import com.spring.thiago.model.User;

import java.util.List;

public interface CompanyService {
    List<Company> findALl();
    Company findById(long id);
    Company save(Company company);

    void deleteCompany(long id);
}
