package com.example.dockerdemo.services;


import com.example.dockerdemo.entity.Employee;
import com.example.dockerdemo.exception.CustomException;
import com.example.dockerdemo.models.ErrorDTO;
import com.example.dockerdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        List<Employee> empList = null;
        try {
            empList = employeeRepo.findAll();

        }catch (Exception ex){
            throw new CustomException("605","Something went wrong while get all employees:"+ex .getMessage());
        }
        if (empList.isEmpty()) {
            throw new CustomException("604", "List is empty!!!");
        }
        return empList;
    }

    public ErrorDTO addEmployee(Employee emp) {
        if(emp.getName().isEmpty() || emp.getName().length()==0){
            throw new CustomException("601","Please send proper name, it is blank!!");
        }

          return new ErrorDTO("0","data save sucessfully",employeeRepo.save(emp));
    }
}
