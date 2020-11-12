package com.cranola.programming.FP03;

import java.util.function.Supplier;

import static com.cranola.programming.HelperClass.*;

public class FP03MethodReferences {

    private static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {

        courses.stream()
                // can also call static methods on objects
                // this is sick, next level calling MR on objects themselves
//                .map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                // lovely little method reference
                // this is what we are comfy with
                // calling a static method as a method reference
                .forEach(FP03MethodReferences::print);


        // Constructer method references
        Supplier<String> supplier = () -> new String();

        Supplier<String> supplier1 = String::new;

    }
}
