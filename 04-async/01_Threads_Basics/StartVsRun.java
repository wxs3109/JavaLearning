public class StartVsRun {
    public static void main(String[] args) {
        // Create a thread
        Thread thread = new Thread(() -> System.out.println("Thread running: " + Thread.currentThread().getName()));
        thread.start();
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Using run() - executes in the current thread
        System.out.println("\nCalling run():");
        thread.run(); // Executes in main thread

        // Using start() - creates a new thread
        System.out.println("\nCalling start():");
        Thread thread2 = new Thread(() -> System.out.println("New thread running: " + Thread.currentThread().getName()));
        thread2.start();
    }
}