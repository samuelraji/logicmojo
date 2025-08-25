package com.org;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}


public class PracticeSolutions {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 75000)
        );

        List<String> names = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
