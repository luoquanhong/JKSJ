package com.threadUtils;

import java.util.UUID;

public class NumberTask {

    public String getUUID(){
        System.out.println(String.format("the thread id is: %d", Thread.currentThread().getId()));
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
