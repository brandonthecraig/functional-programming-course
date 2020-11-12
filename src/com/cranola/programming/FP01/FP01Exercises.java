package com.cranola.programming.FP01;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {

        numberExercises(List.of(1, 2, 5, 3, 8, 511, 35));
        wordExercises(List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes"));

    }

    private static void printBreakLine() {
        System.out.println("-----------");
    }

    private static void wordExercises(List<String> courses) {

        // Exercise 2 - print all courses
        courses.stream()
                .forEach(System.out::println);
        printBreakLine();

        // Exercise 3 - print only courses that contain the word Spring
        courses.stream()
                .filter(word -> word.contains("Spring"))
                .forEach(System.out:: println);
        printBreakLine();

        // Exercise 4 - print only courses that are at least four letters long
        courses.stream()
                .filter(word -> word.length() >= 4)
                .forEach(System.out:: println);
        printBreakLine();

        // Exercise 6 - print the number of characters in each course name
        courses.stream()
                .map(word -> word + " " + word.length())
                .forEach(System.out::println);
    }

    private static void numberExercises(List<Integer> numbers) {

        // Exercise 1 - print all odd numbers
        numbers.stream()
                .filter(number -> number%2 == 1)
                .forEach(System.out::println);

        printBreakLine();

        // Exercise 5 - print the cubes of only the odd numbers
        numbers.stream()
                .filter(number -> number%2 == 1)
                .map(number -> number * number * number)
                .forEach(System.out::println);
        printBreakLine();
    }
}
