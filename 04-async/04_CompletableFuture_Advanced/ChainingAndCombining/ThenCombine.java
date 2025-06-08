import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCombine {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Basic thenCombine example
        System.out.println("Basic thenCombine example:");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 running on thread: " + Thread.currentThread().getName());
            return "Hello";
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 running on thread: " + Thread.currentThread().getName());
            return "World";
        }, executor);

        CompletableFuture<String> combined = future1.thenCombine(future2, (s1, s2) -> {
            System.out.println("Combining results on thread: " + Thread.currentThread().getName());
            return s1 + " " + s2;
        });

        // Chaining multiple thenCombine
        System.out.println("\nChaining thenCombine example:");
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 3 running on thread: " + Thread.currentThread().getName());
            return 10;
        }, executor);

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 4 running on thread: " + Thread.currentThread().getName());
            return 20;
        }, executor);

        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 5 running on thread: " + Thread.currentThread().getName());
            return 30;
        }, executor);

        CompletableFuture<Integer> sum = future3
            .thenCombine(future4, (a, b) -> {
                System.out.println("First combine on thread: " + Thread.currentThread().getName());
                return a + b;
            })
            .thenCombine(future5, (partialSum, c) -> {
                System.out.println("Second combine on thread: " + Thread.currentThread().getName());
                return partialSum + c;
            });

        // Async version of thenCombine
        System.out.println("\nAsync thenCombine example:");
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 6 running on thread: " + Thread.currentThread().getName());
            return "Async";
        }, executor);

        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 7 running on thread: " + Thread.currentThread().getName());
            return "Combine";
        }, executor);

        CompletableFuture<String> asyncCombined = future6.thenCombineAsync(future7, (s1, s2) -> {
            System.out.println("Async combining on thread: " + Thread.currentThread().getName());
            return s1 + " " + s2;
        }, executor);

        // Wait for all futures to complete and print results
        try {
            System.out.println("\nResults:");
            System.out.println("Basic combine result: " + combined.get());
            System.out.println("Chained combine result: " + sum.get());
            System.out.println("Async combine result: " + asyncCombined.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
} 