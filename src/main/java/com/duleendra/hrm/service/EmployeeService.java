package com.duleendra.hrm.service;

import com.duleendra.hrm.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findOne(Long id);

    Employee update(Employee employee);

    void delete (Long id);

}
