package com.cranola.programming.FP07;

public class FP07Threads {

    public static void main(String[] args) {

        // old school ways of running threads
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<10000; i++){
                    System.out.println(
                            Thread.currentThread().getId() + ":" + i
                    );
                }
            }
        };

        // using functions, a bit cleaner
        Runnable runnable2 = () -> {
            for(int i =0; i<10000; i++){
                System.out.println(
                        Thread.currentThread().getId() + ":" + i
                );
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();

    }
}
