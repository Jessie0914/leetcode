package bingfa.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname Counter_2
 * @Description volatile
 * @Date 2020/7/22 1:48 下午
 * @Created by chiyue
 */
public class Counter_2 {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                count++;
            });
        }
        executorService.shutdown();

        Thread.sleep(500);
        System.out.println(count);
    }
}
