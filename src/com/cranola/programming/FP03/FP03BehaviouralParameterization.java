package com.cranola.programming.FP03;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.cranola.programming.HelperClass.staticNumbers;

public class FP03BehaviouralParameterization {


    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = staticNumbers;

        // can give the predicates a definition
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers, evenPredicate);

        Predicate<Integer> oddPredicate = x -> x % 2 != 0;
        filterAndPrint(numbers, oddPredicate);

        // Or just pass it straight through
        // passing the logic of the method as an argument of the method
        // That's why it's called behavioural parameterization
        // guns, you give it the bullet and the mechanism to fire it
        filterAndPrint(numbers, x -> x%2==0);



    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
