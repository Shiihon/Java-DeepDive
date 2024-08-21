package org.example.javaDeepDive1.homeExcersizeLambdaStream.lambdas;

public class Lambdas {
    public static void main(String[] args) {
        // Cat myCat = new Cat();
        //myCat.print();
        // printThing(myCat);

        // we don't need return type, name or if its public/static and so on.
        // to make it a valid Lambda syntax we add the arrow, between paramters and method impl.
        // BEFORE MAKING A VARIABLE:  printThing(() -> System.out.println("Meow"));
        // Now we can save it as a variable:
       // Printable lambdaPrint = (s) -> {System.out.println("Meow " + s);
        Printable lambdaPrint = (s) -> "Meow " + s;
        // When it has a return value (Look up)

        // Now call it with that variable:
        printThing(lambdaPrint);
        // Lambda implementations makes it possible to make a method into a variable. And passed in methods as parameters.



    }

    static void printThing (Printable thing){
        thing.print("!");
    }
}
