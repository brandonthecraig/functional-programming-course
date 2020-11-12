package com.cranola.programming.FP01;

import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 5, 3, 8, 511, 35);
        printAllNumbersInListStructured(numbers);
        System.out.println("---------");
        printAllEvenNumbersInListStructured(numbers);


    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number: numbers) {
            System.out.println(number);
        }
    }

    // say you wanted to print even numbers in the list?
    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        // How to loop the numbers?
        for (int number: numbers) {
            if (number % 2 == 0){
                System.out.println(number);
            }

        }
    }

}
