public class ThreadCreation {
    // Extending Thread class
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread running: " + Thread.currentThread().getName());
        }
    }

    // Implementing Runnable interface
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable running: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // Method 1: Extending Thread
        MyThread thread1 = new MyThread();
        thread1.start();

        // Method 2: Implementing Runnable
        Thread thread2 = new Thread(new MyRunnable());
        thread2.setName("Thread-2");
        thread2.start();

        // Method 3: Anonymous Runnable
        Thread thread3 = new Thread(() -> System.out.println("Anonymous Runnable running: " + Thread.currentThread().getName()));
        thread3.setName("Thread-3");
        thread3.start();

        // Method 4: Lambda Runnable
        Thread thread4 = new Thread(() -> {
            System.out.println("Lambda Runnable running: " + Thread.currentThread().getName());
        });
        thread4.setName("Thread-4");
        thread4.start();

        // Main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
} 