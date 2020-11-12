package com.cranola.programming.FP05;

import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05CreatingStreams {

    public static void main(String[] args) {

        // video 1 streams with lists

        // can go straight to a stream

        // 12, 9, 14, 5, 7, 2, 8, 23, 4

        System.out.println(Stream.of(12, 9, 14, 5, 7, 2, 8, 23, 4).count());

        System.out.println(Stream.of(12, 9, 14, 5, 7, 2, 8, 23, 4).reduce(0, Integer::sum));

        // say you want to make this without boxing it into Integer

        int[] numberArray = {12, 9, 14, 5, 7, 2, 8, 23, 4};

        System.out.println(Arrays.stream(numberArray).sum());
        System.out.println(Arrays.stream(numberArray).min());
        System.out.println(Arrays.stream(numberArray).max());

        // create streams dynamically


        // Video 2 streams with dynamically generated numbers

        IntStream oneToTen = IntStream.range(1, 10);
        IntStream oneToTenInclusive = IntStream.rangeClosed(1, 10);
        // stream that starts at 1, goes up by 2 each time, is limited to 10 values, and shows the values
        IntStream algorithmValues = IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println);
        IntStream firstTenEvenValues = IntStream.iterate(2, e -> e + 2).limit(10).peek(System.out::println);
        IntStream firstTenPowersOfTwo = IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println);
        // can convert primitives to lists by putting them into a wrapper class with .boxed
        List<Integer> firstTenPowersOfTwoList = IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());

        System.out.println(oneToTen.sum());

        System.out.println(oneToTenInclusive.sum());

        System.out.println(algorithmValues.sum());

        System.out.println(firstTenEvenValues.sum());

        System.out.println(firstTenPowersOfTwo.sum());

        // vid three
        // big integers
        // can change IntStream to DoubleStream or LongStream to up the limit

        int firstFiftyMultiplied = IntStream.rangeClosed(1, 50).reduce(1, (x, y) -> x *y);

        System.out.println(firstFiftyMultiplied);

        // can use big integers for this
        LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);





    }


}
