package com.example.javaspring.controllers;

import com.example.javaspring.models.Employee;
import com.example.javaspring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public ArrayList<Employee> getEmployees() throws Exception {
        ArrayList<Employee> employees = employeeService.getEmployees();
        return employees;
    }

    @PostMapping(path = "/employees/add")
    public String addProduct(@RequestBody Employee request) throws Exception {
        String msg = employeeService.addEmployee(request);
        return msg;
    }

    @PutMapping(path = "/employees/update")
    public String updateEmployee(@RequestBody Employee request) throws Exception {
        String msg = employeeService.updateEmployee(request);
        return msg;
    }

    @DeleteMapping(path = "/employees/delete/{id}")
    public String deleteEmployee(@PathVariable String id) throws Exception {
        String msg = employeeService.deleteEmployee(id);
        return msg;
    }

}
