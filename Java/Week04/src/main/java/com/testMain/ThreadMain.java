package com.testMain;
import com.threadUtils.TicketRunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 1; i <= 5; i++) {
            executorService.execute(() -> {
//                System.out.println(String.format("the thread id is: %d, the uuid is: %s", Thread.currentThread().getId(), UUID.randomUUID().toString().replaceAll("-", "")));
            new TicketRunnableTask().run();
            });
        }
        executorService.shutdown();
    }


}
