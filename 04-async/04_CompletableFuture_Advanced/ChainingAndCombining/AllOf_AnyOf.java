import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.List;

public class AllOf_AnyOf {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // allOf example
        System.out.println("allOf example:");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 1";
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 2";
        }, executor);

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 3";
        }, executor);

        // Wait for all futures to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        
        // Process all results
        CompletableFuture<List<String>> allResults = allFutures.thenApply(v -> 
            Arrays.asList(
                future1.join(),
                future2.join(),
                future3.join()
            )
        );

        // anyOf example
        System.out.println("\nanyOf example:");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 4 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 4";
        }, executor);

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 5 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 5";
        }, executor);

        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 6 running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result 6";
        }, executor);

        // Wait for any future to complete
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future4, future5, future6);

        // Print results
        try {
            System.out.println("\nAll results:");
            List<String> results = allResults.get(5, TimeUnit.SECONDS);
            System.out.println("All futures completed: " + results);

            System.out.println("\nFirst completed result:");
            Object firstResult = anyFuture.get(5, TimeUnit.SECONDS);
            System.out.println("First completed: " + firstResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 