package org.example.javaDeepDive1.homeExcersizeLambdaStream.lambdas;

@FunctionalInterface // used whenhaving one, so the compiler will enforce that there is exactly ONE abstract method.
public interface Printable {

    String print(String suffix);
}

// Lambdas can only be used if there is an interface with exactly one abstract method in it.
