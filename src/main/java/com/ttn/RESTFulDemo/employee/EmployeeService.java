package com.ttn.RESTFulDemo.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();
    private static int employeeIdCounter=3;
    static {
        employees.add(new Employee(1,"vardan",23));
        employees.add(new Employee(2,"shubham",21));
        employees.add(new Employee(3,"abhay",26));
    }

    public List<Employee> findAllEmployees(){
        return employees;
    }

    public Employee getOneEmployee(int id)
    {
        for (Employee employee: employees) {
            if(employee.getId() == id)
                return employee;
        }
        return null;
    }
}
