package com.ttn.RESTFulDemo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        Employee employee =service.getOneEmployee(id);

        if(employee == null)
            throw new EmployeeNotFoundException("id-"+id);
        return employee;
    }

    @PostMapping(path = "/employee")
    public void addEmployee(@Valid @RequestBody Employee employee)
    {
        service.save(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
        Employee employee = service.delete(id);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee doesn't exist");
    }

    @PutMapping(path = "/employee")
    public void updateEmployee(@Valid @RequestBody Employee emp)
    {
        Employee employee = service.update(emp);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee not found");
    }
}
