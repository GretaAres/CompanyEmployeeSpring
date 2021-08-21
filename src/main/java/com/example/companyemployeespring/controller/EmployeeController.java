package com.example.companyemployeespring.controller;

import com.example.companyemployeespring.model.Company;
import com.example.companyemployeespring.model.Employee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import com.example.companyemployeespring.service.CompanyService;
import com.example.companyemployeespring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;


    @GetMapping("/employees")
    public String employees(ModelMap modelMap) {
        List<Employee> all = employeeService.findAll();
        modelMap.addAttribute("employees", all);
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(ModelMap modelMap) {
        List<Company> all = companyService.findAll();
        modelMap.addAttribute("companies", all);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployeePost(@ModelAttribute Employee employee) {

        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    public String singleEmployee(@PathVariable("id") int id, ModelMap modelMap) {
        Optional<Employee>  employee = employeeService.findOne(id);
        if (!employee.isPresent()) {
            return "redirect:/";
        }
        modelMap.addAttribute("employee", employee.get());

        return "singleEmployee";
    }
    @GetMapping("/deleteEmployee")
    public String delete(@RequestParam("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
