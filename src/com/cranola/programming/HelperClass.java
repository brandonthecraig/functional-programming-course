package com.cranola.programming;

import java.util.ArrayList;
import java.util.List;

public class HelperClass {

    public static List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

    public static List<String> modifiableCourses = new ArrayList<>(courses);

    public static List<Integer> staticNumbers = List.of(1, 2, 5, 2, 56, 42, 35, 57, 3, 4, 56, 103,  8, 211, 35);

    public static void printBreak() {
        System.out.println("---------");
    }

    public static void printExerciseNumber(int number) {
        System.out.println("Exercise number " + number);
    }
}
