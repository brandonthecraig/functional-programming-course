package com.cranola.programming.FP07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP07Files {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("exampleText")).forEach(System.out::println);

        // search through and get all distinct words sorted alphabetical
        // basiclaly when you get lines from a file they are put into a stream that you can then use
        Files.lines(Paths.get("exampleText"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // can also list all the files in a certain directory
        // can filter and print from this
        // say we want to get just directories
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

        // loads of  operations in the Files class that can be used to fuck about and filter by
        // quite cool


    }

}
