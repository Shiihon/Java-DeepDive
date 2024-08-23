package org.example.javaDeepDive1.javaGenerics;

public class Printer<T> {// parameter type of thing it can be able to hold.
    //If I want to make a bound generic, saying it has to take any object that relates to animal it is written as:
    // public class Printer <T extends Animal>
    // can also be with interfaces: Printer <T extends Animal & Serializable>
    //Only one class and all the interfaces you want seperated by &.
    //Always class first

    T thingtoPrint;

    public Printer(T thingtoPrint) {
        this.thingtoPrint = thingtoPrint;

    }

    public void print() {
        //When T extends animal this can be called too:
        //thingToPRint.eat(); - since it is a part of the Animal class
        System.out.println(thingtoPrint);
    }

}
