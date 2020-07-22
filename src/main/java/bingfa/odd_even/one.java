package bingfa.odd_even;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname one
 * @Description volatile关键字
 * @Date 2020/7/22 10:57 上午
 * @Created by chiyue
 */
public class one {
    private static volatile int count = 0;

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 打印偶数
        executorService.execute(() -> {
            while (count < 100) {
                if (flag) {
                    System.out.println(count);
                    count++;
                    flag = false;
                }
            }
        });

        // 打印奇数
        executorService.execute(()->{
            while (count < 100) {
                if (!flag) {
                    System.out.println(count);
                    count++;
                    flag = true;
                }
            }
        });

        executorService.shutdown();
    }
}
