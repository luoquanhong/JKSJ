import com.threadUtils.TicketRunnableTask;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    @Test
    public void testCase_01(){
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
