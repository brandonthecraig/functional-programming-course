package com.cranola.programming.FP02;

import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 5, 3, 8, 511, 35);

        int sum = getSumOfNumbersUsingStructuredApproach(numbers);

        System.out.println(sum);

    }

    private static int getSumOfNumbersUsingStructuredApproach(List<Integer> numbers) {
        // how to loop
        // how to store the sum

        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }


}
