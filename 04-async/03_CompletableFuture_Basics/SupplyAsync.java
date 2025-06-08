import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SupplyAsync {
    public static void main(String[] args) {
        // Using default ForkJoinPool
        System.out.println("Using default ForkJoinPool:");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result from Task 1";
        });

        // Using custom executor
        System.out.println("\nUsing custom executor:");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 42;
        }, executor);

        // Chaining supplyAsync with thenApply
        System.out.println("\nChaining supplyAsync with thenApply:");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3.1 running on thread: " + Thread.currentThread().getName());
            return "Initial value";
        })
        .thenApply(s -> {
            System.out.println("Task 3.2 running on thread: " + Thread.currentThread().getName());
            return s + " -> transformed";
        })
        .thenApply(s -> {
            System.out.println("Task 3.3 running on thread: " + Thread.currentThread().getName());
            return s + " -> final";
        });

        // Get results
        try {
            System.out.println("\nResults:");
            System.out.println("Future 1 result: " + future1.get(2, TimeUnit.SECONDS));
            System.out.println("Future 2 result: " + future2.get(2, TimeUnit.SECONDS));
            System.out.println("Future 3 result: " + future3.get(2, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 