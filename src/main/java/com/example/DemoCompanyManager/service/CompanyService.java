package com.example.DemoCompanyManager.service;

import com.example.DemoCompanyManager.model.Company;
import com.example.DemoCompanyManager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {
    @PersistenceContext
    EntityManager manager;


    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAll(){
        List<Company> list =  companyRepository.findAll();
        return list;

    }


    public void deleteAll(){
        companyRepository.deleteAll();
    }


    public void insertData(Company company){
        companyRepository.save(company);
    }


    public void deleteByCompanyCode(Company company){
        companyRepository.delete(company);
    }

    public Company getCompanyByPrimary(String companyCode){
        return  companyRepository.getCompanyByCompanyCode(companyCode);
    }

    public List<Company> getCompanyByCompanyCode(String companyCode,String email){
        return companyRepository.getCompanyByCompanyCode(companyCode,email);
    }

    public void clear(){
        companyRepository.deleteAll();
    }


}
