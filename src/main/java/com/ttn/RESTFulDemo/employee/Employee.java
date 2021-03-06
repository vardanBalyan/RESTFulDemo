package com.ttn.RESTFulDemo.employee;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*
* Making an employee class having the id, name, age as the data
* members of the class.*/
public class Employee {
    private int id;
    /*
    * using the validation api to validate the size of string
    * using the @Size annotation*/
    @Size(min = 3)
    private String name;
    /*
    * using @Positive annotation of validation api to check
    * if age entered s positive or not*/
    @Positive
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
