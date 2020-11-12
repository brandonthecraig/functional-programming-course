package com.cranola.programming.FP06;

import java.util.stream.LongStream;

public class FP06Parallelizing {

    public static void main(String[] args) {

        // Vid 4 parallelization of Streams
        // being able to take advantage of multi core processing
        // say we want to add up a huge list of numbers, loads of processing power

        long time = System.currentTimeMillis();

        System.out.println(
                LongStream.range(0, 1000000000).parallel().sum()

        );

        // 2363 without parallelization
        // 316 with parallelization
        // this is a huge gain and is so simple to implement
        // this works well because parallel streams are stateless and can be split among multiple cores
        // say you were trying to foreach the old way, you would have a var called sum that you kept updating
            // if multiple things are trying to update it gets confused
        System.out.println(System.currentTimeMillis() - time);

    }
}
