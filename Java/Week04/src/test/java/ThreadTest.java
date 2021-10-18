import com.threadUtils.NumberTask;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;


public class ThreadTest {

    /**
     * 这是第一道必做题
     */


    @Test
    public void testCase_CompleteFuture_01() {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> new NumberTask().getUUID());
        try {
            String uuidValue = (String) completableFuture.get(2, TimeUnit.SECONDS);
            System.out.println(uuidValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase_CompleteFutureWithThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> resultList = new CopyOnWriteArrayList<>();
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> new NumberTask().getUUID(), executorService).exceptionally((e) -> {
            System.out.println(e);
            return String.valueOf(false);
        });
        try {
            String uuidValue = (String) completableFuture.get(2, TimeUnit.SECONDS);
            resultList.add(uuidValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(resultList);
    }

    @Test
    public void testCase_CompleteFutureWithMultithreading() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<String> resultList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Future<String> future = executorService.submit(() -> new NumberTask().getUUID());
            try {
                String tmpValue = future.get(2, TimeUnit.SECONDS);
                resultList.add(tmpValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println(resultList);
    }
}
