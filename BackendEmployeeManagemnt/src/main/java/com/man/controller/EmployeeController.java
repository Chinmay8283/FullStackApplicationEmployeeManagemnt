package com.man.controller;

import com.man.exception.RecordNotFoundException;
import com.man.model.Employee;
import com.man.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    EmployeeServiceImpl employeeService;


    @PostMapping("/")
    public Employee saveData(@RequestBody Employee employee){

        return employeeService.saveData(employee);
    }

    @GetMapping("/{empId}")
    public Optional<Employee> getDataById(@PathVariable int empId){

        return employeeService.getDataById(empId);
    }

    @GetMapping("/")
    public List<Employee> getAllData(){

        return employeeService.getAllData();
    }

    @PutMapping("/{empId}")
    public Employee updateData(@PathVariable int empId, @RequestBody Employee employee) throws RecordNotFoundException {

        Employee employee1 = employeeService.getDataById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id does not exist "));

        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return employeeService.updateData(employee1);
    }


    @DeleteMapping("/{empId}")
    public String deleteDataById(@PathVariable int empId){

         employeeService.deleteDataById(empId);

         return "Data Deleted Successfully...";
    }
}
