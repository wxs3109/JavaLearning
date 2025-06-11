import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        AtomicInteger counter = new AtomicInteger(0);

        // Submit Callable tasks
        Future<Integer> future1 = executor.submit(() -> {
            Thread.sleep(1000);
            return counter.incrementAndGet(); // what is counter? 
        });

        Future<Integer> future2 = executor.submit(() -> {
            Thread.sleep(2000);
            return counter.incrementAndGet();
        });

        Future<Integer> future3 = executor.submit(() -> {
            Thread.sleep(1500);
            return counter.incrementAndGet();
        });

        // Get results from futures
        try {
            System.out.println("Future 1 result: " + future1.get());
            System.out.println("Future 2 result: " + future2.get());
            System.out.println("Future 3 result: " + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Demonstrate Future methods
        Future<String> future4 = executor.submit(() -> {
            Thread.sleep(1000);
            return "Task completed";
        });

        try {
            // Check if task is done
            System.out.println("\nIs future4 done? " + future4.isDone());
            
            // Get result with timeout
            String result = future4.get(2, TimeUnit.SECONDS);
            System.out.println("Future4 result: " + result);
            
            // Check if task is done after completion
            System.out.println("Is future4 done now? " + future4.isDone());
            
            // Try to cancel a completed future
            System.out.println("Can future4 be cancelled? " + future4.cancel(true));
            
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

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