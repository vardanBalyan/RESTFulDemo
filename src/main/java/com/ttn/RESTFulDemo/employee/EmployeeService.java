package com.ttn.RESTFulDemo.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* EmployService class - in this class we write the methods
* to provide store and manipulate the data of employees
* which will be used by the REST services.*/
@Component
public class EmployeeService {

    /*
    * Creating an arraylist to store the data of employees*/
    private static List<Employee> employeeList = new ArrayList<>();
    /*
    * Making an employeeIdCounter, it will be used when we add new
    * users to the arraylist and will assign the id to the employee
    * using the method.
    *
    * Since in static block we have added 3 items in the list so we're
    * initializing with value 3.*/
    private static int employeeIdCounter=3;
    /*
    * using static block to insert some data of employees in
    * the at the compile time*/
    static {
        employeeList.add(new Employee(1,"vardan",23));
        employeeList.add(new Employee(2,"shubham",21));
        employeeList.add(new Employee(3,"abhay",26));
    }

    /*
    * It return all existing employees in the list*/
    public List<Employee> findAllEmployees(){
        return employeeList;
    }

    /*
    * returns specific employee form the list*/
    public Employee getOneEmployee(int id)
    {
        for (Employee employee: employeeList) {
            if(employee.getId() == id)
                return employee;
        }
        return null;
    }

    /*
    * add new employee to the list*/
    public Employee save(Employee employee) {
        employee.setId(++employeeIdCounter);
        employeeList.add(employee);
        return employee;
    }

    /*
    * delete existing user from the list*/
    public Employee delete(int id)
    {
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while (employeeIterator.hasNext())
        {
            Employee employee = employeeIterator.next();
            if(employee.getId() == id)
            {
                employeeIterator.remove();
                return employee;
            }
        }
        return null;
    }

    /*
    * update the information of employee in the list*/
    public Employee update(Employee emp)
    {
        for (Employee employee: employeeList) {
            if(employee.getId() == emp.getId()) {
                employee.setName(emp.getName());
                employee.setAge(emp.getAge());
                return employee;
            }
        }
        return null;
    }
}
