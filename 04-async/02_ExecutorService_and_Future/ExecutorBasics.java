import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorService 基础示例
 * 展示了两种常用的线程池类型：
 * 1. 固定大小的线程池 (FixedThreadPool)
 * 2. 单线程执行器 (SingleThreadExecutor)
 */
public class ExecutorBasics {
    public static void main(String[] args) {
        // 创建一个固定大小为3的线程池
        // 这意味着同时最多有3个线程在运行
        System.out.println("固定大小线程池示例:");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        // 提交5个任务到固定大小线程池
        // 由于线程池大小为3，所以任务会排队等待执行
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("任务 " + taskId + " 在线程: " + 
                                 Thread.currentThread().getName() + " 上运行");
                try {
                    // 模拟任务执行时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 如果线程被中断，重新设置中断标志
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 创建一个单线程执行器
        // 所有任务都会按顺序在同一个线程中执行
        System.out.println("\n单线程执行器示例:");
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        
        // 提交3个任务到单线程执行器
        // 这些任务会按顺序一个接一个地执行
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            singleThread.submit(() -> {
                System.out.println("任务 " + taskId + " 在线程: " + 
                                 Thread.currentThread().getName() + " 上运行");
                try {
                    // 模拟任务执行时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 如果线程被中断，重新设置中断标志
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 优雅关闭线程池
        // 不再接受新任务，但会等待已提交的任务完成
        fixedPool.shutdown();
        singleThread.shutdown();

        try {
            // 等待所有任务完成，最多等待5秒
            if (!fixedPool.awaitTermination(5, TimeUnit.SECONDS)) {
                // 如果5秒后还有任务没完成，强制关闭
                fixedPool.shutdownNow();
            }
            if (!singleThread.awaitTermination(5, TimeUnit.SECONDS)) {
                // 如果5秒后还有任务没完成，强制关闭
                singleThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 如果等待过程中被中断，立即关闭所有线程池
            fixedPool.shutdownNow();
            singleThread.shutdownNow();
            // 重新设置中断标志
            Thread.currentThread().interrupt();
        }
    }
} 