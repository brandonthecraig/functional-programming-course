package com.cranola.programming.FP03;


import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.cranola.programming.HelperClass.*;

public class FP03Exercises {

    public static void main(String[] args) {

        int sum = staticNumbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        printBreak();
        exercise12();

        printBreak();
        exercise13();


    }

    private static void exercise13() {
        printExerciseNumber(13);

        // Exercise 13
        // Do behaviour parameterisation for mapping logic

        List<Integer> squaredNumbers = mapppingFunction(staticNumbers, x->x*x);
        System.out.println(squaredNumbers.toString());

        List<Integer> cubedNumbers = mapppingFunction(staticNumbers, x-> x*x*x);
        System.out.println(cubedNumbers.toString());
    }

    private static List<Integer> mapppingFunction(List<Integer> numbers, Function<Integer, Integer> function){
        return numbers.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    private static void exercise12() {
        printExerciseNumber(12);

        // Exercise 12
        // create an implementation of the Functional Interface Integer::sum in the above example
        // It's summing so it's taking in two integers and returning a result
        // Internet research has shown me that this is something called a Binary Operator
        // it's gotta be the same type for the two things you are putting in
        BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        int sum =staticNumbers.stream().reduce(0, sumBinaryOperator);
        System.out.println(sum);
    }
}
