package org.example.javaDeepDive1.javaGenericInSchool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String name;
    private int age;

    public static List<Employee> populateEmployee() {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        // Sample list of names
        String[] names = {"John", "Jane", "Alex", "Emily", "Chris", "Olivia", "Michael", "Sophia", "Daniel", "Emma"};

        // Generate 10 random employees
        for (int i = 0; i < 10; i++) {
            String randomName = names[random.nextInt(names.length)];
            int randomAge = random.nextInt(50) + 20; // Generate age between 20 and 69
            employees.add(new Employee(randomName, randomAge));
        }
        return employees;
    }
}
