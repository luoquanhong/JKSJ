package com.threadUtils;

public class TicketTask {

    private static int originalTicket = 6;

    public void sellTicketWithVoid(){
        while (originalTicket > 0) {
            Thread thread = Thread.currentThread();
            System.out.println(String.format("the thread is: %d, the ticket number info is: %d", thread.getId(), originalTicket--));
        }
    }
}
