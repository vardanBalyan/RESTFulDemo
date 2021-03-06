package com.ttn.RESTFulDemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
* this is rest controller class by which we perform different
* operations on the employee using the different types of requests
* by calling the EmployeeService class methods to provide the service
* for the employee class*/
@RestController
public class EmployeeResource {

    /*
    * autowiring the instance of EmployeeService class*/
    @Autowired
    private EmployeeService service;

    /*
    * Method implementing the GET request to get all the employees from the list*/
    @GetMapping(path = "/employee")
    public List<Employee> getAllEmployees()
    {
        return service.findAllEmployees();
    }

    /*
     * Method implementing the GET request to get a specific employee from the list using
     * path variable id*/
    @GetMapping(path = "/employee/{id}")
    public Employee getOneEmployee(@PathVariable int id)
    {
        Employee employee =service.getOneEmployee(id);

        if(employee == null)
            throw new EmployeeNotFoundException("Employee not found with id-"+id);
        return employee;
    }

    /*
     * Method implementing the POST request to add employee to the list*/
    @PostMapping(path = "/employee")
    public void addEmployee(@Valid @RequestBody Employee employee)
    {
        service.save(employee);
    }

    /*
     * Method implementing the DELETE request to delete a employee from the list*/
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
        Employee employee = service.delete(id);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee doesn't exist");
    }

    /*
     * Method implementing the PUT request to update an employee in the list*/
    @PutMapping(path = "/employee")
    public void updateEmployee(@Valid @RequestBody Employee emp)
    {
        Employee employee = service.update(emp);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee not found");
    }
}
