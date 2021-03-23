package com.example.DemoCompanyManager.repository;

import com.example.DemoCompanyManager.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,String> {
    @Query("select  e from Company e where e.companyCode like %?1% and e.email like %?2%")
        public List<Company> getCompanyByCompanyCode(String companyCode, String email);


    @Query("select  e from Company e where e.companyCode = ?1 ")
    public Company getCompanyByCompanyCode(String companyCode);



    @Query("delete from Company e where e.companyCode=?1")
    public void deleteByCompanyCode(String companyCode);
}

