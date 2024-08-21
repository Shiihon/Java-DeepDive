package org.example.javaDeepDive1.bonusExcersize;

import java.util.*;
import java.util.stream.Collectors;

public class DataCollection {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

        // Calculate the average age of all employees.
        OptionalDouble averageAge = employees.stream()
                .mapToInt(Employee::getAge)
                .average();
        if (averageAge.isPresent()) {
            System.out.printf("The average age of all employees are : %.2f %n ", averageAge.getAsDouble());
        } else {
            System.out.println("The average age of all employees cannot be calculated");
        }

        System.out.println(); //space


        // Find the employee with the highest salary.
        employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(employee ->
                        System.out.printf("Employee with the highest salary is : %s,  %.2f%n", employee.getName(), employee.getSalary()));

        System.out.println(); //space


        // Group employees by department and calculate the average salary for each department.
        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        averageSalaryByDepartment.forEach((department, avgSalary) ->
                System.out.printf("Department: %s, Average Salary: %.2f%n", department, avgSalary));

        System.out.println(); //space


        // Count the number of employees in each department.
        Map<String, Long> numberOfEmployeesInDepartments = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        numberOfEmployeesInDepartments.forEach((department, count) ->
                System.out.printf("Department : %s, Number of employees : %d%n", department, count));

        System.out.println(); //space


        // Find the three oldest employees.
        List<Employee> threeOldestEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .limit(3)
                .toList();
        System.out.println("The 3 oldest employees are --> ");

        threeOldestEmployees.forEach(employee ->
                System.out.printf("Name: %s, Age: %d%n", employee.getName(), employee.getAge()));

        System.out.println(); //space


        // Filter and display employees whose salary is above a certain threshold.
        List<Employee> employeesWithACertainSalary = employees.stream()
                .filter(employee -> employee.getSalary() >= 80000)
                .toList();
        employeesWithACertainSalary.forEach(employee ->
                System.out.printf("Employee: %s, Salary: %.2f%n", employee.getName(), employee.getSalary()));
    }

    private static List<Employee> getEmployees() {
        return List.of(
                new Employee("Alice", 30, "Engineering", 75000),
                new Employee("Bob", 45, "Human Resources", 60000),
                new Employee("Charlie", 28, "Marketing", 50000),
                new Employee("Diana", 35, "Finance", 80000),
                new Employee("Evan", 40, "Engineering", 85000),
                new Employee("Fiona", 32, "Marketing", 55000),
                new Employee("George", 50, "Management", 95000)
        );
    }
}
