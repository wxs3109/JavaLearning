import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCompose {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Basic thenCompose example
        System.out.println("Basic thenCompose example:");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            return "Hello";
        }, executor)
        .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            return s + " World";
        }, executor));

        // Chaining multiple thenCompose
        System.out.println("\nChaining thenCompose example:");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3 running on thread: " + Thread.currentThread().getName());
            return "Step 1";
        }, executor)
        .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 4 running on thread: " + Thread.currentThread().getName());
            return s + " -> Step 2";
        }, executor))
        .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 5 running on thread: " + Thread.currentThread().getName());
            return s + " -> Step 3";
        }, executor));

        // Async version of thenCompose
        System.out.println("\nAsync thenCompose example:");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 6 running on thread: " + Thread.currentThread().getName());
            return "Async";
        }, executor)
        .thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 7 running on thread: " + Thread.currentThread().getName());
            return s + " Compose";
        }, executor), executor);

        // Comparison with thenApply
        System.out.println("\nComparison with thenApply:");
        CompletableFuture<CompletableFuture<String>> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 8 running on thread: " + Thread.currentThread().getName());
            return "Nested";
        }, executor)
        .thenApply(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 9 running on thread: " + Thread.currentThread().getName());
            return s + " Future";
        }, executor));

        // Using thenCompose to flatten nested futures
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 10 running on thread: " + Thread.currentThread().getName());
            return "Nested";
        }, executor)
        .thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 11 running on thread: " + Thread.currentThread().getName());
            return s + " Future";
        }, executor));

        // Print results
        try {
            System.out.println("\nResults:");
            System.out.println("Basic compose result: " + future1.get());
            System.out.println("Chained compose result: " + future2.get());
            System.out.println("Async compose result: " + future3.get());
            System.out.println("Nested future result: " + future4.get().get());
            System.out.println("Flattened future result: " + future5.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 