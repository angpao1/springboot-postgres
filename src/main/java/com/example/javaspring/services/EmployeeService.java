package com.example.javaspring.services;

import com.example.javaspring.models.Employee;

import java.util.ArrayList;

public interface EmployeeService {

    public ArrayList<Employee> getEmployees() throws Exception;
    public String addEmployee(Employee request) throws Exception;
    public String updateEmployee(Employee request) throws Exception;
    public String deleteEmployee(String id) throws Exception;
}
