package com.duleendra.hrm.service.impl;

import com.duleendra.hrm.exception.BadRequestException;
import com.duleendra.hrm.exception.EmployeeException;
import com.duleendra.hrm.model.Employee;
import com.duleendra.hrm.repository.EmployeeRepository;
import com.duleendra.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("employeeRepository")
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {

        if(employee == null) {
            throw new BadRequestException("Employee object can not be empty");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {

        if(employee == null) {
            throw new BadRequestException("Employee object can not be empty");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOne(Long id) {

        if(employeeRepository.findOne(id) == null) {
            throw new EmployeeException("Employee object can not be found");
        }

        return employeeRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {

        if(employeeRepository.findOne(id) == null) {
            throw new EmployeeException("Employee object can not be found");
        }

        employeeRepository.delete(id);

    }
}
