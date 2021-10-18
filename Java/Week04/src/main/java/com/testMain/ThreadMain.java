package com.testMain;

import com.threadUtils.NumberTask;
import com.threadUtils.NumberTaskRunnable;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 1; i <= 5; i++) {
            executorService.submit(() -> {
                System.out.println(String.format("the thread id is: %d, the uuid is: %s", Thread.currentThread().getId(), UUID.randomUUID().toString().replaceAll("-", "")));
//            new TicketRunnableTask().run();
            });
        }
        executorService.shutdown();

//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        List<String> resultList = new CopyOnWriteArrayList<>();
//        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
//            for (int i = 1; i <= 10; i++) {
//                resultList.add(new NumberTask().getUUID());
//            }
//            return resultList;
//        }, executorService);
//        System.out.println(resultList.toString());




    }


}
