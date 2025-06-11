public class ThreadLifecycle {
    public static void main(String[] args) {
        try {
            // NEW state
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000); // Simulating some work
                    synchronized (ThreadLifecycle.class) { // what is this? synchronized is a keyword in java that is used to create a synchronized block
                        System.out.println("Thread is blocked...");
                        Thread.sleep(1000); // Simulating blocked state
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            });

            // Print initial state (NEW)
            System.out.println("Thread state after creation: " + thread.getState());

            // Start the thread (RUNNABLE)
            thread.start();
            System.out.println("Thread state after start: " + thread.getState());

            // Wait a bit to see RUNNABLE state
            Thread.sleep(100);

            // Print state while running
            System.out.println("Thread state while running: " + thread.getState());

            // Wait for thread to complete (TERMINATED)
            thread.join();
            System.out.println("Thread state after completion: " + thread.getState());

            // Demonstrate BLOCKED state
            Thread blockingThread = new Thread(() -> {
                synchronized (ThreadLifecycle.class) {
                    try {
                        System.out.println("Blocking thread acquired lock");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.err.println("Blocking thread interrupted: " + e.getMessage());
                    }
                }
            });

            Thread waitingThread = new Thread(() -> {
                synchronized (ThreadLifecycle.class) {
                    System.out.println("Waiting thread acquired lock");
                }
            });

            blockingThread.start();
            Thread.sleep(100); // Ensure blockingThread starts first
            waitingThread.start();
            Thread.sleep(100); // Ensure waitingThread starts

            System.out.println("Waiting thread state: " + waitingThread.getState()); // Should be BLOCKED

            // Wait for threads to complete
            blockingThread.join();
            waitingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }
} 