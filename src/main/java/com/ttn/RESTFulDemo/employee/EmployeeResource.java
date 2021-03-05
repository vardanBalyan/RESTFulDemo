package com.ttn.RESTFulDemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping(path = "/employee")
    public List<Employee> getAllEmployees()
    {
        return service.findAllEmployees();
    }

    @GetMapping(path = "/employee/{id}")
    public Employee getOneEmployee(@PathVariable int id)
    {
        return service.getOneEmployee(id);
    }

}
