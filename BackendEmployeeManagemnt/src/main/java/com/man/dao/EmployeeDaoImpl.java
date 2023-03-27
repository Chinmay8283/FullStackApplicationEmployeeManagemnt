package com.man.dao;

import com.man.model.Employee;
import com.man.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee saveData(Employee employee){

        return employeeRepo.save(employee);
    }

    public Optional<Employee> getDataById(int empId){

        return employeeRepo.findById(empId);
    }

    public List<Employee> getAllData(){

        return employeeRepo.findAll();
    }
    
    public Employee updateData(Employee employee){

        return employeeRepo.save(employee);
    }

    public void deleteDataById(int empId){

        employeeRepo.deleteById(empId);
    }
}
