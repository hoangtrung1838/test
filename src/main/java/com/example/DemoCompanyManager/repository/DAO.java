package com.example.DemoCompanyManager.repository;



import com.example.DemoCompanyManager.context.DBContext;
import com.example.DemoCompanyManager.model.Company;
import com.example.DemoCompanyManager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {



    private Connection connection;

    private PreparedStatement pStatement;

    private ResultSet rs;


    public void insertData(String companyCode,String companyName,String address,String email,String phone,String website,String logo,String status){
        connection = DBContext.getConnection();
        String sql ="insert into company(company_code,company_name,address,email,phone,website,logo,status)\n" +
                "values(?,?,?,?,?,?,?,?);";
        try {
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1,companyCode);
            pStatement.setString(2,companyName);
            pStatement.setString(3,address);
            pStatement.setString(4,email);
            pStatement.setString(5,phone);
            pStatement.setString(6,website);
            pStatement.setString(7,logo);
            pStatement.setString(8,status);
            pStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Không chèn được dữ liệu");
            System.out.println(exception.getMessage());
        }

    }

    @Autowired
    static CompanyRepository companyRepository;

    public static void main(String[] args) {
        DAO dao = new DAO();
        CompanyService companyService = new CompanyService();
        Company company = null;
        System.out.println(company);
        System.out.println(companyRepository);
//        company= companyRepository.getCompanyByCompanyCode("Code224","Hoho");
        System.out.println(company);
    }
}
