package com.cranola.programming.FP02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.cranola.programming.HelperClass.*;

public class FP02Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 5, 2, 56, 42, 35, 57, 3, 4, 56, 103,  8, 211, 35);


        int sum = getSumOfNumbersUsingFunctionalApproach(numbers);
        System.out.println(sum);
        demonstrateSortingAndDistinctMethodsOnStreams(numbers);
        demonstrateSortingAndComparatorsOnStreamsWithString(courses);
        demonstrateSortingAndComparatorsOnStreamsWithInt(numbers);
        demonstrateColectionAStreamToAList(numbers);



    }

    private static void demonstrateColectionAStreamToAList(List<Integer> numbers) {
        System.out.println(numbers);
        List<Integer> numbersSquared = squareAndCollectNumberList(numbers);
        System.out.println(numbersSquared);
    }

    private static List<Integer> squareAndCollectNumberList(List<Integer> numbers) {
        return numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    private static void demonstrateSortingAndComparatorsOnStreamsWithInt(List<Integer> numbers) {
        printBreak();
        //reverse sorting
        numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        printBreak();

        // custom sorting
        numbers.stream()
                .distinct()
                .sorted(Comparator.comparing(num -> num.toString().length()))
                .forEach(System.out::println);
        printBreak();

        // custom sorting
        numbers.stream()
                .distinct()
                .sorted(Comparator.comparing(num -> num % 2 == 0))
                .forEach(System.out::println);
    }

    private static void demonstrateSortingAndComparatorsOnStreamsWithString(List<String> courses) {
        printBreak();
        // vanilla sorting, alphabetical
        courses.stream()
                .sorted()
                .forEach(System.out::println);
        printBreak();
        // sorting using comparators, specifying the normal order
        courses.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        printBreak();
        // sorted using comparators, reverse order
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        printBreak();
        // sorted using comparators, custom order
        courses.stream()
                .sorted(Comparator.comparing(str -> str.length()))
                .forEach(System.out::println);
    }

    private static void demonstrateSortingAndDistinctMethodsOnStreams(List<Integer> numbers) {
        printBreak();
        // can use distinct to eliminate any repeats from the stream
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
        printBreak();
        // can use sorted to sort the elements in the stream
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        printBreak();
        // these can be combined to clean up your elements
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static int sum(int a, int b) {
        System.out.println(a + " " + b);
        return a + b;
    }
    private static int getSumOfNumbersUsingFunctionalApproach(List<Integer> numbers) {

        return numbers.stream()

               //Starting with a Stream of numbers and want to combine it into one value
                // Stream -> one value
                // called a reduce operation in functional programming
                    //we want to combine them all into one value
                    // start with 0 and use FP02Functional::sum to add each part of the stream
//                .reduce(0, FP02Functional::sum)
        // can also do this with a lambda
//                .reduce(0, (x, y) -> x + y);
        // can also do this with a method reference to a prebuild method in the integer class
                .reduce(0, Integer::sum);
        // aside from cleaner code, why do this?
        // reduction operations parallelize very gracefully
            // this means they can take advantage of multicore cpus and run much faster
    }

    // Notes in general.

    // Intermediate operations - operations that alter a stream and then return the stream back. This is how you chain
    // modifications to a stream
    // include - distinct(), sorted(), map(), filter()
    // you can tell by the fact that the methods' return value is a Stream

    // Terminal operations - not operations on the terminal, more like operations that end the chain of things you can do for a stream
    // they return something that is not a stream so you can't do anything else to them
    // include - forEach() RETURNS VOID, collect() RETURNS A SPECIFIC TYPE, reduce() RETURN A SPECIFIC TYPE


}
