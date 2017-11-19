package com.duleendra.hrm.controller;

import com.duleendra.hrm.model.Employee;
import com.duleendra.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, value = "/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employeeRequest) {
        Employee employee = employeeService.save(employeeRequest);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employeeRequest) {
        employeeRequest.setId(id);
        Employee employee = employeeService.update(employeeRequest);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/list")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll();
        return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Long id) {
        Employee employee = employeeService.findOne(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id) {
        String statusMsg="Record deleted successfully";
        employeeService.delete(id);
        return new ResponseEntity<String>(statusMsg, HttpStatus.OK);

    }
}
