package com.example.javaspring.repositories;

import com.example.javaspring.config.Config;
import com.example.javaspring.models.Employee;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class EmployeeRespositoryImpl implements EmployeeRepository{
    @Override
    public ArrayList<Employee> getEmployees() throws Exception {

        Connection c = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Employee> list = new ArrayList<>();

        try {
            Class.forName(Config.DRIVER);
            c = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            c.setAutoCommit(false);

            StringBuffer sql = new StringBuffer("SELECT * FROM employee");
            stmt = c.prepareStatement(sql.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getString("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                list.add(employee);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Close database");
        }

        return list;
    }

    @Override
    public String addEmployee(Employee request) throws Exception {
        Connection c = null;
        PreparedStatement stmt = null;
        boolean flag = false;
        try {
            Class.forName(Config.DRIVER);
            c = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            c.setAutoCommit(false);

            System.out.println("Opened database successfully");

            StringBuffer sql = new StringBuffer("INSERT INTO employee (name, email) VALUES (?, ?) ");
            stmt = c.prepareStatement(sql.toString());
            stmt.setString(1, request.getName());
            stmt.setString(2, request.getEmail());

            System.out.println("After set stmt");

            int result = stmt.executeUpdate();
            if (result > 0) {
                flag = true;
                System.out.println("flag = true");
            } else {
                flag = false;
                System.out.println("flag = false");
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return e.getMessage();
        } finally {
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Close database");
        }

        if (flag) {
            System.out.println("Records created successfully");
            return "Records created successfully";
        } else {
            System.out.println("Records created failed");
            return "Records created failed";
        }
    }

    @Override
    public String updateEmployee(Employee request) throws Exception {
        Connection c = null;
        PreparedStatement stmt = null;
        boolean flag = false;
        try {
            Class.forName(Config.DRIVER);
            c = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            c = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            c.setAutoCommit(false);

            StringBuffer sql = new StringBuffer("UPDATE employee SET name = ?, email = ? WHERE id = ?");
            stmt = c.prepareStatement(sql.toString());
            stmt.setString(1, request.getName());
            stmt.setString(2, request.getEmail());
            stmt.setInt(3, Integer.parseInt(request.getId()));

            int result = stmt.executeUpdate();

            if (result > 0) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Close database");
        }

        if (flag) {
            System.out.println("Update successfully");
            return "Update successfully";
        } else {
            System.out.println("Update failed");
            return "Update failed";
        }
    }

    @Override
    public String deleteEmployee(String id) throws Exception {
        Connection c = null;
        PreparedStatement stmt = null;
        boolean flag = false;

        try {
            Class.forName(Config.DRIVER);
            c = DriverManager.getConnection(Config.URL, Config.USERNAME, Config.PASSWORD);
            c.setAutoCommit(false);

            StringBuffer sql = new StringBuffer("DELETE FROM employee WHERE id = ?");
            stmt = c.prepareStatement(sql.toString());
            stmt.setInt(1, Integer.parseInt(id));

            int result = stmt.executeUpdate();

            if (result > 0) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            stmt.close();
            c.commit();
            c.close();
            System.out.println("Close database");
        }

        if (flag) {
            System.out.println("Delete successfully");
            return "delete successfully";
        } else {
            System.out.println("delete failed");
            return "delete failed";
        }
    }

}
