package com.cranola.programming.FP02;

import java.util.List;
import java.util.stream.Collectors;

import static com.cranola.programming.HelperClass.*;

public class FP02Exercises {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 5, 3, 4, 56, 102,  8, 211, 35);

        // Ex 7
        System.out.println(squareNumbersAndGetSumOfSquare(numbers));
        printBreak();

        // Ex 8
        System.out.println(cubeNumbersAndGetSumOfCubes(numbers));
        printBreak();

        // Ex 9
        System.out.println(findSumOfOddNumbersInAList(numbers));
        printBreak();

        // Ex 10 create a list with even numbers
        createListOfEvenNumbers(numbers);
        printBreak();


        // Ex 11 create a list with lengths of all the course titles
        createListOfLengthsOfCourseTitles(courses);



    }

    private static void createListOfLengthsOfCourseTitles(List<String> courses) {
        printExerciseNumber(11);
        System.out.println(courses);
        List<Integer> courseTitleLengths = courses.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(courseTitleLengths);
    }

    private static void createListOfEvenNumbers(List<Integer> numbers) {
        printExerciseNumber(10);
        System.out.println(numbers);
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }

    private static int findSumOfOddNumbersInAList(List<Integer> numbers) {
        printExerciseNumber(9);
        return numbers.stream()
                .filter(s -> s%2!=0)
                .reduce(0, Integer::sum);
    }

    private static int cubeNumbersAndGetSumOfCubes(List<Integer> numbers) {
        printExerciseNumber(9);
        return numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum);
    }


    private static int squareNumbersAndGetSumOfSquare(List<Integer> numbers) {
        printExerciseNumber(7);
        return numbers.stream()
                .map(number -> number * number)
                .reduce(0, Integer::sum);

    }


}
