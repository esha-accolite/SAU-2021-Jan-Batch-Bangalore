package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    
    @Autowired
    EmployeeRepository EmployeeRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return EmployeeRepository.save(newEmployee);
    }
    
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String empId) {
        if (EmployeeRepository.existsById(empId)) {
            return EmployeeRepository.findById(empId);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/employee/address/{address}")
    public Employee getEmployeeByAddress(@PathVariable String address) {
        return EmployeeRepository.findByAddress(address);
    }
    
    @GetMapping("/employee/location/{location}")
    public Employee getEmployeeByLocation(@PathVariable String location) {
        return EmployeeRepository.findByLocation(location);
    }
    
    @GetMapping("/employee/pincode/{pincode}")
    public Employee getEmployeeByPincode(@PathVariable String pincode) {
        return EmployeeRepository.findByPincode(pincode);
    }
}
