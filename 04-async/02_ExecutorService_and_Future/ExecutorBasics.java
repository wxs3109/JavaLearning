import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorBasics {
    public static void main(String[] args) {
        // Fixed thread pool
        System.out.println("Fixed Thread Pool Example:");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskId + " running on thread: " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Single thread executor
        System.out.println("\nSingle Thread Executor Example:");
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            singleThread.submit(() -> {
                System.out.println("Task " + taskId + " running on thread: " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown executors
        fixedPool.shutdown();
        singleThread.shutdown();

        try {
            // Wait for tasks to complete
            if (!fixedPool.awaitTermination(5, TimeUnit.SECONDS)) {
                fixedPool.shutdownNow();
            }
            if (!singleThread.awaitTermination(5, TimeUnit.SECONDS)) {
                singleThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            fixedPool.shutdownNow();
            singleThread.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
} 