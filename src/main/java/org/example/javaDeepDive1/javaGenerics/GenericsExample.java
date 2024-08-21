package org.example.javaDeepDive1.javaGenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        Printer <Integer> printer = new Printer<>(23);
        // <Integer> telling what type we want to print, and after we also use <> right after the class name.
        printer.print();

        // If we want to create a printer for double:
        Printer<Double> doublePrinter = new Printer<>(2.5);
        doublePrinter.print();

        //Generics does not work with primitive types as int and so on. Use Integer instead.
        // we have used it when doing ArrayLists

        shout(54);
        shout("Nanna");
        shout(2.5);

        //For the printList method.
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        doubleList.add(3.5);

        printList(intList);
        printList(doubleList);

    }
    //if we want java to print and put !!! behind everything with anything given to it
    private static <T> void shout(T thingToShout){
        System.out.println(thingToShout + "!!!!!");
    }

    //Example, we want to be able to take in any kind of list and be able to print that out.
    //? -> is a wildcard.
    // Can also be with extends to for ex. animal as in the other class.
    private static void printList(List<?> myList){
        System.out.println(myList);
    }
}
