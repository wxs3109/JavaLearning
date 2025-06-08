import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenApplyVsThenAccept {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // thenApply - transforms the result and returns a new CompletableFuture
        System.out.println("thenApply example:");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            return "Initial value";
        }, executor)
        .thenApply(s -> {
            System.out.println("Transforming value on thread: " + Thread.currentThread().getName());
            return s + " -> transformed";
        })
        .thenApply(s -> {
            System.out.println("Transforming again on thread: " + Thread.currentThread().getName());
            return s + " -> final";
        });

        // thenAccept - consumes the result and returns CompletableFuture<Void>
        System.out.println("\nthenAccept example:");
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            return "Result to consume";
        }, executor)
        .thenAccept(s -> {
            System.out.println("Consuming value on thread: " + Thread.currentThread().getName());
            System.out.println("Consumed value: " + s);
        });

        // thenRun - runs after completion, doesn't use the result
        System.out.println("\nthenRun example:");
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3 running on thread: " + Thread.currentThread().getName());
            return "Some result";
        }, executor)
        .thenRun(() -> {
            System.out.println("Running after completion on thread: " + Thread.currentThread().getName());
            System.out.println("This doesn't have access to the previous result");
        });

        // Chaining different types
        System.out.println("\nChaining different types:");
        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 4.1 running on thread: " + Thread.currentThread().getName());
            return 42;
        }, executor)
        .thenApply(i -> {
            System.out.println("Task 4.2 transforming on thread: " + Thread.currentThread().getName());
            return "Number: " + i;
        })
        .thenAccept(s -> {
            System.out.println("Task 4.3 consuming on thread: " + Thread.currentThread().getName());
            System.out.println("Consumed: " + s);
        })
        .thenRun(() -> {
            System.out.println("Task 4.4 running on thread: " + Thread.currentThread().getName());
            System.out.println("Final cleanup");
        });

        // Wait for all futures to complete
        CompletableFuture.allOf(future1, future2, future3, future4).join();

        // Get and print the result from future1
        try {
            System.out.println("\nFinal result from future1: " + future1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 