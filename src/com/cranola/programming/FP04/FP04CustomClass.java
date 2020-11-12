package com.cranola.programming.FP04;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.cranola.programming.HelperClass.*;


public class FP04CustomClass {

    public static void main(String[] args) {

        Course dummyCourse = new Course("Dummy", "Cloud", 94, 13000);

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 23000),
                new Course("Microservices", "Microservices", 93, 26000),
                new Course("FullStack", "FullStack", 91, 40000),
                new Course("AWS", "Cloud", 99, 20000),
                new Course("Azure", "Cloud", 98, 40000),
                new Course("Docker", "Cloud", 94, 13000),
                new Course("Kubernetes", "Cloud", 91, 24000)
        );

        //allMatch, noneMatch, anyMatch
        // Predicates

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;


        // allMatch do all elements match a condition

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        // none match, do no elements match a condition
        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan90Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        //anyMatch, do any elements match a condition
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));


        // Sorting
        //Comparators
        Comparator<Course> comparingByNumberOfStudentsIncreasing
                = Comparator.comparingInt(Course::getNumOfStudents).reversed();
        Comparator<Course> comparingByNumberOfStudentsAndReviewScore
                = Comparator.comparingInt(Course::getNumOfStudents)
                .thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(
                courses.stream().sorted(comparingByNumberOfStudentsIncreasing).collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNumberOfStudentsAndReviewScore).collect(Collectors.toList())
        );

        //skip, limit, takeWhile and dropWhile

        // limit
        // try to pick up the top five things
        System.out.println(
                courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .limit(5)
                .collect(Collectors.toList())
        );

        //skip
        // for example, skip the top three results. Like limit but reversed

        System.out.println(
                courses.stream()
                        .sorted(comparingByNumberOfStudentsAndReviewScore)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        System.out.println(courses);
        // take while
        // for example take all the elements until you find a course with a review score of less than 95
        System.out.println(
                courses.stream()
                .takeWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())
        );

        // dropWhile
        // don't take elements until you find a course with a review score of less than 95
        System.out.println(
                courses.stream()
                .dropWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList())
        );

        // box standard list for comparing max and min
        System.out.println(
                courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviewScore)
                .collect(Collectors.toList())
        );

        // max
        // a little counterintutive
        // what it does is return an optional of the last element in a list after sorting
        // so the max depends on your comparator
        // reversing is
        System.out.println(
                courses.stream()
                .max(comparingByNumberOfStudentsAndReviewScore)
        );

        // min
        // gets the first element of your list after sorting
        System.out.println(
                courses.stream()
                .min(comparingByNumberOfStudentsAndReviewScore)
        );

        //findFirst
        // find an optional of the first element that meets some criteria
        System.out.println(
                courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findFirst()
                .orElse(dummyCourse)
        );

        // findAny
        // find an optional of any of the elements that match the criteria
        // generally in non parallel streams this is the same as find first but doesn't have to be
        // much more random in parallel. findFirst behaves consistently in parallel
        System.out.println(
                courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findAny()
                .orElse(dummyCourse)
        );

        // sum
        // want to find the total number of students who have review score greater than 95
        System.out.println(
                courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNumOfStudents)
                .sum()
        );

        // average
        // find the average number os students in these courses
        // returns an optional because there is a chance that there won't
        // be any courses and you can't divide by zero
        // sum is fine because if there are no courses it can just be zero

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNumOfStudents)
                        .average()
        );

        // max (more familiar type of max)
        // max number of people in these courses

        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNumOfStudents)
                        .max()
        );

        // min really similar
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNumOfStudents)
                        .min()
        );

        // so useful, you can pull things out of the objects and do comparisons


        // grouping the courses into maps
        // for example, say you wanted to make a hashmap of all the courses that
        // are sorted by category, seems useful right?
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        // say you want to find out how many are in each group?
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))

        );

        // say you wanted to find the highest reviews in each category
        System.out.println(
                courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(
                                Comparator.comparing(Course::getReviewScore)
                        )))
        );

        // say you wanted to map a list of the names of the courses

        System.out.println(
                courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())))
        );

        // mother fuck I need to look into collectors











    }
}


