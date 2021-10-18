package com.threadUtils;

public class NumberTaskRunnable implements Runnable{


    @Override
    public void run() {
        NumberTask numberTask =new NumberTask();
        String uuidValue = numberTask.getUUID();
        Thread thread = Thread.currentThread();
        System.out.println(String.format("the thread id is: %d, the thread name is: %s, the uuid is: %s", thread.getId(), thread.getName(), uuidValue));
    }
}
