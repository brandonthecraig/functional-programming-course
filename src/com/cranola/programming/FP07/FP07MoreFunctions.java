package com.cranola.programming.FP07;

import com.cranola.programming.HelperClass;

import java.util.ArrayList;
import java.util.List;

public class FP07MoreFunctions {

    public static void main(String[] args) {

        List<String> modifiableCourses = new ArrayList<>(HelperClass.modifiableCourses);

        System.out.println(modifiableCourses.toString());

        // say you want to run through a list and modify everything along the way

        modifiableCourses.replaceAll(
                str -> str.toUpperCase()
        );

        System.out.println(modifiableCourses.toString());


        // can run through a list and remove things along the way

        modifiableCourses.removeIf(course -> course.length()<6);

        System.out.println(modifiableCourses.toString());



    }

}
