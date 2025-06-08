import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsync {
    public static void main(String[] args) {
        // Using default ForkJoinPool
        System.out.println("Using default ForkJoinPool:");
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Using custom executor
        System.out.println("\nUsing custom executor:");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);

        // Chaining multiple runAsync calls
        System.out.println("\nChaining runAsync calls:");
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 3.1 running on thread: " + Thread.currentThread().getName());
        })
        .thenRunAsync(() -> {
            System.out.println("Task 3.2 running on thread: " + Thread.currentThread().getName());
        })
        .thenRunAsync(() -> {
            System.out.println("Task 3.3 running on thread: " + Thread.currentThread().getName());
        });

        // Wait for all futures to complete
        CompletableFuture.allOf(future1, future2, future3).join();

        // Shutdown executor
        executor.shutdown();
    }
} 