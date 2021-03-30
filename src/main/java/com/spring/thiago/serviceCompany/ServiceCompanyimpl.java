package com.spring.thiago.serviceCompany;

import com.spring.thiago.model.Company;
import com.spring.thiago.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCompanyimpl implements CompanyService {
    @Autowired
    CompanyRepository repo;

    @Override
    public List<Company> findALl() {
        return repo.findAll();
    }

    @Override
    public Company findById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public Company save(Company company) {
        return repo.save(company);
    }

    @Override
    public void deleteCompany(long id) {
        repo.deleteById(id);
    }

}
