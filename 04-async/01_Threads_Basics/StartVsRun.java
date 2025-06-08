public class StartVsRun {
    public static void main(String[] args) {
        // Create a thread
        Thread thread = new Thread(() -> {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        });

        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Using run() - executes in the current thread
        System.out.println("\nCalling run():");
        thread.run(); // Executes in main thread

        // Using start() - creates a new thread
        System.out.println("\nCalling start():");
        thread.start(); // Executes in new thread

        // Demonstrate that run() can be called multiple times
        System.out.println("\nCalling run() again:");
        thread.run(); // Can be called multiple times

        // Demonstrate that start() can only be called once
        System.out.println("\nTrying to call start() again:");
        try {
            thread.start(); // Will throw IllegalThreadStateException
        } catch (IllegalThreadStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Wait for the thread to complete
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 