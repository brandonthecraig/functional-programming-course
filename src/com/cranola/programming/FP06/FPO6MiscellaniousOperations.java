package com.cranola.programming.FP06;

import com.cranola.programming.FP04.Course;
import com.cranola.programming.HelperClass;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FPO6MiscellaniousOperations {

    public static void main(String[] args) {

        // combine list into one string separated by a column
        List<String> courses = HelperClass.courses;

        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        // take list of strings and look at all the elements in the string

        // this is broke because string split returns a String arrays containing characters
        // we have a Stream of String Arrays
        // looks like this Stream[["S", "p", "r", "i"...], ["C", "o", "u", "r"...]]
        System.out.println(courses.stream().map(course -> course.split("")).collect(Collectors.toList()));

        // what we want is to convert it to a Stream of characters
        // can do this with a flatMap
        // Flatmap: each element of Stream replaced with content of mapped stream
        // with (Arrays::stream) we are replacing the Arrays with the stream of the array and combining them
        // ["S", "p", "r", "i"...] => "S","p","r","i"....
        // looks like this Stream["S", "p", "r", "i"..., "C", "o", "u", "r"...]
        // flattening the array of strings
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));

        // can also get distinct chars
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));


        // say we want to create pairs of courses with the same length

        List<String> courses2 = List.copyOf(courses);

        // create a list of lists with two elements, pairing each course to the other course
        // fucking complicated
        System.out.println(
        courses.stream().flatMap(course -> courses2.stream()
                // filter out based on length
                .filter(course2 -> course2.length()==course.length())
                .map(course2 -> List.of(course, course2))).
                //filter our perfect pairs
                filter(list -> !list.get(0).equals(list.get(1))).
                collect(Collectors.toList())
        );


        // part 2 creating higher order functions
        // basically a function that returns a function
        // check out these predicates that are the same but just use a different number
        Predicate<Course> reviewScoreGreaterThan95Predicate = createPredicateWithCutOffReviewScore(90);
        Predicate<Course> reviewScoreGreaterThan90Predicate = createPredicateWithCutOffReviewScore(90);
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        // lesson 3
        // functional code is amazing for performance
        // say you want to find courses greater than 11 chars, uppercase them, then find first course in that list


        // this shit is fucking cool, if you print it out you see that the first peek only prints out everything until it
        // finds the first element that meets the filter criteria
        // so it knows in that first filter that at the end it only wants the first element and won't bother getting any more than the one
        // so efficient it won't bother getting everything ever, it is smart and just grabs the thing that it wants
        // it filters, filters, filters, filters, until it gets the hit it wants.
        // then it carries it out to the end then knows that it has hit the end of everything

        // java streams are really lazy, if you were to remove the findFirst() nothing would print
        // it just creates a variable of a stream that chills until it hits a terminal execution
        // and because it doesn't do anything until it hits a terminal execution it knows what that execution is and can act accordingly
        System.out.println(
        courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length()>11)
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst()
        );




    }

    // this shit right here is your higher order function
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }




}
