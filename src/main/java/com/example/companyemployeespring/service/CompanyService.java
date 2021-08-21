package com.example.companyemployeespring.service;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void save(Company company){
        companyRepository.save(company);

    }
    public List<Company> findAll(){
        return companyRepository.findAll();
    }
    public Optional<Company> findOne(int id){
        return companyRepository.findById(id);
    }
    public void deleteById(int id){
        companyRepository.deleteById(id);
    }
}

