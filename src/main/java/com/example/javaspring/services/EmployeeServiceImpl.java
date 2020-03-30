package com.example.javaspring.services;

import com.example.javaspring.models.Employee;
import com.example.javaspring.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ArrayList<Employee> getEmployees() throws Exception {
        ArrayList<Employee> employees = employeeRepository.getEmployees();
        return employees;
    }

    @Override
    public String addEmployee(Employee request) throws Exception {
        String msg = employeeRepository.addEmployee(request);
        return msg;
    }

    @Override
    public String updateEmployee(Employee request) throws Exception {
        String msg = employeeRepository.updateEmployee(request);
        return msg;
    }

    @Override
    public String deleteEmployee(String id) throws Exception {
        String msg = employeeRepository.deleteEmployee(id);
        return msg;
    }
}
