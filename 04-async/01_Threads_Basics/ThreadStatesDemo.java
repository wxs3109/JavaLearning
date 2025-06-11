/**
 * 线程状态演示
 * 展示Java线程的六种状态：
 * 1. NEW - 新建状态
 * 2. RUNNABLE - 可运行状态
 * 3. BLOCKED - 阻塞状态
 * 4. WAITING - 等待状态
 * 5. TIMED_WAITING - 计时等待状态
 * 6. TERMINATED - 终止状态
 */
public class ThreadStatesDemo {
    // 用于演示BLOCKED状态的锁对象
    private static final Object lock = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        // 1. NEW状态演示
        Thread newThread = new Thread(() -> {
            System.out.println("这是一个新线程");
        });
        System.out.println("1. NEW状态: " + newThread.getState());

        // 2. RUNNABLE状态演示
        Thread runnableThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // 保持线程运行
            }
        });
        runnableThread.start();
        System.out.println("2. RUNNABLE状态: " + runnableThread.getState());

        // 3. BLOCKED状态演示
        Thread blockedThread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // 持有锁2秒
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        Thread blockedThread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("获得锁");
            }
        });

        blockedThread1.start();
        Thread.sleep(100); // 确保blockedThread1先获得锁
        blockedThread2.start();
        Thread.sleep(100); // 确保blockedThread2开始运行
        System.out.println("3. BLOCKED状态: " + blockedThread2.getState());

        // 4. WAITING状态演示
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // 进入WAITING状态
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        waitingThread.start();
        Thread.sleep(100);
        System.out.println("4. WAITING状态: " + waitingThread.getState());

        // 5. TIMED_WAITING状态演示
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // 进入TIMED_WAITING状态
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        timedWaitingThread.start();
        Thread.sleep(100);
        System.out.println("5. TIMED_WAITING状态: " + timedWaitingThread.getState());

        // 6. TERMINATED状态演示
        Thread terminatedThread = new Thread(() -> {
            System.out.println("线程即将结束");
        });
        terminatedThread.start();
        terminatedThread.join(); // 等待线程结束
        System.out.println("6. TERMINATED状态: " + terminatedThread.getState());

        // 清理其他线程
        runnableThread.interrupt();
        blockedThread1.join();
        blockedThread2.join();
        waitingThread.interrupt();
        timedWaitingThread.join();
    }
} 