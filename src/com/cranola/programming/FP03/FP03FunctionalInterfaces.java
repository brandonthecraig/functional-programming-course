package com.cranola.programming.FP03;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static com.cranola.programming.HelperClass.*;

public class FP03FunctionalInterfaces {

    /**
     *
     * boolean isEven(int x) { return x %2 ==0;}
     *
     * int squared(int x) { return x* x;}
     */

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // functional interfaces are interfaces that contain one abstract method that describe what they do
        // the one abstract method returns a boolean and is called test
        // it's used to test things
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        // long version of Predicate that's happening with the lambda
        // its kind of crazy because under the hood the lamdas are kind of being build like objects
        // cause java is all super objecty
        // boolean return type
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        // takes in one argument and produces a result
        // takes in an input type and produces one result type
        Function<Integer, Integer> squareFunction = x -> x * x;

        // long version of function
        // the first diamond is what it takes in the input type and the second is the result type
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };

        // consumers consumes what it gets
        // takes in a single argument and returns nothing
        Consumer<Integer> sysOutConsumer = System.out::println;

        // long version of consumers
        // void return type
        Consumer<Integer> sysOutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        // Suppliers. No input but returns something
        Supplier <Integer> randomIntegerSupplier = ()-> {
            Random random = new Random();
            return random.nextInt(100);
        };

        System.out.println("RANDOM NUMBERS");
        System.out.println(randomIntegerSupplier.get());

        // UnaryOperator. Takes in one parameter and returns the result of the same type as the output
        UnaryOperator<Integer> unaryOperator = x -> 3 * x;

        System.out.println("Unary Operator");
        System.out.println(unaryOperator.apply(4));

        // BiPredicate basically a predicate with two arguments
        BiPredicate<Integer, Integer> greaterThanBiPredicate = (x, y) -> x > y;
        System.out.println("BiPredicate");
        System.out.println(greaterThanBiPredicate.test(4, 2));
        System.out.println(greaterThanBiPredicate.test(4, 4));
        System.out.println(greaterThanBiPredicate.test(4, 6));

        // BiFunction - function with two arguments.
        // returns a value
        BiFunction<Integer, Integer, Integer> multiplyNumbers = (x, y) -> x *y;
        BiFunction<String, Integer, String> combineNumberWithString = (x, y) -> x + y;
        System.out.println("BiFunction");
        System.out.println(multiplyNumbers.apply(3, 6));
        System.out.println(combineNumberWithString.apply("america", 4));

        // BiConsumer - consumer with two arguments
        // doesn't return anything
        BiConsumer<Boolean, String> ifTruePrint = (x, y) -> {if(x) System.out.println(y);};
        System.out.println("BiConsumer");
        ifTruePrint.accept(true, "Print this");
        ifTruePrint.accept(false, "Don't print this");

        // can also get Int* Long* and Double* functional interfaces
        // these are basically consumers, predicates, functions that all
        // use primitive types
        // this is handy because you don't have to specify AND you can use the primitives instead of the wrapper classes
        // using wrapper classes does all sorts of boxing and unboxing which can cause performance issues
        // primitives are just leaner


        staticNumbers.stream()
                .filter(isEvenPredicate) // lambdas
                .map(squareFunction)
                .forEach(sysOutConsumer); // static method reference
        // method references are basically just lambdas but simplified

    }
}
