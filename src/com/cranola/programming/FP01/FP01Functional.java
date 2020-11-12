package com.cranola.programming.FP01;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        numberPlayground(List.of(1, 2, 5, 3, 8, 511, 35));

    }

    private static void print(int number) {
        System.out.println(number);
    }
    private static void printBreakLine() {
        System.out.println("-----------");
    }

    private static boolean isEven(int number) {
        return number%2 ==0;
    }

    private static void numberPlayground(List<Integer> numbers) {
        // What to do? the approach for how to think in terms of functional programming
        // We basically need a stream of numbers
        // instead of [1, 2, 5, 4, whatever]
        // we use a stream, like this
        //1
        //2
        //5
        //6
        //4
        //.....

        // so what you do is create a stream then tell it to do something for each part of that stream
        numbers.stream()
                .forEach(FP01Functional::print);

        printBreakLine();
        // this is called a method reference, we're telling it what method to call
        // syntax here is ClassName::MethodName

        // here's some fun, you can also call system out by itself
        // ClassName = System.out
        // MethodName = println
         numbers.stream()
                 .forEach(System.out::println);

        printBreakLine();

         // printing even numbers using functional
        // so sick, you've got foreaches on one line
        // you've got if then on one line
        // so less nesty and nasty
        numbers.stream()
                // method reference to return boolean, no nead to integer -> isEven(integer)
                // with method references you're not actually calling it
                // you can tell this because you're not using ()
                // you are just referencing the method to be called you cheeky little bitch
                // filter basically says "check the boolean and if it's true go to the next line of code"
                .filter(FP01Functional::isEven)
                .forEach(System.out::println);

        printBreakLine();

        // can also do this lambdas
        // no need to create the whole method to deal with this, can get it to one line
        numbers.stream()
                .filter(number -> number%2 == 0)// filter and lambdas
                .forEach(System.out::println); // Method reference
        printBreakLine();

        // say you want to make changes to the numbers? can do this with mapping
        // we want to print the squares of even numbers
        numbers.stream()
                .filter(number -> number%2 == 0) // filtering out, replacing if statements
                .map(number -> number * number) // mapping, replacing modifications to elements
                .forEach(System.out::println); // for each, calling a method on each filtered and changed element



    }

}
