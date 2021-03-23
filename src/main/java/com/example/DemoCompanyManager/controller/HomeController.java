package com.example.DemoCompanyManager.controller;


import com.example.DemoCompanyManager.model.Company;
import com.example.DemoCompanyManager.repository.CompanyRepository;
import com.example.DemoCompanyManager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller()
public class HomeController {


    @Autowired
    CompanyService companyService;


    @GetMapping("/showList")
    public ResponseEntity<?> getMenu( Company model, HttpServletRequest request){
//        companyService.insertData(new Company("Code"+(int)(Math.random()*(500+1)),"Haha","Hehe","Hoho","Hmu hmu","hmi hmi","haha","he he"));

        List<Company> list =  companyService.getCompanyByCompanyCode("5","");


        request.setAttribute("list",list);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/delete/{companyCode}")
    public ResponseEntity<?> deleteDatabase(@PathVariable String companyCode){
        Company company = companyService.getCompanyByPrimary(companyCode);
        companyService.deleteByCompanyCode(company);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> clearDatabase(){
        companyService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @GetMapping("/home")
    public String getMenu(){
        return "Menu";
    }

    @PostMapping("/register")
    public ResponseEntity<Company> signUp(@RequestBody Company company){
        companyService.insertData(company);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }


    @PutMapping("/update")
    public ResponseEntity<Company>update(@RequestBody Company company){
        companyService.insertData(company);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @GetMapping("/search/{companyCode}")
    public



}
