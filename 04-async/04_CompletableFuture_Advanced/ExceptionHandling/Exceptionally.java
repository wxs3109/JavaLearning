import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exceptionally {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Basic exceptionally example
        System.out.println("Basic exceptionally example:");
        CompletableFuture<Object> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            throw new RuntimeException("Task 1 failed");
        }, executor)
        .exceptionally(ex -> {
            System.out.println("Handling exception: " + ex.getMessage());
            return "Recovery value";
        });

        // Chaining with exceptionally
        System.out.println("\nChaining with exceptionally example:");
        CompletableFuture<Object> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            return "Success";
        }, executor)
        .thenApply(s -> {
            System.out.println("Task 3 running on thread: " + Thread.currentThread().getName());
            throw new RuntimeException("Task 3 failed");
        })
        .exceptionally(ex -> {
            System.out.println("Handling exception: " + ex.getMessage());
            return "Recovery from chain";
        });

        // Multiple exceptionally handlers
        System.out.println("\nMultiple exceptionally handlers example:");
        CompletableFuture<Object> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 4 running on thread: " + Thread.currentThread().getName());
            throw new RuntimeException("Task 4 failed");
        }, executor)
        .exceptionally(ex -> {
            System.out.println("First handler: " + ex.getMessage());
            throw new RuntimeException("First handler failed");
        })
        .exceptionally(ex -> {
            System.out.println("Second handler: " + ex.getMessage());
            return "Final recovery";
        });

        // Exceptionally with async operations
        System.out.println("\nExceptionally with async operations example:");
        CompletableFuture<Object> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 5 running on thread: " + Thread.currentThread().getName());
            throw new RuntimeException("Task 5 failed");
        }, executor)
        .thenApplyAsync(s -> {
            System.out.println("Task 6 running on thread: " + Thread.currentThread().getName());
            return (Object)(s + " transformed");
        }, executor)
        .exceptionally(ex -> {
            System.out.println("Async exception handler: " + ex.getMessage());
            return "Async recovery";
        });

        // Print results
        try {
            System.out.println("\nResults:");
            System.out.println("Basic recovery: " + future1.get());
            System.out.println("Chain recovery: " + future2.get());
            System.out.println("Multiple handlers: " + future3.get());
            System.out.println("Async recovery: " + future4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 