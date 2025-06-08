import java.util.concurrent.*;
import java.util.function.Supplier;

public class FutureLimitations {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Limitation 1: No way to chain futures
        Future<String> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return "First result";
        });

        // Limitation 2: No way to combine futures
        Future<String> future2 = executor.submit(() -> {
            Thread.sleep(1500);
            return "Second result";
        });

        // Limitation 3: Blocking get() method
        try {
            // This blocks the main thread
            String result1 = future1.get();
            System.out.println("Result 1: " + result1);
            
            // This also blocks
            String result2 = future2.get();
            System.out.println("Result 2: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Limitation 4: No way to handle exceptions in a non-blocking way
        Future<String> future3 = executor.submit(() -> {
            Thread.sleep(1000);
            throw new RuntimeException("Task failed");
        });

        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception caught: " + e.getCause().getMessage());
        }

        // Limitation 5: No way to manually complete a future
        Future<String> future4 = executor.submit(() -> {
            Thread.sleep(2000);
            return "This will take time";
        });

        // We can't complete future4 manually if we want to
        // We can only cancel it
        future4.cancel(true);

        // Shutdown executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
} 