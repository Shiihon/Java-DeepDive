package org.example.javaDeepDive1.homeExcersizeLambdaStream.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class    Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // IMPERATIVE APPROACH ❌ ______________________________________________________

    /*
    List<Person> females = new ArrayList<>();

    for (Person person : people) {

      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }
    females.forEach(System.out::println);
     - OBS. defining every single step for what you're trying to achieve.
    */

        // DECLARATIVE APPROACH ✅______________________________________________________

        // Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //females.forEach(System.out::println);

        // Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        //sorted.forEach(System.out::println);

        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        //System.out.println(allMatch);

        // Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        // System.out.println(anyMatch);

        // None match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        //System.out.println(noneMatch);

        // Max
        people.stream()
                .max(Comparator.comparing(person -> person.getAge()))
                .ifPresent(person -> {
                    //  System.out.println(person);;
                });

        // Min
        people.stream()
                .min(Comparator.comparing(person -> person.getAge()))
                .ifPresent(person -> {
                    // System.out.println(person);;
                });

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

//       groupByGender.forEach((gender, people1) -> {
//           System.out.println(gender);
//           people1.forEach(System.out::println);
//           System.out.println(); // bare et mellemrum.
//       });

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleAge.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

}
