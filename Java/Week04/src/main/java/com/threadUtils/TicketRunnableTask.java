package com.threadUtils;


public class TicketRunnableTask implements Runnable {

    @Override
    public void run() {
        TicketTask task = new TicketTask();
        task.sellTicketWithVoid();
        new TicketTask();
    }
}
