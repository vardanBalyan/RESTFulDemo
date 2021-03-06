package com.ttn.RESTFulDemo.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employeeList = new ArrayList<>();
    private static int employeeIdCounter=3;
    static {
        employeeList.add(new Employee(1,"vardan",23));
        employeeList.add(new Employee(2,"shubham",21));
        employeeList.add(new Employee(3,"abhay",26));
    }

    public List<Employee> findAllEmployees(){
        return employeeList;
    }

    public Employee getOneEmployee(int id)
    {
        for (Employee employee: employeeList) {
            if(employee.getId() == id)
                return employee;
        }
        return null;
    }

    public void save(Employee employee) {
        employee.setId(++employeeIdCounter);
        employeeList.add(employee);
    }

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
