package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.service.CompanyService;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;

    @GetMapping("/companies")
    public String companies(ModelMap modelMap){
        List<Company> all= companyService.findAll();
        modelMap.addAttribute("companies",all);
        return "companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(){
        return "addCompany";
    }
    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company company) {

        companyService.save(company);
        return "redirect:/companies";
    }
    @GetMapping("/deleteCompany")
    public String delete(@RequestParam("id") int id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }
}
