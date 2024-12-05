package com.hospital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.management.entity.Doctor;
import com.hospital.management.entity.Employee;
import com.hospital.management.repository.EmployeeRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String loginPage() {
        return "login"; // Serve the login page
    }

    @PostMapping
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {

        List<Employee> employees = employeeRepository.findByUsernameAndPassword(username, password);
        System.out.print(employees);
        if (employees != null && !employees.isEmpty()) {
            return "redirect:/home";
        }
        return "redirect:/login?error=true";
    }

}
